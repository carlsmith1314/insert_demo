package com.example.insert_demo.InputFile;


import com.example.insert_demo.Entity.Technical;
import com.example.insert_demo.Service.TechnicalService;
import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.FileInputStream;


public class readExcel {
    @Autowired
    private TechnicalService technicalService;
    @SneakyThrows
    private void excel(){
        Technical technical = new Technical();
        //TODO 用流的方式读取excel文件
        FileInputStream data = new FileInputStream("/home/carlsmith-wuzhuo/keyword_matching/src/main/resources/word.xlsx");
        //TODO 获取整个excel
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(data);
        //TODO 获取第一个表单
        XSSFSheet hssfSheet = xssfWorkbook.getSheetAt(0);
        //TODO 获取第一行
        int first = hssfSheet.getFirstRowNum();
        //TODO 获取最后一行
        int last = hssfSheet.getLastRowNum();
        for(int i = first + 1; i <= last; i++){
            Row row = hssfSheet.getRow(i);
            //todo 获取这一行的第一列
            int first_col = row.getFirstCellNum();
            //todo 获取这一行的最后一列
            int last_col = row.getLastCellNum();
            //todo 获取序号
            technical.setTerm_id(row.getCell(first_col).toString());
            //todo 获取学科
            technical.setSubject(row.getCell(first_col + 1).toString());
            //todo 获取规范用词
            technical.setStandard(row.getCell(first_col + 2).toString());
            //todo 获取英文
            technical.setEn_name(row.getCell(first_col + 3).toString());
            //todo 获取定义
            technical.setDefinition(row.getCell(last_col - 4).toString());
            //todo 获取来源
            technical.setSource(row.getCell(last_col - 3).toString());
            //todo 获取版本
            technical.setVersion(row.getCell(last_col - 2).toString());
            technicalService.insert(technical);
        }
        data.close();
    }
    public void ex(){
        excel();
    }
}
