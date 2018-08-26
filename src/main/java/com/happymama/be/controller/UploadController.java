package com.happymama.be.controller;

import com.google.common.base.Splitter;
import com.happymama.be.model.EmployeeCommentImgDO;
import com.happymama.be.model.ForumImgDO;
import com.happymama.be.service.EmployeeCommentImgService;
import com.happymama.be.service.ForumImgService;
import com.happymama.be.utils.FileUploadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by yaoqiang on 2018/8/1.
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/upload")
@Slf4j
public class UploadController {

    @Resource
    private EmployeeCommentImgService employeeCommentImgService;
    @Resource
    private ForumImgService forumImgService;

    @RequestMapping(params = "method=uploadPic")
    public String uploadPic(HttpServletRequest request) {
        return "uploaderDemo/uploaderTest";
    }

    @RequestMapping(params = "method=upload")
    @ResponseBody
    public String uploads(@RequestParam("file") MultipartFile file, @RequestParam("fileType") String fileType, @RequestParam("commentId") String commentId,
                          HttpServletRequest request, HttpServletResponse response) {

        try {
            String imgName = UUID.randomUUID().toString() + "." + Splitter.on(".").splitToList(file.getOriginalFilename()).get(1);
            FileUploadUtil.uploadImg(imgName, file.getInputStream());

            String url = FileUploadUtil.getImgUrl(imgName);

            switch (fileType) {
                case "employeeType":
                    employeeCommentImgService.addEmployeeCommentImg(EmployeeCommentImgDO.builder().commentId(commentId).img(url).build());
                    break;
                case "forumType":
                    forumImgService.addForumCommentImg(ForumImgDO.builder().forumId(commentId).img(url).build());
                    break;

            }
        } catch (IOException e) {
            log.error("UploadController uploads", e);
        }
        response.setHeader("Access-Control-Allow-Origin", "*");
        return "ok";
    }

}
