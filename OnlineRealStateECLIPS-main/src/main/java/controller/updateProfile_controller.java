package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
        maxFileSize=1024*1024*10,//10MB
        maxRequestSize=1024*1024*50)//50MB

public class updateProfile_controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         resp.setContentType("text/html;charset=UTF-8");
        String name=req.getParameter("name");
        String contact=req.getParameter("contact");
        String email=req.getParameter("email");Part part=req.getPart("file");
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
            try{
                Class.forName("com.mysql.jdbc.Driver");
                java.sql.Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ores","user","user");
                PreparedStatement pst=conn.prepareStatement("update signup set name=?,contact=?,email=?,filename=?,path=? where name='"+name+"'");
                pst.setString(1,name);
                pst.setString(2,contact);
                pst.setString(3,email);
                pst.setString(4,fileName);
                pst.setString(5,"./uploads/User Profile/"+ fileName);
                pst.executeUpdate();
                resp.sendRedirect("profile.jsp?status=success");
            }catch(Exception e){
                System.err.println("Error in updateProfile_controller: "+e.getMessage());
            }
        }else{
        	System.out.println("change profile 2");
            try{
                String name2=req.getParameter("name");
                String contact2=req.getParameter("contact");
                String email2=req.getParameter("email");
                
                Class.forName("com.mysql.jdbc.Driver");
                java.sql.Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ores","user","user");
                PreparedStatement pst=conn.prepareStatement("update signup set name=?,contact=?,email=? where name='"+name+"'");
                pst.setString(1,name2);
                pst.setString(2,contact2);
                pst.setString(3,email2);
                pst.executeUpdate();
                resp.sendRedirect("profile.jsp?status=success");
            }catch(Exception e){
                System.err.println("Error in updateProfile_controller: "+e.getMessage());
            }
        }
    }
    private String extractFileName(Part part) {
        String contentDisp=part.getHeader("content-disposition");
        String[] items=contentDisp.split(";");
        for(String s : items){
            if(s.trim().startsWith("filename")){
                String stringFile =s.substring(s.indexOf("=") + 2,s.length() - 1);
                int index=stringFile.lastIndexOf("\\");
                String filename;
                if(index>0){
                    filename=stringFile.substring(index+1);
                    
                } else {
                	filename = stringFile;
                }
                return filename;
            }
        }
        return "";
    }
}
