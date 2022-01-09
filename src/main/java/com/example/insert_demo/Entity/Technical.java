package com.example.insert_demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Technical {
    //TODO 序号
    String term_id;
    //TODO 学科
    String subject;
    //TODO 规范词
    String standard;
    //TODO 英文
    String en_name;
    //TODO 定义
    String definition;
    //TODO 来源
    String source;
    //TODO 版本
    String version;
}
