package com.quanlysinhvien.util;

import com.quanlysinhvien.model.respone.StudentResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public class ExcelExporterStudent {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<StudentResponse> list;

    public ExcelExporterStudent(List<StudentResponse> list) {
        workbook = new XSSFWorkbook();
        this.list = list;
    }

    private void writeTitleLine() {
        sheet = workbook.createSheet("students");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontName("Times New Roman");
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row, 0, "DANH SÁCH SINH VIÊN", style);
        sheet.addMergedRegion(CellRangeAddress.valueOf("A1:L1"));

    }

    private void writeHeaderLine() {
        Row row = sheet.createRow(3);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontName("Times New Roman");
        font.setFontHeight(14);
        style.setFont(font);

        createCell(row, 0, "Mã sinh viên", style);
        createCell(row, 1, "Tên sinh viên", style);
        createCell(row, 2, "Lớp học", style);
        createCell(row, 3, "Giới tính", style);
        createCell(row, 4, "Dob", style);
        createCell(row, 5, "Ngày sinh", style);
        createCell(row, 6, "Ghi chú", style);
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else if (value instanceof Long) {
            cell.setCellValue((Long) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines() {
        int rowCount = 4;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        font.setFontName("Times New Roman");
        style.setFont(font);

        for (StudentResponse studentResponse : list) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, studentResponse.getCode(), style);
            createCell(row, columnCount++, studentResponse.getName(), style);
            createCell(row, columnCount++, studentResponse.getLop(), style);
            createCell(row, columnCount++, studentResponse.getGender(), style);
            createCell(row, columnCount++, studentResponse.getDob(), style);
            createCell(row, columnCount++, studentResponse.getBirthday(), style);
        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeTitleLine();
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();

    }



}