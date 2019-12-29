package servlet;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Msdoc extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        String filename = rq.getParameter("file");
        String docdir   = getServletContext().getInitParameter("doc-dir");
        File file = new File(docdir+"/"+filename);
        OutputDoc(file,rs);
        System.out.println("Servlet:MSDoc");
    }
    protected void OutputDoc(File doc, HttpServletResponse rs) throws IOException {
        rs.setContentType("application/msword");
        rs.addHeader("Content-Disposition", "attachment; filename=" + doc.getName());
        System.out.println("the file " + doc.getName() + " has started to be uploaded");
        rs.setContentLength((int) doc.length());

        FileInputStream in = new FileInputStream(doc);
        BufferedInputStream buf = new BufferedInputStream(in);
        ServletOutputStream out = rs.getOutputStream();
        int readBytes = 0;
        while ((readBytes = buf.read()) != -1)
            out.write(readBytes);
    }
}
