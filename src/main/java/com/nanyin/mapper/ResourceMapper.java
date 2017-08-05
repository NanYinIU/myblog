package com.nanyin.mapper;

import com.nanyin.entity.Resource;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by NanYin on 2017-08-04 下午11:01.
 * 包名： com.nanyin.mapper
 * 类描述：
 */
@Component
@Mapper
@CacheConfig(cacheNames = "resource")
public interface ResourceMapper {
    @Cacheable
    @Select("SELECT name,address,`source` FROM blog.ressource WHERE status=1")
    List<Resource> SelectResource();

    @Cacheable
    @Select({
            "<script>",
            "SELECT id,name,address,source FROM blog.ressource WHERE status=1",
            "<if test=\"name!=null and name!=''\">",
            "AND name LIKE concat(concat('%',#{name}),'%') ",
            "</if>",
            "LIMIT #{a},#{b}",
            "</script>"
    })
    List<Resource> resources(Map<String ,Object> map);

//    资源只做增加和删除 不做修改

    @Insert("INSERT INTO blog.ressource(name,status,`source`,address) VALUES (#{name},1,#{source},#{address})")
    int InsertRes(Resource resource);

    @Delete("DELETE FROM blog.ressource WHERE id = #{id}")
    int DelectRes(int id);

}
