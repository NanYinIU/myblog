package com.nanyin.service.serviceImpl;

import com.nanyin.entity.Resource;
import com.nanyin.mapper.ResourceMapper;
import com.nanyin.mapper.UserMapper;
import com.nanyin.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by NanYin on 2017-08-04 下午11:13.
 * 包名： com.nanyin.service.serviceImpl
 * 类描述：
 */
@Service
public class ResourceServiceImpl implements ResourceService{
    @Autowired
    ResourceMapper resourceMapper;
    @Override
    public List<Resource> SelectResource() {
        return resourceMapper.SelectResource();
    }

    @Override
    public Map<String, Object> resources(Map<String, Object> map) {
        Map<String,Object> result = new HashMap<>();
        int total = resourceMapper.SelectResource().size();

        List<Resource> rows = resourceMapper.resources(map);

        result.put("rows",rows);
        result.put("total",total);

        return result;
    }

    @Override
    public int InsertRes(Resource resource) {
        return resourceMapper.InsertRes(resource);
    }

    @Override
    public int DelectRes(int id) {
        return resourceMapper.DelectRes(id);
    }
}
