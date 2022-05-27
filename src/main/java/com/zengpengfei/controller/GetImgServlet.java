package com.zengpengfei.controller;

import com.zengpengfei.dao.ProductDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "GetImgServlet", value = "/GetImgServlet")

public class GetImgServlet extends HttpServlet {
    @Override
    public void init()throws ServletException{
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=0;
        if(request.getParameter("id")!=null)
        int id=Integer.parseInt(request.getParameter("id"));
        ProductDao productDao=new ProductDao();
        try{
            byte[]=ProductDao.getPictureById(id,con);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
