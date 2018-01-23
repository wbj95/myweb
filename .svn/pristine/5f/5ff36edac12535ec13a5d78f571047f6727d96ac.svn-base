package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FileUtils;
import javax.servlet.ServletContext;

import java.util.Collection;
import java.util.Date;
import java.util.Random;
import java.io.File;


import dao.DbDao;

/**
 * Servlet implementation class AddproServlet
 */
@WebServlet("/Order_admin/AddproServlet")
@MultipartConfig(maxFileSize=1024*1024*5)//标识Servlet支持文件上传
public class AddproServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddproServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String errMsg = "";
        RequestDispatcher rd;
        
        String proname = request.getParameter("name");
        String pronum = request.getParameter("num");
        String proprice = request.getParameter("price");
        String prodes = request.getParameter("des");
        //String procat = request.getParameter("cat_id");
       // String proimgurl = request.getParameter("imgurl");
        String saveimgurl="";
       // System.out.println(proname+" "+proimgurl);
        try {
        	//存储路径物理路径
            String path = request.getServletContext().getRealPath("/images");
            //
            //String path = "D:\\project\\webtest\\WebContent\\images";
            //得到当前日期，每天一个以日期命名文件夹，方便管理
            String crtdate = format(new Date(), "yyyyMMdd");
            String dirc = path+File.separator+crtdate;
         // 创建目录
            File uploadDir = new File(dirc);
            	if (!uploadDir.exists()) {
            		uploadDir.mkdir();
            	}
            //}
            //获取上传的文件集合
             //Collection<Part> parts = request.getParts();
            //上传单个文件
           // if (parts.size()==1) {
                Part part = request.getPart("file");
                String header = part.getHeader("content-disposition");
                //获取文件名aaa.aa.bb.jpg
                String fileName = getNewName(getFileName(header));
                String imgurl = dirc+File.separator+fileName;
                saveimgurl = "images/"+crtdate+"/"+fileName;
                //把文件写到指定路径
                part.write(imgurl);
            //}
        	DbDao dd = new DbDao("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/shopping",
                    "root", "root");
        	ResultSet rs = dd.query("select * from menu where foodname = ?", proname);
        	if(rs.next()){
        		//已经存在，显示失败信息
        		 request.setAttribute("message", "商品已经存在 ");
        		 request.getRequestDispatcher("form_validation.html").forward(request, response);
        	}else{
        		String sql = "insert into menu (foodname,fooddiscript,foodimage,foodprice) values(?,?,?,?)";

        		Object[] args = {proname,prodes,saveimgurl,proprice};
        		dd.insert(sql, args);
        		//添加到数据库
        		rd = request.getRequestDispatcher("check_addPro.html");
                rd.forward(request, response);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        // 如果出错
        if(errMsg != null && !errMsg.equals("")){
        	request.setAttribute("err", errMsg);
            request.getRequestDispatcher("form_validation.html").forward(request, response);
       
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	/**
	 * 将日期类型变量按指定格式转换成字符串
	 * @param date 日期变量
	 * @param fmt 日期格式
	 * @return
	 */
	public static String format(Date date, String fmt){
		return new SimpleDateFormat(fmt).format(date);
	}
	private String getNewName(String filename){
		String newName = "";
		int lastPoint = filename.lastIndexOf(".");
		String extname = filename.substring(lastPoint);
		newName = System.currentTimeMillis()+extname;
		return newName;
	}
     /**
     * 根据请求头解析出文件名
     * 请求头的格式：火狐和google浏览器下：form-data; name="file"; filename="snmp4j--api.zip"
     *                 IE浏览器下：form-data; name="file"; filename="E:\snmp4j--api.zip"
     * @param header 请求头
     * @return 文件名
     */
    public String getFileName(String header) {
         /**
         * String[] tempArr1 = header.split(";");代码执行完之后，在不同的浏览器下，tempArr1数组里面的内容稍有区别
         * 火狐或者google浏览器下：tempArr1={form-data,name="file",filename="snmp4j--api.zip"}
         * IE浏览器下：tempArr1={form-data,name="file",filename="E:\snmp4j--api.zip"}
         */
        String[] tempArr1 = header.split(";");
         /**
          *火狐或者google浏览器下：tempArr2={filename,"snmp4j--api.zip"}
          *IE浏览器下：tempArr2={filename,"E:\snmp4j--api.zip"}
          */
         String[] tempArr2 = tempArr1[2].split("=");
        //获取文件名，兼容各种浏览器的写法
         String fileName = tempArr2[1].substring(tempArr2[1].lastIndexOf("\\")+1).replaceAll("\"", "");
         return fileName;
    }
}
