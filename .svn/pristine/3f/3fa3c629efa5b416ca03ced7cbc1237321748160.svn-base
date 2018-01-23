package servlet;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import dao.DbDao;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Order_admin/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
        String username = request.getParameter("user_name");
        String password = request.getParameter("user_password");
        String usercname = request.getParameter("user_cname");
        String userphone = request.getParameter("user_phone");
        
        try{
        	DbDao dd = new DbDao("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/shopping",
                    "root", "root");
        	ResultSet rs = dd.query("select user_name from t_user where user_name = ?", username);
        	if(rs.next()){
        		//用户名已经存在，显示注册失败信息
        		 request.setAttribute("message", "用户已经存在 ");
        		 request.getRequestDispatcher("register.html").forward(request, response);
        	}else{
        		String sql = "insert into t_user (user_name,user_password,user_cname,use_phone,user_type) values(?,?,?,?,?)";
        		
        		Object[] args = {username,password,usercname,userphone,0};
        		dd.insert(sql, args);
        		
        		//注册成功，并且添加到数据库
        		rd = request.getRequestDispatcher("check_register.html");
                rd.forward(request, response);
        		try{
        			
        		}catch(Exception e){
        			e.printStackTrace();
        		}
        		
        	}
        }catch(Exception e){
        	e.printStackTrace();
        }
	}

}
