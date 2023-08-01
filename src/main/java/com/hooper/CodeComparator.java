package com.hooper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeComparator {

    private static final Map<String, String> CONSTANTS;
    private static final String CONSTANT_FILE_PATH = "/Users/felix/IdeaProjects/practice/src/main/java/com/hooper/CommonConstant.java";

    static {
        CONSTANTS = readConstantsFromFile(CONSTANT_FILE_PATH);
    }

    public static void main(String[] args) {
        System.out.println(containsConstant("dasCommonConstant.RET_CODE.OKsadASdasdRET_CODE.ERRORasdasdasdASsdsdSDsdAS"));
    }

    public static Map<String, String> readConstantsFromFile(String filePath) {
        Map<String, String> constantsMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String currentClassName = null;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("//") || line.startsWith("/*") || line.startsWith("*") || line.startsWith("*/")) {
                    continue;
                }
                if (!line.isEmpty()) {
                    if (line.contains("static class")) {
                        currentClassName = line.split("class ")[1].split(" ")[0];
                    } else if (currentClassName != null && line.contains("public static final String")) {
                        String constantName = line.split(" ")[4];
                        String constantValue = line.split("= ")[1].trim().replace(";", "");
                        String key = currentClassName + "." + constantName;
                        constantsMap.put(key, constantValue);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to read constants from file: " + filePath);
        }

        return constantsMap;
    }

    public static List<String> findConstantClasses(List<String> codeLines) {
        List<String> constantClasses = new ArrayList<>();
        String regex = "[a-zA-Z_][a-zA-Z0-9_]*(\\.[a-zA-Z_][a-zA-Z0-9_]*)+"; // Matches constant class patterns
        Pattern pattern = Pattern.compile(regex);

        for (String codeLine : codeLines) {
            Matcher matcher = pattern.matcher(codeLine);
            while (matcher.find()) {
                String constantClass = matcher.group();
                constantClasses.add(constantClass);
            }
        }

        return constantClasses;
    }

    public static List<String> getDiffFromConstants(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNum = 0;
            while ((line = reader.readLine()) != null) {
                lineNum++;
                if (line.contains("CommonConstant")) {
                    String constantName = line.split("CommonConstant.")[1].split("\\.")[1];
                    String constantValue = CONSTANTS.get(constantName);
                    if (constantValue != null) {
                        if (line.contains(constantValue)) {
                            System.out.println("Found constant: " + constantName + " in file: " + filePath);
                        } else {
                            System.out.println("Found constant: " + constantName + " in file: " + filePath + ", but the value is different.");
                        }
                    } else {
                        System.out.println("Found constant: " + constantName + " in file: " + filePath + ", but not found in CommonConstant.java");
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to read file: " + filePath);
        }
        return null;
    }

    public static String containsConstant(String line) {
        int bigLetterCount = 0, max = 0;
        int startIdx = 0, endIdx = 0;
        int preStartIdx = 0;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (Character.isUpperCase(c) || c == '_' || c =='.') {
                if (c =='.' && bigLetterCount == 0){
                    continue;
                }
                if (bigLetterCount == 0)
                    startIdx = i;
                bigLetterCount++;
            } else {
                if (bigLetterCount > max) {
                    max = bigLetterCount;
                    preStartIdx = startIdx;
                    endIdx = i;
                }
                bigLetterCount = 0;
            }
        }
        if (startIdx > endIdx){
            startIdx = preStartIdx;
        }
        return max >= 4 ? line.substring(startIdx, endIdx) : null;

    }
//    public static boolean containsConstantCall(String inputString) {
//        // 正则表达式匹配模式 "XXXX.XXXX"，其中点号两边至少有一个大写字母
//        String regex = "\\b[A-Za-z]*\\.[A-Za-z]+\\b";
//
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(inputString);
//
//        return matcher.find();
//    }

    public static boolean containsConstantCall(String inputString) {
        // 正则表达式匹配模式 "XXX.XXX"，其中连边都是全大写字母（可以含有下划线）
        String regex = "\\b[A-Z_]+\\.[A-Z_]+\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputString);

        return matcher.find();
    }
}
