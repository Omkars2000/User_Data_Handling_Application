package org.jspider.Vertical_ask.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jspider.Vertical_ask.module.User;

public class ExcelUtil {
    public static List<User> readUsersFromExcel(InputStream inputStream) throws IOException {
        List<User> users = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                // Skip the header row
                continue;
            }
            User user = new User();
            user.setUserName(getStringCellValue(row.getCell(0)));
            user.setUserEmail(getStringCellValue(row.getCell(1)));
            user.setUserPhone(getStringCellValue(row.getCell(2)));
            users.add(user);
        }
        return users;
    }

    private static String getStringCellValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                return String.valueOf((long) cell.getNumericCellValue());
            case BLANK:
                return null;
            default:
                throw new IllegalArgumentException("Unsupported cell type: " + cell.getCellType());
        }
    }
}

