package servlet;

import service.*;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/ProServlet")
public class ProServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
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
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();

        //接收从页面传来的操作类型
        String type = request.getParameter("type");

        //定义CartService
        CartService cart = null ;
        //创建session
        HttpSession session = request.getSession();
        //从Session当中取购物车，查看此购物车是否存在
        if(null == session.getAttribute("cart")){
            cart = new CartService();
            cart.init();
        }else{
            cart = (CartService)session.getAttribute("cart");
        }
        //将商品加入购物车
        if("add".equals(type)){
            String  ids = request.getParameter("ids");
            //开始封装商品项
            String [] temp = ids.split(",");
            for(String id : temp){
                //id值即为商品编号,查询出商品
                if(null==id||"".equals(id)){
                    continue;
                }else{
                    Product product =   service.getProductById(Integer.parseInt(id));
                    Items item  = new Items();
                    item.setProduct(product);
                    item.setNum(1);
                    cart.add(item);
                }
            }
            //商品已经加入到购物车,将原有的购物车替换掉
            session.setAttribute("cart", cart);
            //向浏览器返回后台操作
            out.print("ok");
        }
        //显示商品列表
        else if(null==type){
            List<Product> products = service.getProducts();
            request.setAttribute("products", products);
            request.getRequestDispatcher("menu.jsp").forward(request, response);
        }
        //删除单个商品
        else if("delete".equals(type)){
            int id = Integer.parseInt(request.getParameter("id"));
            boolean result = cart.removePro(id);
            if(result){
                out.print("ok");
            }
        }
        //清空购物车
        else if("clear".equals(type)){
            boolean result = cart.clear();
//          if(result==true){
//              out.print("\t\t\t\t\t\t\t已清空购物车"+"\t\t");
//          }
            request.getRequestDispatcher("services.jsp").forward(request, response);
        }
        //将购物车中商品数量加1
        else if("addOne".equals(type)){
            int id = Integer.parseInt(request.getParameter("id"));
            Product product =   service.getProductById(id);
            Items item  = new Items();
            item.setProduct(product);
            boolean  result = cart.addOne(item);
            if(result){
                out.print("ok");
            }
        }
        //将购物车中商品数量减1，如果该商品只有一个的话就将该商品从购物车中删除
        else if("subOne".equals(type)){
            int id = Integer.parseInt(request.getParameter("id"));
            Product product =   service.getProductById(id);
            Items item  = new Items();
            item.setProduct(product);
            boolean result = cart.subOne(item);
            if(result){
                out.print("ok");
            }
        }
        out.flush();
        out.close();
    }
}