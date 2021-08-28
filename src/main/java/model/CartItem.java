package model;

import java.io.Serializable;

public class CartItem implements Serializable{
    private String productname;
    private int quantity;
    private int unitprice;
    private int total;

    public CartItem() {

    }

    public CartItem(String productname, int quantity, int unitprice, int total) {
        this.productname = productname;
        this.quantity = quantity;
        this.unitprice = unitprice;
        this.total = total;
    }

    public String getProductname() {
        return this.productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUnitprice() {
        return this.unitprice;
    }

    public void setUnitprice(int unitprice) {
        this.unitprice = unitprice;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
