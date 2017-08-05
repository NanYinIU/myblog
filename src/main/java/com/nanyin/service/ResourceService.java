package com.nanyin.service;

import com.nanyin.entity.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by NanYin on 2017-08-04 下午11:13.
 * 包名： com.nanyin.service
 * 类描述：
 */
@Service
public interface ResourceService {

    List<Resource> SelectResource();

    Map<String,Object> resources(Map<String,Object> map);

    int InsertRes(Resource resource);

    int DelectRes(int id);
}
