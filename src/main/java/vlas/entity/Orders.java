package vlas.entity;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Objects;


public class Orders implements Serializable {
    private Long orderId;
    private Long userId;
    private Long productId;
    private int isOrdered;
    private Date purchaseDate;

    private Orders(){}
    public Orders(Long orderId, Long userId, Long productId, int isOrdered, Date purchaseDate) {
        this.orderId = orderId;
        this.userId = userId;
        this.productId = productId;
        this.isOrdered = isOrdered;
        this.purchaseDate = purchaseDate;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getIsOrdered() {
        return isOrdered;
    }

    public void setIsOrdered(int isOrdered) {
        this.isOrdered = isOrdered;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
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
        return isOrdered == orders.isOrdered && Objects.equals(orderId, orders.orderId) && Objects.equals(userId, orders.userId) && Objects.equals(productId, orders.productId) && Objects.equals(purchaseDate, orders.purchaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, userId, productId, isOrdered, purchaseDate);
    }
}

