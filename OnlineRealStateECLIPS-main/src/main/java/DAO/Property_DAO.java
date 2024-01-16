package DAO;
import bags.Signup;
import bags.property_bag;
import common.BCrypt;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class Property_DAO {
    Connection conn;
    
    public Property_DAO(Connection conn){
        this.conn = conn;
    }
    
    
    public property_bag getSearch(property_bag sb){
        try{
            String sql="select name,pname,ptype,srproperty,psubtype,price,cityname,pincode,bedroom,bathroom,contact,filename,path from property where price between '"+sb.getMinprice()+"' and '"+sb.getMaxprice()+"' and ptype='"+sb.getPtype()+"' and srproperty='"+sb.getSrproperty()+"' and psubtype='"+sb.getPsubtype()+"' and bedroom='"+sb.getBedroom()+"' and bathroom='"+sb.getBathroom()+"' and cityname='"+sb.getCityname()+"' and pincode='"+sb.getPincode()+"'";
            Statement st=conn.createStatement();
            ResultSet rs =st.executeQuery(sql);
            property_bag pbdatabase=new property_bag();
            while(rs.next())
            {
                pbdatabase.setName(rs.getString("name"));
                pbdatabase.setPname(rs.getString("pname"));
                pbdatabase.setPtype(rs.getString("ptype"));
                pbdatabase.setSrproperty(rs.getString("srproperty"));
                pbdatabase.setPsubtype(rs.getString("psubtype"));
                pbdatabase.setPrice(rs.getFloat("price"));
                pbdatabase.setBedroom(rs.getString("bedroom"));
                pbdatabase.setBathroom(rs.getString("bathroom"));
                pbdatabase.setCityname(rs.getString("cityname"));
                pbdatabase.setContact(rs.getString("contact"));
                pbdatabase.setFilename(rs.getString("filename"));
                pbdatabase.setPath(rs.getString("path"));
            }
            return pbdatabase;
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            System.err.println("Error in Property_DAO getSearch function");
        }
        return null;
    }
    
    public boolean insert(property_bag pb){
        String sql="insert into property(id,name,contact,pname,price,ptype,srproperty,psubtype,bedroom,bathroom,area,areasq,cityname,pincode,details,image)"
                    + " values('"+pb.getId()+"','"+pb.getName()+"','"+pb.getContact()+"','"+pb.getPname()+"','"+pb.getPrice()+"','"+pb.getPtype()+"','"+pb.getSrproperty()+"','"+pb.getPsubtype()+"','"+pb.getBedroom()+"','"+pb.getBathroom()+"','"+pb.getArea()+"','"+pb.getAreasq()+"','"+pb.getCityname()+"','"+pb.getPincode()+"','"+pb.getDetails()+"','"+pb.getFilename()+"')";
            
        try{
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            st.close();
            return true;
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            System.err.println("Error in Property_DAO insert function");
        }
        return false;
    }
    public List getAlldata(){
        String sql="select * from property order by pid desc limit 6";
        List l=new ArrayList();
        try{
            Statement st=conn.createStatement();
            ResultSet rs =st.executeQuery(sql);
            while(rs.next()){
                property_bag pb=new property_bag();
                pb.setPid(rs.getInt("pid"));
                pb.setPname(rs.getString("pname"));
                pb.setPrice(rs.getFloat("price"));
                pb.setCityname(rs.getString("cityname"));
                pb.setSrproperty(rs.getString("srproperty"));
                pb.setPtype(rs.getString("ptype"));
                pb.setPsubtype(rs.getString("psubtype"));
                pb.setFilename(rs.getString("filename"));
                pb.setPath(rs.getString("path"));
                pb.setStatus(rs.getInt("status"));
                l.add(pb);
            }
            return l;
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            System.err.println("Error in Property_DAO getAlldata function");
        }
        return null;
    }
    public List getAlldata2(){
        String sql="select * from property order by pid desc limit 8";
        List l=new ArrayList();
        try{
            Statement st=conn.createStatement();
            ResultSet rs =st.executeQuery(sql);
            while(rs.next()){
                property_bag pb=new property_bag();
                pb.setPid(rs.getInt("pid"));
                pb.setPname(rs.getString("pname"));
                pb.setPrice(rs.getFloat("price"));
                pb.setCityname(rs.getString("cityname"));
                pb.setSrproperty(rs.getString("srproperty"));
                pb.setPtype(rs.getString("ptype"));
                pb.setPsubtype(rs.getString("psubtype"));
                pb.setFilename(rs.getString("filename"));
                pb.setPath(rs.getString("path"));
                pb.setStatus(rs.getInt("status"));
                l.add(pb);
            }
            return l;
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            System.err.println("Error in Property_DAO getAlldata function");
        }
        return null;
    }
    
    public List getAlldataRent(){
        String sql="select * from property where srproperty='Rent' order by pid desc limit 8";
        List l=new ArrayList();
        try{
            Statement st=conn.createStatement();
            ResultSet rs =st.executeQuery(sql);
            while(rs.next()){
                property_bag pb=new property_bag();
                pb.setPid(rs.getInt("pid"));
                pb.setPname(rs.getString("pname"));
                pb.setPrice(rs.getFloat("price"));
                pb.setCityname(rs.getString("cityname"));
                pb.setSrproperty(rs.getString("srproperty"));
                pb.setPtype(rs.getString("ptype"));
                pb.setPsubtype(rs.getString("psubtype"));
                pb.setFilename(rs.getString("filename"));
                pb.setPath(rs.getString("path"));
                pb.setStatus(rs.getInt("status"));
                l.add(pb);
            }
            return l;
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            System.err.println("Error in Property_DAO getAlldataRent function");
        }
        return null;
    }
    public List getAlldataSell(){
        String sql="select * from property where srproperty='Sale' order by pid desc limit 8";
        List l=new ArrayList();
        try{
            Statement st=conn.createStatement();
            ResultSet rs =st.executeQuery(sql);
            while(rs.next()){
                property_bag pb=new property_bag();
                pb.setPid(rs.getInt("pid"));
                pb.setPname(rs.getString("pname"));
                pb.setPrice(rs.getFloat("price"));
                pb.setCityname(rs.getString("cityname"));
                pb.setSrproperty(rs.getString("srproperty"));
                pb.setPtype(rs.getString("ptype"));
                pb.setPsubtype(rs.getString("psubtype"));
                pb.setFilename(rs.getString("filename"));
                pb.setPath(rs.getString("path"));
                pb.setStatus(rs.getInt("status"));
                l.add(pb);
            }
            return l;
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            System.err.println("Error in Property_DAO getAlldataSell function");
        }
        return null;
    }
    public List getCount(){
        String sql="select count(*) as count from property";
        List l=new ArrayList();
        try{
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                property_bag pb=new property_bag();
                pb.setPid(rs.getInt("count"));
                l.add(pb);
            }
            return l;
        }catch(Exception e){
            System.err.println(e.getMessage());
            System.err.println("Error in Property_DAO getCount function");
        }
        return null;
    }
    public List getCountUser(){
        String sql="select count(*) as user from signup where role='user'";
        List l=new ArrayList();
        try{
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                property_bag pb=new property_bag();
                pb.setId(rs.getInt("user"));
                l.add(pb);
            }
            return l;
        }catch(Exception e){
            System.err.println(e.getMessage());
            System.err.println("Error in Property_DAO getCountUser function");
        }
        return null;
    }
    public List getCountAdmin(){
        String sql="select count(*) as admin from signup where role='admin'";
        List l=new ArrayList();
        try{
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                property_bag pb=new property_bag();
                pb.setId(rs.getInt("admin"));
                l.add(pb);
            }
            return l;
        }catch(Exception e){
            System.err.println(e.getMessage());
            System.err.println("Error in Property_DAO getCountAdmin function");
        }
        return null;
    }
    public boolean delete(int id){
        try{
            String sql="delete from property where id="+id+"";
            Statement st=conn.createStatement();
            int status =st.executeUpdate(sql);
            if(status>0){
                return true;
            }
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            System.err.println("Error in Property_DAO delete function");
        }
        return false;
    }
    public List getMyProperty(Signup sb){
        String sql="select * from property where name='"+sb.getName()+"'";
        List l=new ArrayList();
        try{
            Statement st=conn.createStatement();
            ResultSet rs =st.executeQuery(sql);
            while(rs.next()){
                property_bag pb=new property_bag();
                pb.setPid(rs.getInt("pid"));
                pb.setName(rs.getString("name"));
                pb.setPname(rs.getString("pname"));
                pb.setPrice(rs.getFloat("price"));
                pb.setCityname(rs.getString("cityname"));
                pb.setSrproperty(rs.getString("srproperty"));
                pb.setPtype(rs.getString("ptype"));
                pb.setPsubtype(rs.getString("psubtype"));
                pb.setFilename(rs.getString("filename"));
                pb.setPath(rs.getString("path"));
                pb.setStatus(rs.getInt("status"));
                l.add(pb);
            }
            return l;
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            System.err.println("Error in Property_DAO getMyProperty function");
        }
        return null;
    }
    public List getApartment(Signup sb){
        String sql="select * from property where ptype='Apartment'";
        List l=new ArrayList();
        try{
            Statement st=conn.createStatement();
            ResultSet rs =st.executeQuery(sql);
            while(rs.next()){
                property_bag pb=new property_bag();
                pb.setPid(rs.getInt("pid"));
                pb.setName(rs.getString("name"));
                pb.setPname(rs.getString("pname"));
                pb.setPrice(rs.getFloat("price"));
                pb.setCityname(rs.getString("cityname"));
                pb.setSrproperty(rs.getString("srproperty"));
                pb.setPtype(rs.getString("ptype"));
                pb.setPsubtype(rs.getString("psubtype"));
                pb.setFilename(rs.getString("filename"));
                pb.setPath(rs.getString("path"));
                pb.setStatus(rs.getInt("status"));
                l.add(pb);
            }
            return l;
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            System.err.println("Error in Property_DAO getApartment function");
        }
        return null;
    }
    public List getVilla(Signup sb){
        String sql="select * from property where ptype='Independent House/Villa'";
        List l=new ArrayList();
        try{
            Statement st=conn.createStatement();
            ResultSet rs =st.executeQuery(sql);
            while(rs.next()){
                property_bag pb=new property_bag();
                pb.setPid(rs.getInt("pid"));
                pb.setName(rs.getString("name"));
                pb.setPname(rs.getString("pname"));
                pb.setPrice(rs.getFloat("price"));
                pb.setCityname(rs.getString("cityname"));
                pb.setSrproperty(rs.getString("srproperty"));
                pb.setPtype(rs.getString("ptype"));
                pb.setPsubtype(rs.getString("psubtype"));
                pb.setFilename(rs.getString("filename"));
                pb.setPath(rs.getString("path"));
                pb.setStatus(rs.getInt("status"));
                l.add(pb);
            }
            return l;
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            System.err.println("Error in Property_DAO getVilla function");
        }
        return null;
    }
    public List getFloor(Signup sb){
        String sql="select * from property where ptype='Independent/Builder Floor'";
        List l=new ArrayList();
        try{
            Statement st=conn.createStatement();
            ResultSet rs =st.executeQuery(sql);
            while(rs.next()){
                property_bag pb=new property_bag();
                pb.setPid(rs.getInt("pid"));
                pb.setName(rs.getString("name"));
                pb.setPname(rs.getString("pname"));
                pb.setPrice(rs.getFloat("price"));
                pb.setCityname(rs.getString("cityname"));
                pb.setSrproperty(rs.getString("srproperty"));
                pb.setPtype(rs.getString("ptype"));
                pb.setPsubtype(rs.getString("psubtype"));
                pb.setFilename(rs.getString("filename"));
                pb.setPath(rs.getString("path"));
                pb.setStatus(rs.getInt("status"));
                l.add(pb);
            }
            return l;
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            System.err.println("Error in Property_DAO getFloor function");
        }
        return null;
    }
    public List getLand(Signup sb){
        String sql="select * from property where ptype='Land'";
        List l=new ArrayList();
        try{
            Statement st=conn.createStatement();
            ResultSet rs =st.executeQuery(sql);
            while(rs.next()){
                property_bag pb=new property_bag();
                pb.setPid(rs.getInt("pid"));
                pb.setName(rs.getString("name"));
                pb.setPname(rs.getString("pname"));
                pb.setPrice(rs.getFloat("price"));
                pb.setCityname(rs.getString("cityname"));
                pb.setSrproperty(rs.getString("srproperty"));
                pb.setPtype(rs.getString("ptype"));
                pb.setPsubtype(rs.getString("psubtype"));
                pb.setFilename(rs.getString("filename"));
                pb.setPath(rs.getString("path"));
                pb.setStatus(rs.getInt("status"));
                l.add(pb);
            }
            return l;
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            System.err.println("Error in Property_DAO getLand function");
        }
        return null;
    }
    public List getFarmhouse(Signup sb){
        String sql="select * from property where ptype='Farmhouse'";
        List l=new ArrayList();
        try{
            Statement st=conn.createStatement();
            ResultSet rs =st.executeQuery(sql);
            while(rs.next()){
                property_bag pb=new property_bag();
                pb.setPid(rs.getInt("pid"));
                pb.setName(rs.getString("name"));
                pb.setPname(rs.getString("pname"));
                pb.setPrice(rs.getFloat("price"));
                pb.setCityname(rs.getString("cityname"));
                pb.setSrproperty(rs.getString("srproperty"));
                pb.setPtype(rs.getString("ptype"));
                pb.setPsubtype(rs.getString("psubtype"));
                pb.setFilename(rs.getString("filename"));
                pb.setPath(rs.getString("path"));
                pb.setStatus(rs.getInt("status"));
                l.add(pb);
            }
            return l;
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            System.err.println("Error in Property_DAO getFarmhouse function");
        }
        return null;
    }
    public property_bag checkOut(int pid){
        try{
            String sql="select * from property where pid="+pid+"";
            Statement st=conn.createStatement();
            ResultSet rs =st.executeQuery(sql);
            property_bag pb=new property_bag();
            while(rs.next()){
                pb.setPid(rs.getInt("pid"));
                pb.setId(rs.getInt("id"));
                pb.setName(rs.getString("name"));
                pb.setPname(rs.getString("pname"));
                pb.setPtype(rs.getString("ptype"));
                pb.setSrproperty(rs.getString("srproperty"));
                pb.setPsubtype(rs.getString("psubtype"));
                pb.setDetails(rs.getString("details"));
                pb.setPrice(Float.parseFloat(rs.getString("price")));
                pb.setContact(rs.getString("contact"));
                pb.setCityname(rs.getString("cityname"));
                pb.setPincode(rs.getString("pincode"));
                pb.setAddress(rs.getString("address"));
                pb.setLocation(rs.getString("location"));
                pb.setBedroom(rs.getString("bedroom"));
                pb.setBathroom(rs.getString("bathroom"));
                pb.setArea(rs.getString("area"));
                pb.setAreasq(rs.getString("areasq"));
                pb.setFilename(rs.getString("filename"));
                pb.setPath(rs.getString("path"));
            }
            return pb;
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            System.err.println("Error in Property_DAO checkOut function");
        }
        return null;
    }
    
    
    
}