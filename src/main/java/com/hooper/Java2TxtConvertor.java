package com.hooper;

import com.sun.xml.internal.ws.util.StringUtils;

import java.io.*;
import java.util.*;

/**
 * @Author: tim hooper
 * @Date 2023/7/17 22:56
 */
public class Java2TxtConvertor {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the java file path:");
        String javaFilePath = scanner.nextLine();
        batchConvert(javaFilePath, null);
    }

    public static String getJavaFileName(String javaFilePath) {
        return javaFilePath.substring(javaFilePath.lastIndexOf(File.separator) + 1, javaFilePath.lastIndexOf("."));
    }

    /**
     * 将java文件转为txt文件
     * @param javaFilePath java文件路径
     * @param txtFilePath txt文件路径，如果为null，则默认为java文件所在目录下
     * @throws IOException io异常
     */
    public static void convert(String javaFilePath, String txtFilePath) throws IOException {

        if (txtFilePath == null || txtFilePath.trim().length() == 0) {
            txtFilePath = javaFilePath.substring(0, javaFilePath.lastIndexOf(File.separator))
                    + File.separator + getJavaFileName(javaFilePath) + ".txt";
        }

        BufferedReader reader = new BufferedReader(new FileReader(javaFilePath));
        BufferedWriter writer = new BufferedWriter(new FileWriter(txtFilePath));
        String line = null;
        while ((line = reader.readLine()) != null) {
            writer.write(line);
            writer.newLine();
        }
        writer.flush();
        writer.close();
        reader.close();
        System.out.println("Convert successfully!");
    }

    /**
     * 将原文件目录批量转换
     * @param orgDir 源文件目录
     * @param destDir 目标文件目录
     */
    public static void batchConvert(String orgDir,String destDir){
        getFilePathsByType(orgDir, ".java").forEach(javaFilePath -> {
            try {
                convert(javaFilePath, destDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 根据文件类型获取目录下所有文件地址
     */
    public static List<String> getFilePathsByType(String dirPath,String fileType) {
        List<String> filePaths = new ArrayList<>();
        File dir = new File(dirPath);
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.getName().endsWith(fileType)) {
                    filePaths.add(file.getAbsolutePath());
                }
            }
        }
        return filePaths;
    }


}
