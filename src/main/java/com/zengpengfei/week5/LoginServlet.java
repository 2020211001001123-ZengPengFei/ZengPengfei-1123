package com.zengpengfei.week5;

import com.zengpengfei.dao.UserDao;
import com.zengpengfei.model.User;
import sun.util.resources.ext.CalendarData_da;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doPost(request,response);
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //UserDao userDao = new UserDao();
        User user = null;
        try {
            UserDao userDao = new UserDao();
            user = userDao.findByUsernamePassword(con, username, password);

            if (user != null) {
            /*Cookie c = new Cookie("sessionid", "" += user.getId());
            c.setMaxAge(10 * 60);
            response.addCookie(c);*/
                String rememberMe=request.getParameter("rememberMe");
                if (rememberMe!=null&& rememberMe.equals("1")){
                    Cookie usernameCookies =new Cookie("cUsername",user.getUsername());
                    Cookie passwordCookies =new Cookie("cPassword",user.getPassword());
                    Cookie rememberMeCookies =new Cookie("cRememberMe",rememberMe);
                    usernameCookies.setMaxAge(5);
                    passwordCookies.setMaxAge(5);
                    rememberMeCookies.setMaxAge(5);
                    response.addCookie(usernameCookies);
                    response.addCookie(passwordCookies);
                    response.addCookie(rememberMeCookies);
                }

                HttpSession session=request.getSession();
                System.out.println("session id-->"+session.getId());
                session.setMaxInactiveInterval(10);

                session.setAttribute("user", user);
                request.getRequestDispatcher("WEB-INF/views/userInfo").forward(request, response);
            } else {
                request.setAttribute("message", "Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        /*if (user != null) {
            *//*Cookie c = new Cookie("sessionid", "" += user.getId());
            c.setMaxAge(10 * 60);
            response.addCookie(c);*//*
            request.setAttribute("user", user);
            request.getRequestDispatcher("WEB-INF/views/userInfo").forward(request, response);
        } else {
            request.setAttribute("message", "Username or Password Error!!!");
            request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
        }*/


        /*String sql="select username,password,email,gender,birthdate from usertable where username='"+username+"' and password='"+password+"'and email='\"+email+\"'and gender='\"+gender+\"'and birthdate='\"+birthdate+\"'";
        try{
            ResultSet rs =con.createStatement().executeQuery(sql);
            if(rs.next()){
                //out.print("Login successful!!!");
                //out.print("welcom"+username);
                //get from rs and set into resquest attribute
                request.setAttribute("id",rs.getInt("id"));
                request.setAttribute("username",rs.getInt("username"));
                request.setAttribute("password",rs.getInt("password"));
                request.setAttribute("email",rs.getInt("email"));
                request.setAttribute("gender",rs.getInt("gender"));
                request.setAttribute("birthdate",rs.getInt("birthdate"));
                request.getRequestDispatcher("userInfo.jsp").forward(request,response);

            } else{
                request.setAttribute("message","Username or Password ERROR!!!");
                request.getRequestDispatcher("login.jsp").forward(request,response);
                //out.print("username or password error");

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/

    }
}
