package com.zengpengfei.week3.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/life")
public class LifeCycleServlet extends HttpServlet {
    Connection con=null;
    public LifeCycleServlet(){
        System.out.println("i am in constructor-->LifeCycleServlet()");
    }
    public void init()throws ServletException{
        ServletContext context=getServletContext();
        String driver=context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");
        try {
            Class.forName(driver);
            Connection con= DriverManager.getConnection(url,username,password);
            System.out.println("Connection-->in JDBCDemoServlet"+con);
            //3 times
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        System.out.println("i am in init() ->LifeCycleServlet()-->"+con);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("i am in service()-->doGet() ");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        System.out.println("i am in destory() ");
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
