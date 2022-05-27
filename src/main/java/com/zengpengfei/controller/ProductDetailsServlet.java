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

@WebServlet(name = "ProductDetailsServlet", value = "/ProductDetailsServlet")
public class ProductDetailsServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Category> categoryList=category.findAllCategory(con);
            request.setAttribute("categoryList",categoryList);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        try{
            if(request.getParameter("id")!=null){
                int productId=Integer.parseInt(request.getParameter("id"));
                ProductDao productDao=new ProductDao();
                Product product=productDao.findById(productId,con);
            }
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
        String path="/WEB-INF/views/productDetails.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
