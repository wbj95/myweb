package service;


import java.util.HashMap;
import java.util.Map;

public class CartService {
    private Map<Integer,Items> map;
    public void init(){
        map = new HashMap<Integer, Items>();
    }
    public Map<Integer, Items> getMap() {
        return map;
    }
    public void setMap(Map<Integer, Items> map) {
        this.map = map;
    }
    /**
     * 将商品放入购物车
     * @param item
     * @return
     */
    public boolean add(Items item){
        if(map.containsKey(item.getProduct().getId())){//代表包含了此商品，则在数量上加一
            Items temp = map.get(item.getProduct().getId());
            temp.setNum(temp.getNum()+1);
            map.put(temp.getProduct().getId(), temp);
        }else{
            map.put(item.getProduct().getId(), item);//代表商品第一次加入购物车
        }
        return true;
    }
    /**
     * 清空购物车
     * @return
     */
    public boolean clear(){
        map.clear();
        return true;
    }
    /**
     * 指定删除某个商品
     * @param id
     * @return
     */
    public boolean removePro(int id ){
        map.remove(id);
        return true;
    }

    /**
     * 商品加1
     * @return
     */
    public boolean addOne(Items item){
        Items temp = map.get(item.getProduct().getId());
        temp.setNum(temp.getNum()+1);
        map.put(temp.getProduct().getId(), temp);
        return true;
    }

    /**
     * 商品减1
     * @return
     */
    public boolean subOne(Items item){
        if(item.getNum()==1){
            removePro(item.getProduct().getId());
        }else{
            Items temp = map.get(item.getProduct().getId());
            temp.setNum(temp.getNum()-1);
            map.put(temp.getProduct().getId(), temp);
        }
        return true;
    }

    @Override
    public String toString() {
        String result="";
        for (Map.Entry<Integer, Items > entry : map.entrySet()) {
            result=result+"Key = " + entry.getKey() + ", Value = " + entry.getValue()+"\n";
        }
        return result;
    }
}