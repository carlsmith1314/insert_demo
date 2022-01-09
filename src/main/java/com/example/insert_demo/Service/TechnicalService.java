package com.example.insert_demo.Service;

import com.example.insert_demo.Entity.Technical;
import com.example.insert_demo.Mapper.TechnicalMapper;
import org.apache.ibatis.annotations.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TechnicalService {
    private static final Logger log1 = LoggerFactory.getLogger(TechnicalService.class);

    private final TechnicalMapper technicalMapper;

    public TechnicalService(@Autowired TechnicalMapper technicalMapper){
        this.technicalMapper = technicalMapper;
    }

    /**
     * 查询表中全部内容
     * @return
     */
    public boolean searchAll(){
        return technicalMapper.findAll() != null;
    }

    /**
     * 根据标准词查询相关定义
     * @param standard
     * @return
     */
    public boolean searchDefByStandard(String standard){
        //todo 非空检查
        if(standard == null){
            return false;
        }
        //todo 检查是否具有此项
        return technicalMapper.findDefByStandard(standard) != null;
    }

    /**
     * 根据标准词查询所有内容
     * @param standard
     * @return
     */
    public boolean searchStandard(String standard){
        //todo 非空检查
        if(standard == null){
            return false;
        }
        return technicalMapper.findByStandard(standard) != null;
    }

    public boolean insert(Technical technical){
        //todo 非空检查
        if(technical == null){
            log1.error("输入内容不能为空！");
            return false;
        }

        //todo 数据去重
        if(!searchDefByStandard(technical.getStandard())){
            return false;
        }

        int result = technicalMapper.insert(technical.getTerm_id(), technical.getSubject(), technical.getStandard(),
                technical.getEn_name(), technical.getDefinition(), technical.getSource(), technical.getVersion());
        if(result != 1){
            log1.error("数据写入过程中出现错误");
            return false;
        }else{
            return true;
        }
    }
}