package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addFAQ_controller extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String faqtitle=req.getParameter("faqtitle");
        String faqs=req.getParameter("faqs");
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ores","root","");
            PreparedStatement pst=conn.prepareStatement("insert into faq(faqtitle,faqsolution) values(?,?)");
            pst.setString(1,faqtitle);
            pst.setString(2,faqs);
            pst.executeUpdate();
            resp.sendRedirect("admin/addFAQ.jsp?status=success");
            
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
}
