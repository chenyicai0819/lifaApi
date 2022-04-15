package com.chen.lifaapi.service.impl;

import com.chen.lifaapi.entity.Vips;
import com.chen.lifaapi.service.VipBatchService;
import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.service.impl
 * @date 2022/4/16 0:00
 * @since 1.0
 */
@Service
public class VipBatchServiceImpl implements VipBatchService {
    @Override
    public List<Vips> excelToList(InputStream inputStream) {
        Date date=new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 存储耗材数据的集合
        List<Vips> vipDataList = new ArrayList<>();
        // 形成表格对象
        XSSFWorkbook workbook;
        try {
            workbook = new XSSFWorkbook(inputStream);
            // 工作表对象
            XSSFSheet sheet = workbook.getSheetAt(0);
            // 总行数
            int rowLength = readExcelValueRows(sheet,2);
            if(rowLength == 0) {
                return null;
            }
            // 总列数
            // int colLength = row.getLastCellNum();
            // 获取指定的单元格数据
            for (int i = 2; i < rowLength + 2; i++) {
                Row row = sheet.getRow(i);
                // 行内容不为空
                if(null != row && !isCellEmpty(row)){
                    Vips vips = new Vips();
                    vips.setVipId(getValues(row.getCell(0))+"p");
                    vips.setTypeId(Integer.valueOf(getValues(row.getCell(1))));
                    vips.setVipName(getValues(row.getCell(2)));
                    vips.setVipPassword(getValues(row.getCell(3)));
                    vips.setVipPhone(getValues(row.getCell(4)));
                    vips.setVipSex(getValues(row.getCell(5)));
                    vips.setVipBirthday(Timestamp.valueOf(getValues(row.getCell(6))+" 16:00:00"));
                    vips.setVipOpencard(Timestamp.valueOf(getValues(row.getCell(7))+" 16:00:00"));
                    vips.setVipsMoney(Long.valueOf(getValues(row.getCell(8))));
                    vips.setVipsConsume(0L);
                    vips.setVipsBonus(0L);
                    vips.setVipsLast(Timestamp.valueOf(dateFormat.format(date)));
                    vipDataList.add(vips);
                }
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return vipDataList;
    }

    @Override
    public int readExcelValueRows(Sheet sheet, int start) {
        // 真实行数
        int realRow = 0;
        // 备份行数，如果数据插入在不连续的行中（行与行之间有空行），也获取该数据所在的行数
        int virtualRow = 0;
        for (int i = start; i <= sheet.getLastRowNum(); i++) {
            virtualRow++;
            //i 从 start 开始，不判断第一行标题行
            Row row = sheet.getRow(i);
            if (row == null){
                continue;
            }
            if(!isCellEmpty(row)) {
                realRow = virtualRow;
            }
        }
        return realRow;
    }

    @Override
    public Boolean isCellEmpty(Row row) {
        for (int i = 0;i < row.getLastCellNum();i++) {
            Cell cell = row.getCell(i);
            if(null == cell || null == getValues(cell) || "".equals(getValues(cell).trim())){
                return true;
            }
        }
        return false;
    }

    @Override
    public String getValues(Cell cell) {
        if(cell == null){
            return null;
        }
        if (cell.getCellType() == CellType.BOOLEAN) { //Boolean转为String
            return String.valueOf(cell.getBooleanCellValue());
        } else if (cell.getCellType() == CellType.NUMERIC) { //NUMERIC(日期，数字)转为String
            String cellValue;
            if (DateUtil.isCellDateFormatted(cell)) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = DateUtil.getJavaDate(cell.getNumericCellValue());
                cellValue = sdf.format(date);
            } else {
                HSSFDataFormatter dataFormatter = new HSSFDataFormatter();
                cellValue = dataFormatter.formatCellValue(cell);
            }
            return cellValue;
        } else if (cell.getCellType() == CellType._NONE) {
            return "";
        } else if (cell.getCellType() == CellType.BLANK) {
            return "";
        } else if (cell.getCellType() == CellType.STRING) {
            return String.valueOf(cell.getStringCellValue());
        }
        return null;
    }
}
