package vlas.entity;

import java.util.Objects;

public class ForUser {
   private String login;
   private String name;
   private String prodName;
   private String prodDesc;
   private Long price;
   private int isOrdered;
    public ForUser(){}


    public ForUser(String login, String name, String prodName, String prodDesc, Long price, int isOrdered) {
        this.login = login;
        this.name = name;
        this.prodName = prodName;
        this.prodDesc = prodDesc;
        this.price = price;
        this.isOrdered = isOrdered;
    }

    public int getIsOrdered() {
        return isOrdered;
    }

    public void setIsOrdered(int isOrdered) {
        this.isOrdered = isOrdered;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
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
        return Objects.equals(login, forUser.login) && Objects.equals(name, forUser.name) && Objects.equals(prodName,
                forUser.prodName) && Objects.equals(prodDesc, forUser.prodDesc) && Objects.equals(price, forUser.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, name, prodName, prodDesc, price);
    }

    @Override
    public String
    toString() {
        return "ForUser{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", prodName='" + prodName + '\'' +
                ", prodDesc='" + prodDesc + '\'' +
                ", price=" + price +
                '}';
    }
}
