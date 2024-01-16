package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class contact extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String contact=req.getParameter("contact");
        String email=req.getParameter("email");
        String intention=req.getParameter("intention");
        String comment=req.getParameter("comment");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ores","root","");
            PreparedStatement pst=conn.prepareStatement("insert into feedback(name,contact,email,intention,comment) values(?,?,?,?,?)");
            pst.setString(1,name);
            pst.setString(2,contact);
            pst.setString(3,email);
            pst.setString(4,intention);
            pst.setString(5,comment);
            pst.executeUpdate();
            resp.sendRedirect("user/thankyou.jsp");
        }catch(Exception e){
            System.err.println("Error in contact: "+e.getMessage());
        }
    }
}
