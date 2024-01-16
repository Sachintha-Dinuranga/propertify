package controller;

import DAO.Property_DAO;
import bags.property_bag;
import common.MyConnection;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class checkOut extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Property_DAO pd=new Property_DAO(MyConnection.connectTo());
        int pid=Integer.parseInt(req.getParameter("pid"));
        property_bag pb=pd.checkOut(Integer.parseInt(req.getParameter("pid")));
        if(pb!=null){
            HttpSession session=req.getSession();
            session.setAttribute("checkOut", pb);
            resp.sendRedirect("user/checkOut.jsp?info=success");
        }else{
            resp.sendRedirect("index.jsp");
        }
    }
}
