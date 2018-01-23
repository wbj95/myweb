package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DbDao;
import service.CartService;
import service.DBUtil;
import service.Items;
import service.Product;

/**
 * Servlet implementation class DelorderServlet
 */
@WebServlet("/Order_admin/DelorderServlet")
public class DelorderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PreparedStatement ps = null;
    private ResultSet rs = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelorderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		//设置字符集编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        RequestDispatcher rd;
        //接收从页面传来的操作类型
        
        String type = request.getParameter("type");
        PrintWriter out = response.getWriter();

       
        if("delete".equals(type)){
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println(id);
            Connection conn = DBUtil.getConnection();
            try {
            	DbDao dd = new DbDao("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/shopping",
                        "root", "root");
            	String sql="delete from ordercontent where orderid=?";
            	boolean result=dd.deleteOrder(sql, id);
            	HttpSession session = request.getSession(true);
            	if(result) {
            		//获取session对象
                    session.setAttribute("result", "删除成功");
                    System.out.println("删除成功");
                    //获取转发对象
                    out.print("ok");
            	}
            	conn.close();
            }catch(Exception e) {
                e.printStackTrace();
            }   
        }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
