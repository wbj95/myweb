package servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DbDao;

/**
 * Servlet implementation class ManagerServlet
 */
@WebServlet("/Order_admin/ManagerServlet")
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServlet() {
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
    
        try {
            DbDao dd = new DbDao("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/shopping",
                    "root", "root");
            
            // 查询结果集
            ResultSet rs = dd.query("select user_password,user_type from t_user where user_name = ?", username);
            //ResultSet rs1 = dd.query("select   from t_user where user_name = ?", username);

            if(rs.next()){
                //用户名和密码匹配
            	System.out.println(rs.getInt("user_type"));
                if(rs.getString("user_password").equals(password)&&rs.getInt("user_type")==1) {
                    //获取session对象
                    HttpSession session = request.getSession(true);
                    session.setAttribute("username", username);
                    
                    //获取转发对象
                    rd = request.getRequestDispatcher("index.html");
                    
                    // 转发请求
                    rd.forward(request, response);
                } else {
                    errMsg += "您的用户名密码不匹配，请重新输入";
                }
            } else {
                errMsg += "您的用户名不存在，请先注册";
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
