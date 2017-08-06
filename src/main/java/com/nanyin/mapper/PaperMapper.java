package com.nanyin.mapper;

import com.nanyin.entity.Paper;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by NanYin on 2017-08-02 下午7:06.
 * 包名： com.nanyin.mapper
 * 类描述：
 */
@Component
@Mapper
@CacheConfig(cacheNames = "users")
public interface PaperMapper {

    @Select("SELECT * FROM blog.paper p")
    @Cacheable
    List<Paper> SelectAllId();

    @Select("SELECT p.id, p.b_name,p.b_time,p.`type`,p.mark FROM blog.paper p ORDER BY p.mark DESC LIMIT 0,5")
    List<Paper> SelectTitle();

    @Cacheable
    @Select({"<script>",
                   "SELECT p.id, p.b_name,p.b_time,p.`type`,p.mark FROM blog.paper p",
                           "<if test=\"name!=null and name!=''\">",
                                "WHERE  p.b_name LIKE concat(concat('%',#{name}),'%') ",
                           "</if>",
                       "LIMIT #{a},#{b}",
             "</script>" })
    List<Paper> PaperTable(Map<String , Object> map);

    @Cacheable
    @Select("SELECT p.b_name,p.b_time,p.`type`,p.mark, p.content FROM blog.paper p WHERE p.id = #{id}")
    Paper SelectPaper(int id);

    @Update("UPDATE blog.paper SET mark = mark+1 WHERE id=#{id}")
    int UpdateMarkById(int id);

    @Insert("INSERT INTO blog.paper(b_name,b_time,content,mark,`type`) VALUES(#{b_name},#{b_time},#{content},0,#{type})")
    int InsertPaper(Paper paper);

    @Cacheable
    @Select("SELECT p.b_name,p.`type`,p.content FROM blog.paper p WHERE p.b_name = #{name}")
    Paper SelectByTitle(String name);

    @Update("UPDATE blog.paper SET b_name =#{b_name} , `type`=#{type} , content=#{content} WHERE b_name=#{b_name}")
    int UpdatePage(Paper paper);

    @Delete("DELETE  FROM blog.paper WHERE b_name=#{title}")
    int DelectByTitle(String title);


    @Select("SELECT p.id, p.b_name,p.b_time,p.`type`,p.mark, p.type FROM blog.paper p")
    List<Paper> paperList();

}
