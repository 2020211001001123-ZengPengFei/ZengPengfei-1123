package com.zengpengfei.lab1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LifeCycleServlet", value = "/LifeCycleServlet")
public class LifeCycleServlet extends HttpServlet {
        public void init(ServletConfig config)throws ServletException{
            System.out.println("init");
        }

    //@Override
    //protected
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("service");


            //       统计网站访问量
            //       访问量 放入到servletContext里，，setAttribute("count");
            //       其他servlet获取该变量，然后进行自增
            //       再重新放入到 servletContext
            //       再把结果集显示页面上

            ServletContext context = this.getServletContext();
            Integer count = (Integer) context.getAttribute("count");
            if (count == null) {
                // 第一次访问服务器
                count = 1;
            } else {
                // 进行自增
                count = count + 1;
            }
            // 把最新的count放到ServletContext里
            context.setAttribute("count", count);

            // 中文会乱码，需设置编码格式,必须在PrintWriter获取之前设置编码
            resp.setContentType("text/html;charset=UTF-8");
            //resp.setCharacterEncoding("UTF-8");

            // 把统计数输出页面
            PrintWriter writer = resp.getWriter();
            writer.write("网站总访问数(since loading,this servlet has been accessed ):" + count + "times");

        }



    //@Override
    //protected
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("i am from default constructor");
    }
    public void destroy(){
        System.out.println("destory");
    }
}
