package com.zengpengfei.controller;

import com.zengpengfei.dao.ProductDao;
import com.zengpengfei.model.Category;
import com.zengpengfei.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "ShopServlet", value = "/ShopServlet")
public class ShopServlet extends HttpServlet {
    @Override
    public void init()throws ServletException{
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category=new Category();
        try {
            List<Category> categoryList=category.findAllCategory(con);
            request.setAttribute("categoryList",categoryList);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

        ProductDao productDao=new ProductDao();
        try {
            List<Product> productList = productDao.findAll(con);
            request.setAttribute("productList", productList);
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
        String path="/WEB-INF/views/admin/productList.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
