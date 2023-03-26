package com.xxl.common.common.fileCommon.controller;

import com.xxl.common.utils.FileUploadUtils;
import com.xxl.common.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 通用请求处理
 */
@Controller
@RequestMapping("/common")
public class FileCommonController {
    private static final Logger log = LoggerFactory.getLogger(FileCommonController.class);

    /**
     * 文件上传路径
     */
    public static final String UPLOAD_PATH = "/img/";

//    @Autowired
//    private ServerConfig serverConfig;

    /**
     * 通用下载请求
     *
     * @param fileName 文件名称
     * @param delete   是否删除
     */
    @GetMapping("download")
    @ResponseBody
    public void fileDownload(String fileName, Boolean delete, HttpServletResponse response, HttpServletRequest request) {
        try {
            if (!FileUtils.isValidFilename(fileName)) {
//                throw UnifI18NException.of(ErrorCode.INVALID_FILE_NAME);
                throw new IOException("文件名称非法，不允许下载");
            }
            String filePath = "";
            String realFileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf("_") + 1);
            if (fileName.equals("UserDataTemplate.xlsx")) {
//                File file = new File(this.getClass().getResource("/").getPath());
                filePath = this.getClass().getResource("/").getPath() + "ImportUserTemplates/" + fileName;
            } else {
                filePath = "E:/" + fileName;
            }

            response.setCharacterEncoding("utf-8");
//            response.setContentType("multipart/form-data");
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + setFileDownloadHeader(request, realFileName));
            FileUtils.writeBytes(filePath, response.getOutputStream());
            if (delete) {
                FileUtils.deleteFile(filePath);
            }
        } catch (Exception e) {
            log.error("下载文件失败", e);
        }
    }

    /**
     * 通用上传请求
     */
    @PostMapping("upload")
    @ResponseBody
    public Map<String, String> uploadFile(MultipartFile file) throws Exception {

        Map<String, String> result = new HashMap<>();
        result.put("name",file.getOriginalFilename());
        // 上传文件路径
        String filePath = "E:/";
        // 上传并返回新文件名称
        String fileName = FileUploadUtils.upload(filePath, file);
        String url = "http://172.16.16.32:9526" + UPLOAD_PATH + fileName;
//        String uuid = IdUtils.simpleUUID();
//        result.put("uuid", uuid);
        result.put("url", url);
        return result;
    }

    @GetMapping("downloadfile")
    @ResponseBody
    public void fileDownloadFile(String fileName, HttpServletResponse response, HttpServletRequest request) {
        try {

            String filePath = "";
            InputStream inputStream = null;
            String fileSub  =  fileName.substring(fileName.indexOf("_") + 1);
            String realFileName = System.currentTimeMillis() + fileSub;
            if (fileName.equals("UserDataTemplate.xlsx")) {
//                File file = new File(this.getClass().getResource("/").getPath());
//                filePath = this.getClass().getClassLoader().getResource("ImportUserTemplates/UserDataTemplate.xlsx").toString();
                ResourceLoader resourceLoader = new DefaultResourceLoader();
                inputStream = resourceLoader.getResource("classpath:/ImportUserTemplates/UserDataTemplate.xlsx").getInputStream();

            } else {
                filePath = fileName;
            }

            response.setCharacterEncoding("utf-8");
//            response.setContentType("multipart/form-data");
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + setFileDownloadHeader(request, realFileName));
            if (filePath != "") {

                FileUtils.writeBytes(filePath, response.getOutputStream());
            }else {
                byte[] b = new byte[1024];
                int length;
                while ((length = inputStream.read(b)) > 0) {
                    response.getOutputStream().write(b, 0, length);
                }
            }
        } catch (Exception e) {
            log.error("下载文件失败", e);
        }
    }

    @PostMapping("/uploadfile")
    @ResponseBody
    public Map<String, String> uploadFileFile(MultipartFile file) throws Exception {

        // 上传文件路径
        String filePath = "E:/";
        // 上传并返回新文件名称
        String fileName = FileUploadUtils.upload(filePath, file);
        String url = filePath + fileName;
        Map<String, String> result = new HashMap<>();
        result.put("fileName", fileName);
        result.put("url", url);
        return result;

    }

    public String setFileDownloadHeader(HttpServletRequest request, String fileName) throws UnsupportedEncodingException {
        final String agent = request.getHeader("USER-AGENT");
        String filename = fileName;
        if (agent.contains("MSIE")) {
            // IE浏览器
            filename = URLEncoder.encode(filename, "utf-8");
            filename = filename.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            // 火狐浏览器
            filename = new String(fileName.getBytes(), "ISO8859-1");
        } else if (agent.contains("Chrome")) {
            // google浏览器
            filename = URLEncoder.encode(filename, "utf-8");
        } else {
            // 其它浏览器
            filename = URLEncoder.encode(filename, "utf-8");
        }
        return filename;
    }
}
