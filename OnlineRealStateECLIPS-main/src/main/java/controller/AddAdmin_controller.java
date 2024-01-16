package controller;

import DAO.SignupDAO;
import bags.Signup;
import common.BCrypt;
import common.MyConnection;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
        maxFileSize=1024*1024*10,//10MB
        maxRequestSize=1024*1024*50)//50MB

public class AddAdmin_controller extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException
    {
        resp.setContentType("text/html;charset=UTF-8");
        String name=req.getParameter("name");
        String contact=req.getParameter("contact");
        String email=req.getParameter("email");
        String password=BCrypt.hashpw(req.getParameter("name"),BCrypt.gensalt(12));
        String role="admin";
        Part part=req.getPart("file");
        String fileName=extractFileName(part);
        if(!fileName.isEmpty()){
        	System.out.println("change profile 1");
            File savePath = Paths.get(getServletContext().getRealPath("/"),"uploads","User Profile",fileName).toFile();
            savePath.getParentFile().mkdirs();
            try{
                FileOutputStream fos=new FileOutputStream(savePath);
                InputStream is=part.getInputStream();
                
                byte[] data=new byte[is.available()];
                is.read(data);
                fos.write(data);
                fos.close();
            }catch(Exception e){
              e.printStackTrace();
           }
        }
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ores","root","");
            PreparedStatement pst=conn.prepareStatement("insert into signup(name,contact,email,password,filename,path,role) values(?,?,?,?,?,?,?)");
            pst.setString(1,name);
            pst.setString(2,contact);
            pst.setString(3,email);
            pst.setString(4,password);
            pst.setString(5,fileName);
            pst.setString(6,"./uploads/User Profile/"+ fileName);
            pst.setString(7, role);
            pst.executeUpdate();
            resp.sendRedirect("admin/addadmin.jsp?status=success");
            
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
    private String extractFileName(Part part) {
        String contentDisp=part.getHeader("content-disposition");
        String[] items=contentDisp.split(";");
        for(String s : items){
            if(s.trim().startsWith("filename")){
                String stringFile =s.substring(s.indexOf("=") + 2,s.length() - 1);
                int index=stringFile.lastIndexOf("\\");
                if(index>0){
                    String filename=stringFile.substring(index+1);
                    return filename;
                }
            }
        }
        return "";
    }
}

