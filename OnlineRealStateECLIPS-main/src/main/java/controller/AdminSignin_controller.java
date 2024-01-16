package controller;

import DAO.SignupDAO;
import bags.Signup;
import common.BCrypt;
import common.MyConnection;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminSignin_controller extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String[] errors=new String[2];/* to store an error maximum 2 errors can be stored*/
        Signup s=new Signup();/* to store username password */
        SignupDAO sdatabase=new SignupDAO(MyConnection.connectTo());
        if(!req.getParameter("username").equals("") && !req.getParameter("username").equals(" ")){
            s.setEmail(req.getParameter("username"));
        }
        else{
            errors[0]="username field is not valid !";
        }
        if(!req.getParameter("password").equals("") && !req.getParameter("password").equals(" ")){
            s.setPassword(req.getParameter("password"));
        }
        else{
            errors[1]="Password field is not valid !";
        }
        Signup sb = sdatabase.adminsignin(s);/*data is delivered to SignupDAO*/
        if(sb != null){
            HttpSession session = req.getSession();
            session.setAttribute("Signup", sb);
            if(sb.getRole().equals("admin")){
                resp.sendRedirect("admin/index.jsp");
            }
            else{
                resp.sendRedirect("adminsigin.jsp?info=failed");
            }
        }
        else{
            resp.sendRedirect("adminsignin.jsp?info=failed");
        }
    }
    /*when function calls it goes to the signin in SignupDAO and stored in s variable*/
}
