package vlas.entity;

import java.io.Serializable;
import java.security.SecureRandom;

//БЛЯ ПАМАГИТЕ НИХУЯ НЕ ПОНЯЛ
public class Orders implements Serializable {
    private int order_id;
    private int user_id;
    private int product_id;
    private int is_ordered;
    private String purchase_date;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getIs_ordered() {
        return is_ordered;
    }

    public void setIs_ordered(int is_ordered) {
        this.is_ordered = is_ordered;
    }

    public String getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(String purchase_date) {
        this.purchase_date = purchase_date;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "order_id=" + order_id +
                ", user_id=" + user_id +
                ", product_id=" + product_id +
                ", is_ordered=" + is_ordered +
                ", purchase_date='" + purchase_date + '\'' +
                '}';
    }
}
