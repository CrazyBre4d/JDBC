package vlas.entity;

import java.util.Objects;

public class ProductType {
    private Long typeId;
    private String typeName;
    public ProductType(){}
    public ProductType(Long typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }
    public ProductType( String typeName) {
        this.typeName = typeName;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductType that = (ProductType) o;
        return Objects.equals(typeId, that.typeId) && Objects.equals(typeName, that.typeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeId, typeName);
    }
}
