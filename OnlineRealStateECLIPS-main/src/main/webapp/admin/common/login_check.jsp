<%@page import="bags.*"%>
<%
    if(session.getAttribute("Signup")!=null){
        Signup sb=(Signup) session.getAttribute("Signup");
        if(sb.getRole().equals("admin")){
            response.sendRedirect("signin.jsp");
        }
    }else{
        response.sendRedirect("signin.jsp");
    }
%>