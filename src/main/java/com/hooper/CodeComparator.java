package com.hooper;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CodeComparator {

    private static final Map<String, String> CONSTANTS;
    private static final String ROL_CONSTANT_FILE_PATH = "D:\\project\\Base\\zdbatch-boot\\zdbatch-bid\\zdbatch-common\\src\\main\\java\\com\\ylsoft\\core\\server\\common\\constant\\RolConstants.java";
    private static final String CONSTANT_FILE_PATH = "D:\\project\\Base\\zdbatch-boot\\zdbatch-bid\\zdbatch-common\\src\\main\\java\\com\\ylsoft\\core\\server\\common\\constant\\CommonConstant.java";
    private static final String OUT_FILE = "D:\\project\\常量修改后不一致统计.md";

    static {
        CONSTANTS = readConstantsFromFile(ROL_CONSTANT_FILE_PATH);
        CONSTANTS.putAll(readConstantsFromFile(CONSTANT_FILE_PATH));
        CONSTANTS.forEach((k,v) -> System.out.println(k + "=" +v));
    }

    public static void main(String[] args) throws Exception {
        new File(OUT_FILE).delete();
        String baseModPath = "D:\\project\\Base\\zdbatch-boot\\";
        String baseOrgPath = "D:\\project\\bat\\";
        String commonPath = "zdbatch-bid/zdbatch-preSaleHouse/src/main/java/com/ylsoft/core/server";
        String orgDir = baseOrgPath + commonPath;
        String modifiedDir = baseModPath + commonPath;
        List<String> orgPathList = getFilesByDir(orgDir, ".java").stream().map(File::getAbsolutePath).collect(Collectors.toList());
        List<String> modifiedPathList = getFilesByDir(modifiedDir, ".java").stream().map(File::getAbsolutePath).collect(Collectors.toList());
        if (orgPathList.size() != modifiedPathList.size()) {
            throw new RuntimeException("文件数量不一致");
        }
        for (int i = 0; i < orgPathList.size(); i++) {
            List<String> diffFromConstants = getDiffFromConstants(orgPathList.get(i), modifiedPathList.get(i));
            writeList(diffFromConstants, OUT_FILE, modifiedPathList.get(i));
        }
        System.out.println("done");
    }

    private static void writeList(List<String> list, String path, String filePath) {
        if (list.isEmpty()) {
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write("## " + filePath + "\n");
            writer.write("```java\n");
            list.forEach(s -> {
                try {
                    writer.write(s);
                    writer.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            writer.write("```\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
                        int preSize = constantsMap.size();
                        constantsMap.put(key, constantValue);
                        if (preSize == constantsMap.size()) {
                            System.err.println("Duplicate constant: " + key);
                        }
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
            if (org.equals(modified) || contentSame(org,modified)) continue;
            Set<String> modifiedConstSet = getConstantFromLine(modified);
            if (modifiedConstSet.isEmpty()) {
                diffList.add(modified + "-->" + org);
                continue;
            }
            System.out.println("替换前:" + modified);
            for (String s : modifiedConstSet) {
                modified = modified.replace(s, CONSTANTS.get(s));
            }
            if (modified.contains("RolConstants.")) {
                modified = modified.replace("RolConstants.", "");
            }
            if (modified.contains("CommonConstant.")) {
                modified = modified.replace("CommonConstant.", "");
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
            if (Character.isUpperCase(c) || c == '_' || c == '.' || c == '4') {
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
                    if (constant.endsWith("_NULL")) {
                        if (line.charAt(i) == '2') {
                            constant = constant + "2";
                        }
                    }
                    if (constant.endsWith("UNKNOWN_ERROR_")) {
                        constant = constant + '2';
                    }
                    if (constant.contains("JOB_MAIN_STATUS")||constant.contains("COLLECTION_STATUS")) {
                        constant = "COMMON_STATUS." + constant.split("\\.")[1];
                        System.err.println("替换常量:" + constant);
                    }
                    if (CONSTANTS.containsKey(constant)) {
                        constSet.add(constant);
                    }
                }
                bigLetterCount = 0;
            }
        }
        return constSet;
    }

    public static List<File> getFilesByDir(String targetDir, String type) {
        File file = new File(targetDir);
        List<File> list = new ArrayList<>();
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                list.addAll(getFilesByDir(f.getAbsolutePath(), type));
            } else {
                if (f.getName().endsWith(type)) {
                    list.add(f);
                }
            }
        }
        return list;
    }
}
