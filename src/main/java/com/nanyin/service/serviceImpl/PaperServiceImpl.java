package com.nanyin.service.serviceImpl;

import com.nanyin.entity.Paper;
import com.nanyin.mapper.PaperMapper;
import com.nanyin.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by NanYin on 2017-08-02 下午7:26.
 * 包名： com.nanyin.service.serviceImpl
 * 类描述：
 */
@Service
public class PaperServiceImpl implements PaperService {
    @Autowired
    PaperMapper paperMapper;

    @Override
    public List<Paper> SelectAllId(int id) {
        return null;
    }

    @Override
    public List<Paper> SelectTitle() {
        return paperMapper.SelectTitle();
    }

    @Override
    public Map<String, Object> PaperTable(Map<String, Object> map) {
        Map<String,Object> newMap = new HashMap<>();
        int total = paperMapper.SelectAllId().size();
        List<Paper> rows = paperMapper.PaperTable(map);
//        List<Paper> papers =  paperMapper.PaperTable(map);
        newMap.put("total",total);
        newMap.put("rows",rows);
        return newMap;
    }

    @Override
    public Paper SelectPaper(int id) {
        return paperMapper.SelectPaper(id);
    }

    @Override
    public int UpdateMarkById(int id) {
//        访问热度的修改 没访问一次mark+1
        return paperMapper.UpdateMarkById(id);
    }

    @Override
    public int InsertPaper(Paper paper) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        paper.setB_time(timestamp);
        return paperMapper.InsertPaper(paper);
    }

    @Override
    public Paper SelectByTitle(String title) {
        return paperMapper.SelectByTitle(title);
    }

    @Override
    public int UpdatePage(Paper paper) {
        return paperMapper.UpdatePage(paper);
    }

    @Override
    public int DelectByTitle(String name) {
        return paperMapper.DelectByTitle(name);
    }

    @Override
    public List<Paper> paperList() {
        return paperMapper.paperList();
    }

    @Override
    public List<Paper> PaperS(String name) {
        return null;
    }


}
