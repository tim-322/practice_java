package com.hooper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class CodeComparator {

    private static final Map<String, String> CONSTANTS;
    private static final String CONSTANT_FILE_PATH = "/Users/felix/IdeaProjects/practice/src/main/java/com/hooper/CommonConstant.java";

    static {
        CONSTANTS = readConstantsFromFile(CONSTANT_FILE_PATH);
    }

    public static void main(String[] args) throws Exception {
        List<String> diffList = getDiffFromConstants("/Users/felix/IdeaProjects/practice/src/main/java/com/hooper/TestConstantOrg.java",
                "/Users/felix/IdeaProjects/practice/src/main/java/com/hooper/TestConstantModified.java");
        diffList.forEach(System.out::println);
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


    public static List<String> getDiffFromConstants(String orgPath, String modifiedPath) throws Exception {
        BufferedReader orgReader = new BufferedReader(new FileReader(orgPath));
        BufferedReader modifiedReader = new BufferedReader(new FileReader(modifiedPath));
        String orgLine = null;
        String modifiedLine = null;
        List<String> diffList = new ArrayList<>();
        List<String> orgLines = new ArrayList<>(), modifiedLines = new ArrayList<>();
        while ((orgLine = orgReader.readLine()) != null) {
            orgLines.add(orgLine.trim());
        }
        while ((modifiedLine = modifiedReader.readLine()) != null) {
            modifiedLines.add(modifiedLine.trim());
        }
        orgLines = filterList(orgLines);
        modifiedLines = filterList(modifiedLines);
        int orgIdx = 0, modifiedIdx = 0;
        while (orgIdx < orgLines.size() && modifiedIdx < modifiedLines.size()) {
            String org = orgLines.get(orgIdx++);
            String modified = modifiedLines.get(modifiedIdx++);
            if (org.equals(modified)) continue;
            Set<String> modifiedConstSet = getConstantFromLine(modified);
            if (modifiedConstSet.isEmpty()) {
                diffList.add(modified + "-->" + org);
                continue;
            }
            System.out.println("替换前:" + modified);
            for (String s : modifiedConstSet) {
                modified = modified.replace(s, CONSTANTS.get(s));
            }
            System.out.println("替换后:" + modified);
            if (!contentSame(org, modified)) {
                diffList.add(modified + "   -->  " + org);
            }

        }

        return diffList;
    }

    public static boolean contentSame(String l1, String l2) {
        return l1.replace(" ", "").equals(l2.replace(" ", ""));
    }

    public static List<String> filterList(List<String> list) {
        return list.stream().filter(line -> {
            if (line.startsWith("import") || line.startsWith("package") || line.startsWith("public class") || line.startsWith("public interface")) {
                return false;
            }
            return line.length() != 0 && !line.equals("\n");
        }).collect(Collectors.toList());
    }

    public static Set<String> getConstantFromLine(String line) {
        int bigLetterCount = 0;
        int startIdx = 0;
        Set<String> constSet = new HashSet<>();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (Character.isUpperCase(c) || c == '_' || c == '.') {
                if (c == '.' && bigLetterCount == 0) {
                    continue;
                }
                if (bigLetterCount == 0)
                    startIdx = i;
                bigLetterCount++;
            } else {
                if (bigLetterCount > 4) {
                    String constant = line.substring(startIdx, i);
                    if (constant.endsWith(".")) constant = line.substring(startIdx, i - 1);
                    if (CONSTANTS.containsKey(constant)) {
                        constSet.add(constant);
                    }
                }
                bigLetterCount = 0;
            }
        }
        return constSet;
    }

}
