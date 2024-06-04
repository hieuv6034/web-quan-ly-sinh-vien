package com.quanlysinhvien.controller.admin.qlhv.hs;

import com.quanlysinhvien.model.respone.StudentResponse;
import com.quanlysinhvien.service.IStudentService;
import com.quanlysinhvien.util.ExcelExporterStudent;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/qlhv/hs/export-student"})
public class ExportStudentController extends HttpServlet {
    @Inject
    private IStudentService studentService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        List<StudentResponse> studentResponses = studentService.findAll();
        resp.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=students_" + currentDateTime + ".xlsx";
        resp.setHeader(headerKey, headerValue);

        ExcelExporterStudent excelExporter = new ExcelExporterStudent(studentResponses);
        excelExporter.export(resp);
    }
}
