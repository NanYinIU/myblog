package com.nanyin.service;

import com.nanyin.entity.Paper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by NanYin on 2017-08-02 下午7:25.
 * 包名： com.nanyin.service
 * 类描述：
 */
@Service
public interface PaperService {

    List<Paper> SelectAllId(int id);

    List<Paper> SelectTitle();

    Map<String , Object> PaperTable(Map<String , Object> map);

    Paper SelectPaper(int id);

    int UpdateMarkById(int id);

    int InsertPaper(Paper paper);

    Paper SelectByTitle(String title);

    int UpdatePage(Paper paper);

    int DelectByTitle (String name);

    List<Paper> paperList();

    List<Paper> PaperS(String name);
}
