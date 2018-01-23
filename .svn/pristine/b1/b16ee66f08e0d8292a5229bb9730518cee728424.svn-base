package servlet;

import service.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/SubmitServlet")
public class SubmitServlet extends HttpServlet {
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    //创建ProService对象
    private ProService service = new ProService();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //在doGet()方法中调用doPost()
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //设置字符集编码格式
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //PrintWriter out = response.getWriter();

        //接收从页面传来的操作类型
        String type = request.getParameter("type");

        //定义CartService
        CartService cart = null ;
        //创建session
        HttpSession session = request.getSession();
        //从Session当中取购物车，查看此购物车是否存在

        cart = (CartService)session.getAttribute("cart");

        System.out.println(cart);
        Map<Integer, Items> map = cart.getMap();
        String content="";
        for (Map.Entry<Integer, Items> entry : map.entrySet()) {

            content = content + entry.getValue().getProduct().getName()+" X " +entry.getValue().getNum()+" ; ";

        }
        System.out.println(content);
        String Name = request.getParameter("name");
        String Phone = request.getParameter("phone");
        String Address = request.getParameter("address");
        String Message = request.getParameter("message");
        System.out.println(Name+Phone);
        Connection conn = DBUtil.getConnection();
        String sql = "insert into OrderContent(foodcontent,username,userphone,useraddress,userremark) values(?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, content);
            ps.setString(2, Name);
            ps.setString(3, Phone);
            ps.setString(4, Address);
            ps.setString(5, Message);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBUtil.closeAll(rs, ps, conn);
        }
        request.getRequestDispatcher("Order_admin/Refresh.html").forward(request,response);
        //out.flush();
        //out.close();
    }
}