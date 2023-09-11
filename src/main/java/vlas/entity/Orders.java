package vlas.entity;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Objects;


public class Orders implements Serializable {
    private int orderId;
    private int userId;
    private int productId;
    private int isOrdered;
    private String purchaseDate;

    private Orders(){}
    public Orders(int orderId, int userId, int productId, int isOrdered, String purchaseDate) {
        this.orderId = orderId;
        this.userId = userId;
        this.productId = productId;
        this.isOrdered = isOrdered;
        this.purchaseDate = purchaseDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getIsOrdered() {
        return isOrdered;
    }

    public void setIsOrdered(int isOrdered) {
        this.isOrdered = isOrdered;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", productId=" + productId +
                ", isOrdered=" + isOrdered +
                ", purchaseDate='" + purchaseDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return orderId == orders.orderId && userId == orders.userId && productId == orders.productId && isOrdered == orders.isOrdered && Objects.equals(purchaseDate, orders.purchaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, userId, productId, isOrdered, purchaseDate);
    }
}

