package controller;

import bags.property_bag;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Property_controller extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        property_bag pb=new property_bag();
        int pid=pb.getPid();
        String pname=pb.getPname();
        System.err.println("pid----------   "+pid+"   pname"+pname);
    }
}
