package service;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.io.*;
public class Items implements  Serializable{
    private static final long serialVersionUID = 1L;
    private Product product;
    private int num;
    public Items() {
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Items{" +
                "product=" + product +
                ", num=" + num +
                '}';
    }
}
