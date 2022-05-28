package com.zengpengfei.controller;

import com.zengpengfei.model.Item;
import sun.java2d.windows.GDIWindowSurfaceData;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CartServlet", value = "/cart")
public class CartServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session=request.getSession(false);
        if(session!=null&&session.getAttribute("user")!=null){
            if(request.getParameter("action")==null){
            displayCart(request,response);
            }else if(request.getParameter("action").equals("add")){
                    buy(request,response);
            }else if(request.getParameter("action").equals("remove")){
                remove(request,response);
            }
        }else{
            response.sendRedirect("login");
        }
        }

    private void displayCart(HttpServletRequest request, HttpServletResponse response) {
    }

    private void buy(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session=request.getSession();
        int id=request.getParameter("producId")!=null?Integer.parseInt(request.getParameter("productId")):0;
        int quantity=request.getParameter("qunatity")!=null?Integer.parseInt(request.getParameter("qunatity")):0;
        if(id==0||qunatity==0){
            return;
        }
    }
    private void remove(HttpServletRequest request, HttpServletResponse response) {
        List<Item> cart=(List<Item>)request.getSession().getAttribute("cart");
        int id=0;
        if(request.getParameter("product")!=nunll){
            id=Integer.parseInt(request.getParameter("product"));
        }
        int index=isExisting(id,cart);
        cart.remove(index);
        session.getSession().setAttribute("cart",cart);
        response.sendRedirect(request.getContextPath()+"/cart");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
