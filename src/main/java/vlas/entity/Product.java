package vlas.entity;

import java.util.Objects;

public class Product {
    private Long productId;
    private String productName;
    private int productPrice;
    private String productDescription;
    private Long typeId;

    public Product(){}

    public Product(Long productId, String productName, int productPrice, String productDescription, Long typeId) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.typeId = typeId;
    }
    public Product( String productName, int productPrice, String productDescription, Long typeId) {

        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.typeId = typeId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productDescription='" + productDescription + '\'' +
                ", typeId=" + typeId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productPrice == product.productPrice && Objects.equals(productId, product.productId) && Objects.equals(productName, product.productName) && Objects.equals(productDescription, product.productDescription) && Objects.equals(typeId, product.typeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, productPrice, productDescription, typeId);
    }
}
