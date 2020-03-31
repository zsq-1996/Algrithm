package com.excel;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.excel.entity.ExcelPropertyIndexModel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Pragram:ExcelWriteTest
 * @Description:TODO
 * @Author:ZhuShiQiang
 * @Create:2020-02-26 10:03
 **/
public class ExcelWriteTest {

    public void writeWithoutHead () throws IOException {
        try (OutputStream out = new FileOutputStream("withoutHead.xlsx");){
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX,false);
            Sheet sheet1 = new Sheet(1,0);
            sheet1.setSheetName("sheet1");
            List<List<String>> data = new ArrayList<>();
            //一个item代表一行,每循环一次,多一个item也就是多一行数据;item每次add就会在这一行多一列数据
            for (int i = 0;i < 30; i ++ ){
                List<String> item = new ArrayList<>();
                item.add("item0" + i);
                item.add("item1" + i);
                item.add("item2" + i);
                data.add(item);
            }
            writer.write0(data ,sheet1 );
            writer.finish();
        }
    }

    public void writeExcel() throws Exception {
        try (OutputStream out = new FileOutputStream("withHead.xlsx");) {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            Sheet sheet1 = new Sheet(1, 0);
            sheet1.setSheetName("sheet1");
            List<List<String>> data = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                List<String> item = new ArrayList<>();
                item.add("item0" + i);
                item.add("item1" + i);
                item.add("item2" + i);
                data.add(item);
            }
            List<List<String>> head = new ArrayList<List<String>>();
            List<String> headCoulumn1 = new ArrayList<String>();
            List<String> headCoulumn2 = new ArrayList<String>();
            List<String> headCoulumn3 = new ArrayList<String>();
            headCoulumn1.add("第一列");
            headCoulumn2.add("第二列");
            headCoulumn3.add("第三列");
            head.add(headCoulumn1);
            head.add(headCoulumn2);
            head.add(headCoulumn3);
            Table table = new Table(1);
            table.setHead(head);
            writer.write0(data, sheet1, table);
            writer.finish();
        }
    }
    /**
     * @Author ZhuShiQiang
     * @Description //TODO 通过注解方式添加表头
     * @Date  2020/2/26
     * @param
     * @return
     **/
    public void writeExcelWithhead2() throws Exception {
        try (OutputStream out = new FileOutputStream("withHead.xlsx");){
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            Sheet sheet1 = new Sheet(1, 0, ExcelPropertyIndexModel.class);
            sheet1.setSheetName("sheet1");
            List<ExcelPropertyIndexModel> data = new ArrayList<>();
            for (int i = 0; i < 10 ;i ++) {
                ExcelPropertyIndexModel item = new ExcelPropertyIndexModel();
                item.setName("name" + i);
                item.setAge("age" + i);
                item.setEmail("email" + i);
                item.setAddress("address" + i);
                item.setSax("sax" + i);
                item.setHeigh("heigh" + i);
                item.setLast("last" + i);
                data.add(item);
            }
            writer.write(data, sheet1);
            writer.finish();
        }
    }

}
