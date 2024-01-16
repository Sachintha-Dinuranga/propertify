package controller;

import DAO.SignupDAO;
import bags.Signup;
import common.MyConnection;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class viewProfile extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SignupDAO sd=new SignupDAO(MyConnection.connectTo());
        Signup s=sd.viewProfile(Integer.parseInt(req.getParameter("id")));
        if(s!=null){
            HttpSession session = req.getSession();
            req.setAttribute("profile", s);
            resp.sendRedirect("admin/viewProfile.jsp?info=success");
        }else{
            resp.sendRedirect("dashboard.jsp");
        }
    }
}
