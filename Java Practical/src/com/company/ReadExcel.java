package com.company;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadExcel {

    public static List<String> readExcel(String fileName) throws IOException
    {
        List<String> list = new ArrayList<String >();

        //获取excel表格
        File file = new File(fileName);//文件IO流，用于读写文件
        FileInputStream inputStream = new FileInputStream(file);//文件IO流，用于读写文件

        XSSFWorkbook wb = new XSSFWorkbook(inputStream);

        //读取Excel文件中的数据
        XSSFSheet sheet = wb.getSheetAt(0);
        //解析每一行的数据，构造数据对象
        int rowStartAt = 1;//数据第一行,即Excel表格的第二行
        int rowEndAt = sheet.getPhysicalNumberOfRows();//有数据的最后一行

        for (int rowNum = rowStartAt; rowNum < rowEndAt; rowNum ++)
        {
            XSSFRow row = sheet.getRow(rowNum);//获取一行
            XSSFCell cell;
            int cellNum = 1;
            //获取新闻
            cell = row.getCell(cellNum);
            String name = cell.getStringCellValue();//获取单元格的内容
            list.add(name);
        }
        return list;

    }

}
