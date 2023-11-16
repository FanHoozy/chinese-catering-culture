package org.bearer.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author guanJiamin
 * @version 1.0
 * @date Created in 2023/11/01 15:08
 */
public interface UploadService {
    /**
     * 上传图片
     *
     * @param file 文件保存对象
     * @return String
     */
    String uploadPicture(MultipartFile file);

    /**
     * 上传视频
     *
     * @param file 文件保存对象
     * @return String
     */
    String uploadVideo(MultipartFile file);
}
