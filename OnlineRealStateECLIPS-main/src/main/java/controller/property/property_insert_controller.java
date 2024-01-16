package controller.property;

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

import bags.property_bag;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB

public class property_insert_controller extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		property_bag pb = new property_bag();

		String userid = req.getParameter("userid");
		String username = req.getParameter("username");
		String contact = req.getParameter("contact");
		String pname = req.getParameter("pname");
		String price = req.getParameter("price");
		String ptype = req.getParameter("ptype");
		String srproperty = req.getParameter("srproperty");
		String psubtype = req.getParameter("psubtype");
		String bedroom = req.getParameter("bedroom");
		String bathroom = req.getParameter("bathroom");
		String cityname = req.getParameter("cityname");
		String pincode = req.getParameter("pincode");
		String details = req.getParameter("details");
		String area = req.getParameter("area");
		String areasq = req.getParameter("areasq");
		String address = req.getParameter("address");
		String location = req.getParameter("location");

		Part part = req.getPart("file");
		String fileName = extractFileName(part);
		File savePath = Paths.get(getServletContext().getRealPath("/"), "uploads","Properties", fileName).toFile();
        savePath.getParentFile().mkdirs(); // create upload directory
        try {
            FileOutputStream fos = new FileOutputStream(savePath);
            InputStream is = part.getInputStream();

            byte[] data = new byte[is.available()];
            is.read(data);
            fos.write(data);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
            }

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ores", "root", "");
			PreparedStatement pst = conn.prepareStatement(
					"insert into property(id,name,contact,pname,price,ptype,srproperty,psubtype,bedroom,bathroom,area,areasq,cityname,pincode,address,location,details,filename,path) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, userid);
			pst.setString(2, username);
			pst.setString(3, contact);
			pst.setString(4, pname);
			pst.setString(5, price);
			pst.setString(6, ptype);
			pst.setString(7, srproperty);
			pst.setString(8, psubtype);
			pst.setString(9, bedroom);
			pst.setString(10, bathroom);
			pst.setString(11, area);
			pst.setString(12, areasq);
			pst.setString(13, cityname);
			pst.setString(14, pincode);
			pst.setString(15, address);
			pst.setString(16, location);
			pst.setString(17, details);
			pst.setString(18, fileName);
			pst.setString(19, "./uploads/Properties/"+fileName);
			pst.executeUpdate();
			resp.sendRedirect("postproperty.jsp?status=success");

		} catch (Exception e) {
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

                String filename;
                if (index > 0) {
                    filename = stringFile.substring(index + 1);
                } else {
                    filename = stringFile;
                }

                return filename;
            }
        }
        return "";
}

	/*
	 * String contentType=req.getContentType(); String
	 * realPath=getServletConfig().getServletContext().getRealPath("/");
	 * realPath=realPath.replace("build\\web\\", "web\\img\\Properties"); File file;
	 * if(contentType.indexOf("multipart/form-data")>=0){ try{ DiskFileItemFactory
	 * factory=new DiskFileItemFactory(); factory.setSizeThreshold(8000000);
	 * factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
	 * ServletFileUpload upload=new ServletFileUpload(factory);
	 * upload.setSizeMax(8000000); List fileItems=upload.parseRequest(req); Iterator
	 * i=fileItems.iterator(); while(i.hasNext()){ FileItem fi=(FileItem)i.next();
	 * if(!fi.isFormField()){ String name=fi.getName(); file=new
	 * File(realPath,name); fi.write(file); pb.setFilename(name); }else
	 * if(fi.isFormField()){ if(fi.getFieldName().equals("userid")){
	 * pb.setId(Integer.parseInt(fi.getString()));
	 * System.err.println("userid--- "+fi.getString()); } else
	 * if(fi.getFieldName().equals("username")){ pb.setName(fi.getString());
	 * System.err.println("username--- "+fi.getString()); } else
	 * if(fi.getFieldName().equals("contact")){ pb.setContact(fi.getString());
	 * System.err.println("contact--- "+fi.getString()); } else
	 * if(fi.getFieldName().equals("pname")){ pb.setPname(fi.getString());
	 * System.err.println("pname--- "+fi.getString()); } else
	 * if(fi.getFieldName().equals("price")){
	 * pb.setPrice(Float.parseFloat(fi.getString()));
	 * System.err.println("price--- "+fi.getString()); } else
	 * if(fi.getFieldName().equals("ptype")){ pb.setPtype(fi.getString());
	 * System.err.println("ptype--- "+fi.getString()); } else
	 * if(fi.getFieldName().equals("srproperty")){ pb.setSrproperty(fi.getString());
	 * System.err.println("srproperty--- "+fi.getString()); } else
	 * if(fi.getFieldName().equals("psubtype")){ pb.setPsubtype(fi.getString());
	 * System.err.println("psubtype--- "+fi.getString()); } else
	 * if(fi.getFieldName().equals("bedroom")){ pb.setBedroom(fi.getString());
	 * System.err.println("bedroom--- "+fi.getString()); } else
	 * if(fi.getFieldName().equals("bathroom")){ pb.setBathroom(fi.getString());
	 * System.err.println("bathroom--- "+fi.getString()); } else
	 * if(fi.getFieldName().equals("area")){ pb.setArea(fi.getString());
	 * System.err.println("area--- "+fi.getString()); } else
	 * if(fi.getFieldName().equals("areasq")){ pb.setAreasq(fi.getString());
	 * System.err.println("areasq--- "+fi.getString()); } else
	 * if(fi.getFieldName().equals("cityname")){ pb.setCityname(fi.getString());
	 * System.err.println("cityname--- "+fi.getString()); } else
	 * if(fi.getFieldName().equals("pincode")){ pb.setPincode(fi.getString());
	 * System.err.println("pincode--- "+fi.getString()); } else
	 * if(fi.getFieldName().equals("details")){ pb.setDetails(fi.getString());
	 * System.err.println("details--- "+fi.getString()); } } } } catch(Exception e){
	 * System.err.println(e);
	 * System.err.println("Error in property_insert_controller"); } } boolean b=new
	 * Property_DAO(MyConnection.connectTo()).insert(pb); if(b){
	 * resp.sendRedirect("postproperty.jsp?status=success"); } else{
	 * resp.sendRedirect("postproperty.jsp?status=failed"); }
	 */

}
