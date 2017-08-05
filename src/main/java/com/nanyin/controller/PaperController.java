package com.nanyin.controller;

import com.nanyin.entity.Paper;
import com.nanyin.service.PaperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by NanYin on 2017-08-02 下午7:29.
 * 包名： com.nanyin.controller
 * 类描述：
 */
@Controller
@RequestMapping("/paper")
public class PaperController {
    Logger logger = LoggerFactory.getLogger(PaperController.class);
    @Autowired
    PaperService paperService;

    //  paper 访问入口
    @RequestMapping("/pages")
    public String pages(){
        return "pageList";
    }

    @RequestMapping(value = "/SelectTitles")
    public @ResponseBody List<Paper> SelectTitles(){
        List<Paper> papers = paperService.SelectTitle();
        return papers ;
    }

    @RequestMapping(value = "/PaperTable" )
    public @ResponseBody Map<String,Object> PaperTable(int pageNumber,int pageSize,String ByName){
        int a=(pageNumber-1)*pageSize;
        int b=pageSize;
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("name",ByName);
        param.put("a", a);
        param.put("b", b);
        return paperService.PaperTable(param);
    }


    @RequestMapping("/SelectPaper/{id}")
    public ModelAndView SelectPaper(@PathVariable(value = "id") int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pages");
//        这个链接执行一次就说明访问一次 id的章的内容 则在这里写一个 update方法 让他的mark值加一
        Paper paper = paperService.SelectPaper(id);
        paperService.UpdateMarkById(id);
        modelAndView.addObject("paper",paper);

//        logger.info(paper.toString());
        return modelAndView;
    }
    @RequestMapping("/InsertPaper")
    public @ResponseBody int InsertPaper(Paper paper){
    paperService.InsertPaper(paper);
    return 0;
    }

    @RequestMapping("/SelectByTitle")
    public @ResponseBody Paper SelectByTitle(String title){
        return  paperService.SelectByTitle(title);
    }

    @RequestMapping("/UpdatePage")
    public @ResponseBody int UpdatePage(Paper paper){
        paperService.UpdatePage(paper);
        return 0;
    }
    @RequestMapping("/DelectByTitle")
    public  int DelectByTitle(String b_name){
        paperService.DelectByTitle(b_name);
        return 0;
     }

    @RequestMapping(value = "/validName",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> validName(String f01){
        Map<String,Object> nameMap = new HashMap<>();
        boolean validd = true ;
        Paper paper = paperService.SelectByTitle(f01);
        if(paper!=null) {
            if (paper.getB_name().equals(f01)) {
                validd = false;
            } else
                validd = true;
        }
        nameMap.put("valid",validd);
        return nameMap;
    }
}
