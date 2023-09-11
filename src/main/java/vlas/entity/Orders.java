package vlas.entity;

import java.io.Serializable;
import java.security.SecureRandom;


public class Orders implements Serializable {
    private int orderId;
    private int userId;
    private int productId;
    private int isOrdered;
    private String purchaseDate;

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
}

