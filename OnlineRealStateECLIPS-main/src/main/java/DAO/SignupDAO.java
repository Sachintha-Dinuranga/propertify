package DAO;

import bags.Signup;
import bags.property_bag;
import common.BCrypt;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SignupDAO {
	Connection conn;

	public SignupDAO(Connection conn) {
		this.conn = conn;
	}

	public boolean insert(Signup s) {
		try {
			String sql = "insert into signup(name,contact,email,password) values('" + s.getName() + "','"
					+ s.getContact() + "','" + s.getEmail() + "','" + s.getPassword() + "')";
			Statement st = conn.createStatement();
			st.executeUpdate(sql);
			st.close();
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("Error in SignupDAO insert function");
		}
		return false;
	}

	public boolean insertadmin(Signup s) {
		try {
			String sql = "insert into signup(name,contact,email,password,role) values('" + s.getName() + "','"
					+ s.getContact() + "','" + s.getEmail() + "','" + s.getPassword() + "','admin')";
			Statement st = conn.createStatement();
			st.executeUpdate(sql);
			st.close();
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("Error in SignupDAO insertadmin function");
		}
		return false;
	}

	public Signup signin(Signup s) {
		try {
			String sql = "select * from signup where email='" + s.getEmail() + "'";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);/* result from the above sqlquery is stored *//* is like interface */
			Signup sdatabase = new Signup();
			while (rs.next()) {
				sdatabase.setId(rs.getInt("id"));
				sdatabase.setName(rs.getString("name"));
				sdatabase.setContact(rs.getString("contact"));
				sdatabase.setEmail(rs.getString("email"));
				sdatabase.setPassword(rs.getString("password"));
				sdatabase.setFilename(rs.getString("filename"));
				sdatabase.setPath(rs.getString("path"));
				sdatabase.setRole(rs.getString("role"));
			}
			boolean b = BCrypt.checkpw(s.getPassword(), sdatabase.getPassword());
			if (b) {
				return sdatabase;
			} else {
				return null;
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("Error in SignupDAO signin function");
		}
		return null;
	}

	public Signup changePassword(Signup s) {
		try {
			String sql = "select * from signup where email='" + s.getEmail() + "'";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);/* result from the above sqlquery is stored *//* is like interface */
			Signup sdatabase = new Signup();
			while (rs.next()) {
				sdatabase.setId(rs.getInt("id"));
				sdatabase.setPassword(rs.getString("password"));
			}
			boolean b = BCrypt.checkpw(s.getCpassword(), sdatabase.getPassword());
			if (b) {
				return sdatabase;
			} else {
				return null;
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("Error in SignupDAO signin function");
		}
		return null;
	}

	public Signup adminsignin(Signup s) {
		try {
			String sql = "select * from admin where username='" + s.getEmail() + "'";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);/* result from the above sqlquery is stored *//* is like interface */
			Signup sdatabase = new Signup();
			while (rs.next()) {
				sdatabase.setId(rs.getInt("id"));
				sdatabase.setEmail(rs.getString("username"));
				sdatabase.setPassword(rs.getString("password"));
				sdatabase.setRole(rs.getString("role"));
			}
			String str1 = s.getPassword();
			String str2 = sdatabase.getPassword();
			boolean bool = str1.equals(str2);
			if (bool) {
				return sdatabase;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("Error in SignupDAO adminsignin function");
		}
		return null;
	}

	public List getAlldata() {
		String sql = "select * from signup where role='user'";
		List l = new ArrayList();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Signup sb = new Signup();
				sb.setId(rs.getInt("id"));
				sb.setName(rs.getString("name"));
				sb.setContact(rs.getString("contact"));
				sb.setEmail(rs.getString("email"));
				sb.setRole(rs.getString("role"));
				l.add(sb);
			}
			return l;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("Error in SignupDAO getAlldata function");
		}
		return null;
	}

	public List getAlladmin() {
		String sql = "select * from signup where role='admin'";
		List l = new ArrayList();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Signup sb = new Signup();
				sb.setId(rs.getInt("id"));
				sb.setName(rs.getString("name"));
				sb.setEmail(rs.getString("email"));
				sb.setRole(rs.getString("role"));
				l.add(sb);
			}
			return l;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("Error in SignupDAO getAlladmin function");
		}
		return null;
	}

	public boolean delete(int id) {
		try {
			String sql = "delete from signup where id=" + id + "";
			Statement st = conn.createStatement();
			int status = st.executeUpdate(sql);
			if (status > 0) {
				return true;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("Error in SignupDAO delete function");
		}
		return false;
	}

	public Signup viewProfile(int id) {
		try {
			String sql = "select * from signup where id=" + id + "";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			Signup sb = new Signup();
			while (rs.next()) {
				sb.setName(rs.getString("name"));
				sb.setContact(rs.getString("contact"));
				sb.setEmail(rs.getString("email"));
				sb.setFilename(rs.getString("filename"));
				sb.setPath(rs.getString("path"));
				sb.setRole(rs.getString("role"));
			}
			return sb;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("Error in SignupDAO delete function");
		}
		return null;
	}

	public boolean deleteAdmin(int id) {
		try {
			String sql = "delete from signup where id=" + id + "";
			Statement st = conn.createStatement();
			int status = st.executeUpdate(sql);
			if (status > 0) {
				return true;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("Error in SignupDAO deleteAdmin function");
		}
		return false;
	}

	public List getDBName() {
		String sql = "select name from signup";
		List l = new ArrayList();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Signup sb = new Signup();
				sb.setName(rs.getString("name"));
				l.add(sb);
			}
			return l;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("Error in SignupDAO getDBName function");
		}
		return null;
	}

	public List getpropertyID() {
		String sql = "select id from signup";
		List l = new ArrayList();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Signup sb = new Signup();
				sb.setId(rs.getInt("id"));
				l.add(sb);
			}
			return l;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("Error in SignupDAO getpropertyID function");
		}
		return null;
	}

	public List getFeedback() {
		String sql = "select * from feedback order by id desc";
		List l = new ArrayList();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Signup sb = new Signup();
				sb.setId(rs.getInt("id"));
				sb.setIntention(rs.getString("intention"));
				sb.setFeedback(rs.getString("comment"));
				sb.setEmail(rs.getString("email"));
				sb.setName(rs.getString("name"));
				sb.setContact(rs.getString("contact"));
				l.add(sb);
			}
			return l;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("Error in SignupDAO getFeedback function");
		}
		return null;
	}

	public Signup getProfile(int id) {
		try {
			String sql = "select * from signup where id=" + id + "";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			Signup s = new Signup();
			while (rs.next()) {
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setContact(rs.getString("contact"));
				s.setEmail(rs.getString("email"));
				s.setFilename(rs.getString("filename"));
				s.setPath(rs.getString("path"));
			}
			return s;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("Error in SignupDAO getProfile function");
		}
		return null;
	}

}
