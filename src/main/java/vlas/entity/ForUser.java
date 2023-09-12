package vlas.entity;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForUser forUser = (ForUser) o;
        return Objects.equals(name, forUser.name) && Objects.equals(prodName, forUser.prodName) && Objects.equals(price, forUser.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, prodName, price);
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
