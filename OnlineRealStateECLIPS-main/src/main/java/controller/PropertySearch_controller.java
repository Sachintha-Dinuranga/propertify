package controller;

import DAO.Property_DAO;
import DAO.SignupDAO;
import bags.Signup;
import bags.property_bag;
import common.MyConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PropertySearch_controller extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String[] errors=new String[8];
        property_bag pb= new property_bag();/* to store username password */
        if(req.getParameter("ptype")!=null && !req.getParameter("ptype").equals("")){
            pb.setPtype(req.getParameter("ptype"));
        }
        else{
            errors[0]="Property type field is not valid !";
        }
        
        if(req.getParameter("minprice")!=null && !req.getParameter("minprice").equals("")){
            pb.setMinprice(Float.parseFloat(req.getParameter("minprice")));
        }
        else{
            errors[1]="Minimum price field is not valid !";
        }
        
        if(req.getParameter("maxprice")!=null && !req.getParameter("maxprice").equals("")){
            pb.setMaxprice(Float.parseFloat(req.getParameter("maxprice")));
        }
        else{
            errors[2]="Maximum price field is not valid !";
        }
        
        if(req.getParameter("srproperty")!=null && !req.getParameter("srproperty").equals("")){
            pb.setSrproperty(req.getParameter("srproperty"));
        }
        else{
            errors[3]="Sell/rent field is not valid !";
        }
        
        if(req.getParameter("psubtype")!=null && !req.getParameter("psubtype").equals("")){
            pb.setPsubtype(req.getParameter("psubtype"));
        }
        else{
            errors[4]="Property sub-type field is not valid !";
        }
        
        if(req.getParameter("bedroom")!=null && !req.getParameter("bedroom").equals("")){
            pb.setBedroom(req.getParameter("bedroom"));
        }
        else{
            errors[5]="Bedroom field is not valid !";
        }
        
        if(req.getParameter("bathroom")!=null && !req.getParameter("bathroom").equals("")){
            pb.setBathroom(req.getParameter("bathroom"));
        }
        else{
            errors[6]="Bathroom field is not valid !";
        }
        
        if(req.getParameter("cityname")!=null && !req.getParameter("cityname").equals("")){
            pb.setCityname(req.getParameter("cityname"));
        }
        else{
            errors[7]="Cityname field is not valid !";
        }
        
        if(req.getParameter("pincode")!=null && !req.getParameter("pincode").equals("")){
            pb.setPincode(req.getParameter("pincode"));
        }
        else{
            errors[8]="Pincode field is not valid !";
        }
        Property_DAO pd=new Property_DAO(MyConnection.connectTo());
        property_bag p=pd.getSearch(pb);
        if(p!=null){
            HttpSession session2=req.getSession();
            session2.setAttribute("Search", p);
            resp.sendRedirect("user/search.jsp?status=success");
        }
        else{
            resp.sendRedirect("user/search.jsp?status=failed");
        }
    }
}
