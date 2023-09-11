package vlas.entity;

public class ForUser {
   private String name;
   private String prodName;
   private int price;
    public ForUser(){}

    public ForUser(String name, String prodName, int price) {
        this.name = name;
        this.prodName = prodName;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ForUser{" +
                "name='" + name + '\'' +
                ", prodName='" + prodName + '\'' +
                ", price=" + price +
                '}';
    }
}
