package com.quanlysinhvien.controller.admin.qldt.qlmh;

import com.quanlysinhvien.model.respone.TeacherRespone;
import com.quanlysinhvien.service.ISubjectService;
import com.quanlysinhvien.service.ITeacherService;
import com.quanlysinhvien.util.ExcelExporterSubject;
import com.quanlysinhvien.util.ExcelExporterTeacher;

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

@WebServlet(urlPatterns = {"/admin/qldt/qlmh/export-subject"})
public class ExportSubjectController extends HttpServlet {
    @Inject
    private ISubjectService subjectService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        resp.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=subjects_" + currentDateTime + ".xlsx";
        resp.setHeader(headerKey, headerValue);

        ExcelExporterSubject excelExporter = new ExcelExporterSubject(subjectService.findAll());
        excelExporter.export(resp);
    }
}
