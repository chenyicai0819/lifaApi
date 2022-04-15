package com.chen.lifaapi.service;

import com.chen.lifaapi.entity.Vips;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.service
 * @date 2022/4/15 23:59
 * @since 1.0
 */

public interface VipBatchService {
    List<Vips> excelToList(InputStream inputStream);

    int readExcelValueRows(Sheet sheet, int start);

    Boolean isCellEmpty(Row row);

    String getValues(Cell cell);
}
