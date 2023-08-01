package com.hooper;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    /**
     * read md file
     */
    public static void readMdFile(String filePath,String destPath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        BufferedWriter writer = new BufferedWriter(new FileWriter(destPath));
        String line = null;
        while ((line = reader.readLine()) != null) {
            if (line.contains(CommonConstant.RET_CODE.OK)) {
                String note = "//CommonConstant.RET_CODE.OK\n";
                line = note + line;
            }else if (line.contains(CommonConstant.ERROR_CODE.UNKNOWN_ERR)) {
                String note = "//CommonConstant.ERROR_CODE.UNKNOWN_ERR\n";
                line = note + line;
            }else if (line.contains(CommonConstant.ERROR_CODE.DUPLICATE_REQ_NO)) {
                String note = "//CommonConstant.ERROR_CODE.DUPLICATE_REQ_NO\n";
                line = note + line;
            }
            writer.write(line);
            writer.newLine();
        }
    }
}