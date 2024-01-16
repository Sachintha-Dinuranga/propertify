package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import bags.Signup;
import common.BCrypt;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB

public class Signup_controller extends HttpServlet {

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        /* do post method is because post method is used in signup.jsp */
        
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out=resp.getWriter();/* for printing */
        String[] errors=new String[4];
        Signup s=new Signup();
        
        String name=req.getParameter("name");
        String contact=req.getParameter("contact");
        String email=req.getParameter("email");
        String password=BCrypt.hashpw(req.getParameter("password"),BCrypt.gensalt(12));
        
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
            Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ores","user","user");
            PreparedStatement pst=conn.prepareStatement("insert into signup(name,contact,email,password,filename,path) values(?,?,?,?,?,?)");
            pst.setString(1,name);
            pst.setString(2,contact);
            pst.setString(3,email);
            pst.setString(4,password);    
            pst.setString(5,fileName);
            pst.setString(6,"./uploads/User Profile/"+ fileName);
            pst.executeUpdate();
            resp.sendRedirect("success.jsp?status=success");
            
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
    }

	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				String stringFile = s.substring(s.indexOf("=") + 2, s.length() - 1);
				int index = stringFile.lastIndexOf("\\");
				if (index > 0) {
					String filename = stringFile.substring(index + 1);
					return filename;
				}
			}
		}
		return "";
	}
}

/*
 * if(!req.getParameter("name").equals("") &&
 * !req.getParameter("name").equals(" ")){ s.setName(req.getParameter("name"));
 * } else{ errors[0]="Name field is not valid !"; }
 * if(!req.getParameter("contact").equals("") &&
 * !req.getParameter("contact").equals(" ")){
 * s.setContact(req.getParameter("contact")); } else{
 * errors[1]="Contact field is not valid !"; }
 * if(!req.getParameter("email").equals("") &&
 * !req.getParameter("email").equals(" ")){
 * s.setEmail(req.getParameter("email")); } else{
 * errors[2]="Email field is not valid !"; }
 * if(!req.getParameter("password").equals("") &&
 * !req.getParameter("password").equals(" ")){
 * s.setPassword(BCrypt.hashpw(req.getParameter("password"),BCrypt.gensalt(12)))
 * ; } else{ errors[3]="Password field is not valid !"; }
 * 
 * SignupDAO sd=new SignupDAO(MyConnection.connectTo()); boolean
 * bool=sd.insert(s); if(bool){ resp.sendRedirect("success.jsp"); } else{
 * resp.sendRedirect("signup.jsp?info=failed"); }
 */
