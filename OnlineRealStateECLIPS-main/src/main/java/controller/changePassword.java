package controller;

import DAO.SignupDAO;
import bags.Signup;
import common.BCrypt;
import common.MyConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class changePassword extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Signup s=new Signup();/* to store username password */
        SignupDAO sdatabase=new SignupDAO(MyConnection.connectTo());
        s.setEmail(req.getParameter("email"));
        s.setCpassword(req.getParameter("cpassword"));
        Signup sb = sdatabase.changePassword(s);/*data is delivered to SignupDAO*/
        if(sb != null){
            try{
                String npassword=BCrypt.hashpw(req.getParameter("npassword"),BCrypt.gensalt(12));
                String email=req.getParameter("email");
                Class.forName("com.mysql.jdbc.Driver");
                java.sql.Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ores","user","user");
                PreparedStatement pst=conn.prepareStatement("update signup set password=? where email='"+email+"'");
                pst.setString(1,npassword);
                pst.executeUpdate();
                resp.sendRedirect("signin.jsp?status=success");
            }
            catch(Exception e){
                System.err.println("Error in changePassword_controller: "+e.getMessage());
            }
        }
        else{
            resp.sendRedirect("changePassword.jsp?status=failed");
        }
    }
}
