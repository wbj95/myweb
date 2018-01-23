package dao;
import java.sql.*;
import java.util.*;
import service.Product;
import service.DBUtil;
public class ProductDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    /**
     * 查询所有商品信息
     * @return
     */
    public List<Product> getProducts(){
        conn  = DBUtil.getConnection();
        String sql = "select * from Menu ";
        List<Product> products = new ArrayList<Product>();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Product product = new Product();
                product.setId(rs.getInt("FoodID"));
                product.setName(rs.getString("FoodName"));
                product.setPrice(rs.getDouble("FoodPrice"));

                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBUtil.closeAll(rs, ps, conn);
        }
        return products;
    }
    /**
     * 根据商品编号查找单个商品信息
     * @param id
     * @return
     */
    public Product getProductById(int id){
        Product pro = new Product();
        conn = DBUtil.getConnection();
        String sql = "select * from Menu where FoodID = ? ";
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                pro.setId(rs.getInt("FoodID"));
                pro.setName(rs.getString("FoodName"));
                pro.setPrice(rs.getDouble("FoodPrice"));

            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            DBUtil.closeAll(rs, ps, conn);
        }
        return pro;
    }

}
