package com.algorithm;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;

import java.util.List;

public class WriteExcel {

    public static XSSFWorkbook importData(List<String> news)
    {
        //新建excel文件(.xls)
        XSSFWorkbook wb = new XSSFWorkbook();

        //创建工作表sheet表
        XSSFSheet sheet = wb.createSheet();

        //创建表头
        XSSFRow head = sheet.createRow(0);//第一行

        //创建单元格
        XSSFCell cell1 = head.createCell(0);//第一个单元格
        cell1.setCellValue("序号");

        XSSFCell cell2 = head.createCell(1);//第二个单元格
        cell2.setCellValue("新闻");

        //构建新闻数据
        int rowNum = 1;//行号，现在是第二行
        for (String n:news)
        {
            XSSFRow row = sheet.createRow(rowNum);//第二行
            XSSFCell cell;

            cell = row.createCell(0);//第一个单元格
            cell.setCellValue(rowNum);

            cell = row.createCell(1);//第二个单元格
            cell.setCellValue(n);

            rowNum += 1;
        }

        return wb;//此时生成的表格还在内存中
    }
}
