package com.xxl.common.utils;

import java.io.*;

/**
 * 文件处理工具类
 */
public class FileUtils {
    public static String FILENAME_PATTERN = "[a-zA-Z0-9_\\-\\|\\.\\u4e00-\\u9fa5]+";

    /**
     * 输出指定文件的byte数组
     *
     * @param filePath 文件路径
     * @param os       输出流
     * @return
     */
    public static void writeBytes(String filePath, OutputStream os) throws IOException {
        FileInputStream fis = null;
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException(filePath);
            }
            fis = new FileInputStream(file);
            byte[] b = new byte[1024];
            int length;
            while ((length = fis.read(b)) > 0) {
                os.write(b, 0, length);
            }
        } catch (IOException e) {
            throw e;
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    /**
     * 删除文件
     *
     * @param filePath 文件
     * @return
     */
    public static boolean deleteFile(String filePath) {
        boolean flag = false;
        File file = new File(filePath);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
            flag = true;
        }
        return flag;
    }

    /**
     * 文件名称验证
     *
     * @param filename 文件名称
     * @return true 正常 false 非法
     */
    public static boolean isValidFilename(String filename) {
        return filename.matches(FILENAME_PATTERN);
    }

    /**
     * 读取文件
     */
    public static String readFile(String filePath) throws Exception {
        int temp;
        StringBuilder sb = new StringBuilder();
        FileReader fr = new FileReader(filePath);
        while ((temp = fr.read()) != -1) {
            sb.append((char) temp);
        }
        return sb.toString();
    }

    /**
     * 写入文件
     */
    public static void writFile(String filePath, String fileStr) throws Exception {
        File dirFile = new File(filePath.substring(0, filePath.lastIndexOf("/")));
        if (!dirFile.exists() && !dirFile.mkdirs() && !dirFile.exists()) {
            throw new Exception("文件夹创建失败");
        }

        File file = new File(filePath);
        if (!file.exists() && !file.createNewFile()) {
            throw new Exception("文件创建失败");
        }

        FileWriter fw = new FileWriter(file);
        fw.write(fileStr);
        fw.flush();
        fw.close();
    }


    // 复制目录下的文件（不包括该目录）到指定目录，会连同子目录一起复制过去。
    public static void copyFileFromDir(String toPath, String fromPath) {
        File file = new File(fromPath);
        createFile(toPath, false);                // true:创建文件 false创建目录
        if (file.isDirectory()) {                     // 如果是目录
            copyFileToDir(toPath, listFile(file));
        }
    }
    // 复制一组文件到指定目录。targetDir是目标目录，filePath是需要复制的文件路径
    public static void copyFileToDir(String toDir, String[] filePath) {
        if (toDir == null || "".equals(toDir)) { // 目录路径为空
            System.out.println("参数错误，目标路径不能为空");
            return;
        }
        File targetFile = new File(toDir);
        if (!targetFile.exists()) {                // 如果指定目录不存在
            targetFile.mkdir();                     // 新建目录
        } else {
            if (!targetFile.isDirectory()) {      // 如果不是目录
                System.out.println("参数错误，目标路径指向的不是一个目录！");
                return;
            }
        }
        for (int i = 0; i < filePath.length; i++) { // 遍历需要复制的文件路径
            File file = new File(filePath[i]);      // 创建文件
            if (file.isDirectory()) {                // 判断是否是目录
                // 递归调用方法获得目录下的文件
                copyFileToDir(toDir + "/" + file.getName(), listFile(file));
                System.out.println("复制文件 " + file);
            } else {
                copyFileToDir(toDir, file, ""); // 文件到指定目录
            }
        }
    }
    // 复制文件到指定目录
    public static void copyFileToDir(String toDir, File file, String newName) {
        String newFile = "";
        if (newName != null && !"".equals(newName)) {
            newFile = toDir + "/" + newName;
        } else {
            newFile = toDir + "/" + file.getName();
        }
        File tFile = new File(newFile);
        copyFile(tFile, file);                          // 调用方法复制文件
    }
    public static void copyFile(File toFile, File fromFile) { // 复制文件
        if (toFile.exists()) {                          // 判断目标目录中文件是否存在
            System.out.println("文件" + toFile.getAbsolutePath() + "已经存在，跳过该文件！");
            return;
        } else {
            createFile(toFile, true);                // 创建文件
        }
        System.out.println("复制文件" + fromFile.getAbsolutePath() + "到"
                + toFile.getAbsolutePath());
        try {                                              // 创建文件输入流
            InputStream is = new FileInputStream(fromFile);
            FileOutputStream fos = new FileOutputStream(toFile);// 文件输出流
            byte[] buffer = new byte[1024];      // 字节数组
            while (is.read(buffer) != -1) {      // 将文件内容写到文件中
                fos.write(buffer);
            }
            is.close();                               // 输入流关闭
            fos.close();                               // 输出流关闭
        } catch (FileNotFoundException e) {      // 捕获文件不存在异常
            e.printStackTrace();
        } catch (IOException e) {                     // 捕获异常
            e.printStackTrace();
        }
    }
    public static String[] listFile(File dir) { // 获取文件绝对路径
        String absolutPath = dir.getAbsolutePath(); // 获取传入文件的路径
        String[] paths = dir.list();                // 文件名数组
        String[] files = new String[paths.length]; // 声明字符串数组,长为传入文件的个数
        for (int i = 0; i < paths.length; i++) { // 遍历显示文件绝对路径
            files[i] = absolutPath + "/" + paths[i];
        }
        return files;
    }
    public static void createFile(String path, boolean isFile) {// 创建文件或目录
        createFile(new File(path), isFile);      // 调用方法创建新文件或目录
    }
    public static void createFile(File file, boolean isFile) { // 创建文件
        if (!file.exists()) {                          // 如果文件不存在
            if (!file.getParentFile().exists()) { // 如果文件父目录不存在
                createFile(file.getParentFile(), false);
            } else {                                    // 存在文件父目录
                if (isFile) {                          // 创建文件
                    try {
                        file.createNewFile();      // 创建新文件
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    file.mkdir();                     // 创建目录
                }
            }
        }
    }

    /**
     * 写入文件
     * @param fileName
     * @param s
     * @throws IOException
     */
    public static void writeToFile(String fileName,String s) throws IOException {
        File f1 = new File(fileName);
        f1.createNewFile();
        OutputStream out = null;
        BufferedWriter bw = null;
        if (f1.exists()) {
            out = new FileOutputStream(f1);
            bw = new BufferedWriter(new OutputStreamWriter(out, "utf-8"));
            bw.write(s);
            bw.flush();
            bw.close();
        } else {
            System.out.println("文件不存在");
        }
    }

    public static byte[] readFileToByteArray(File file) {
        byte[] buffer = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

}
