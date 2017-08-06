package com.nanyin.controller;

import com.nanyin.entity.User;
import com.nanyin.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by NanYin on 2017-08-01 下午9:17.
 * 包名： com.nanyin.controller
 * 类描述：
 */
@Controller
public class OtherController {

    @Autowired
    UserService userService;

//  密码验证 转到后台
    @RequestMapping(value = "/editPaper",method = RequestMethod.POST)
    public String editPaper(String name ,String password) throws UnsupportedEncodingException {
        if(name!=null){
            User u = userService.selectByName(name);
            if(u!=null){
                byte []s = Base64.getDecoder().decode(u.getPassword());
                String pass = new String(s,"utf-8");
                System.out.println(u.getPassword());
                System.out.println(pass);
//                String enpass = Base64.getEncoder().encode(u.getPassword());
                if(pass.equals(password)){
                    return "editPage";
                }
            }
        }

        return "login";
    }


//  图片上传
    @RequestMapping(value = "/uploadFile" ,method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> upload(HttpServletRequest request , @RequestParam(value = "editormd-image-file",required = false) MultipartFile file) {
        Logger logger = Logger.getLogger(this.getClass());

        Map<String,String> map = new HashMap<>();
        // 获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径 存到服务器内
        String filePath = request.getSession().getServletContext().getRealPath("/upload/");
        logger.info(filePath);
//         "/upload/";
        // 解决中文问题，liunx下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            map.put("success","1");
            map.put("message","上传成功,okTest");
            map.put("url",filePath+fileName);
            return map;
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        map.put("success","0");
        map.put("message","上传失败");
        return map;
    }

    @RequestMapping("/")
    public String returnIndex(){
        return "index";
    }



////    测试用
//    @RequestMapping("/test")
//    public String test(){
//        return "NewList";
//    }

}
