package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DbDao;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/Order_admin/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String errMsg = "";
        RequestDispatcher rd;
        String product_name = request.getParameter("delete_pro");

        try {
        	DbDao dd = new DbDao("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/shopping",
                    "root", "root");
        	String sql="delete from menu where FoodName=?";
        	boolean result=dd.deletePro(sql, product_name);
        	HttpSession session = request.getSession(true);
        	if(result) {
        		//获取session对象
                session.setAttribute("result", "删除成功");
                System.out.println("删除成功");
                //获取转发对象
                rd = request.getRequestDispatcher("del_product.jsp");
                
                // 转发请求
                rd.forward(request, response);
        	}else {
        		session.setAttribute("result", "失败");
                
                //获取转发对象
                rd = request.getRequestDispatcher("del_product.jsp");
                System.out.println("删除失败");
                // 转发请求
                rd.forward(request, response);
        	}
        }catch(Exception e) {
            e.printStackTrace();
        }
        // 如果出错，转发到重新登陆
        if(errMsg != null && !errMsg.equals("")){
            rd = request.getRequestDispatcher("login.html");
            request.setAttribute("err", errMsg);
            rd.forward(request, response);
        }
	}
	

}
