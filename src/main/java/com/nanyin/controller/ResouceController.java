package com.nanyin.controller;

import com.nanyin.entity.Resource;
import com.nanyin.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by NanYin on 2017-08-04 下午11:15.
 * 包名： com.nanyin.controller
 * 类描述：
 */
@Controller
@RequestMapping("/resource")
public class ResouceController {
    @Autowired
    ResourceService resourceService;

//    resource 访问入口
    @RequestMapping("/returnResource")
    public String returnResource(){
        return "share";
    }

    @RequestMapping("/selectResource")
    public ModelAndView SelectResource(){
        List<Resource> resource = resourceService.SelectResource();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("resource",resource);
        modelAndView.setViewName("share");
        return modelAndView;
    }
    @RequestMapping(value = "/resources")
    public @ResponseBody Map<String,Object> resources(int pageNumber, int pageSize, String ByName){
        int a=(pageNumber-1)*pageSize;
        int b=pageSize;
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("name",ByName);
        param.put("a", a);
        param.put("b", b);
        return resourceService.resources(param);
    }
    @RequestMapping("/InsertRes")
    public @ResponseBody int InsertRes(Resource resource){
        resourceService.InsertRes(resource);
        return 0;
    }
    @RequestMapping("/DelectRes")
    public @ResponseBody int DelectRes(int id){
        resourceService.DelectRes(id);
        return 0;
    }

}
