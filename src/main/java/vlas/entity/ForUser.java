package vlas.entity;

public class ForUser {
   private String name;
   private String prodName;
   private Long price;
    public ForUser(){}

    public ForUser(String name, String prodName, Long price) {
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
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
