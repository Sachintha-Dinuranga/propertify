package controller;

import DAO.SignupDAO;
import common.MyConnection;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class signupDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        SignupDAO sd=new SignupDAO(MyConnection.connectTo());
        if(sd.delete(Integer.parseInt(req.getParameter("id")))){
            resp.sendRedirect("admin/dashboard.jsp?status=deleted");
        }else{
            resp.sendRedirect("admin/dashboard.jsp?status=not deleted");
        }
    }
}
