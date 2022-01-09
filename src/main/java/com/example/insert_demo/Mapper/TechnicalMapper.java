package com.example.insert_demo.Mapper;


import com.example.insert_demo.Entity.Technical;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface TechnicalMapper {
    /**
     * 查询对应关键词的所有内容
     * @return
     */
    @Select("select * from technical_term")
    Technical findAll();

    /**
     * 查询对应关键词的各字段
     * @param standard
     * @return
     */
    @Select("select * from technical_term where standard=#{standard}")
    Technical findByStandard(@Param("standard") String standard);

    /**
     * 查询对应关键词的定义
     * @param standard
     * @return
     */
    @Select("select definition from technical_term where standard = #{standard}")
    Technical findDefByStandard(@Param("standard") String standard);


    /**
     *
     * @param term_id
     * @param subject
     * @param standard
     * @param en_name
     * @param definition
     * @param source
     * @param version
     * @return
     */
    @Insert("insert into technical_term (term_id, subject, standard, en_name, definition, " +
            "source, version) values (#{term_id}, #{subject}, #{standard}, #{en_name}," +
            "#{definition}, #{source}, #{version})")
    int insert(@Param("term_id") String term_id,
               @Param("subject") String subject,
               @Param("standard") String standard,
               @Param("en_name") String en_name,
               @Param("definition") String definition,
               @Param("source") String source,
               @Param("version") String version);
}
