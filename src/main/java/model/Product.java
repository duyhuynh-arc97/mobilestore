package model;

public class Product {
    private int id;
    private String name;
    private int unitprice;
    private int instock;
    private String desc;
    private int manufacturer_id;
    private int category_id;
    private int condition_id;
    private String image;

    public Product(int id, String n, int p, int s, String d, int m, int c, int cd, String i) {
        this.id=id;
        this.name=n;
        this.unitprice=p;
        this.instock=s;
        this.desc=d;
        this.manufacturer_id=m;
        this.category_id=c;
        this.condition_id=cd;
        this.image=i;
    }
    public Product(){

    }

    public int getId(){
        return this.id;
    }
    public void setId(int a){
        this.id=a;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String a){
        this.name=a;
    }
    public int getUnitprice(){
        return this.unitprice;
    }
    public void setUnitprice(int a){
        this.unitprice=a;
    }
    public int getInstock(){
        return this.instock;
    }
    public void setInstock(int a){
        this.instock=a;
    }
    public String getDesc(){
        return this.desc;
    }
    public void setDesc(String a){
        this.desc=a;
    }
    public int getManu_id(){
        return this.manufacturer_id;
    }
    public void setManu_id(int a){
        this.manufacturer_id=a;
    }
    public int getCtg_id(){
        return this.category_id;
    }
    public void setCtg_id(int a){
        this.category_id=a;
    }
    public int getCdt_id(){
        return this.condition_id;
    }
    public void setCdt_id(int a){
        this.condition_id=a;
    }
    public String getImage(){
        return this.image;
    }
    public void setImage(String a){
        this.image=a;
    }
}
