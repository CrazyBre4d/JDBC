package vlas.entity;

public class ProductType {
    private int type_id;
    private String type_name;

    public ProductType(int type_id, String type_name) {
        this.type_id = type_id;
        this.type_name = type_name;
    }

    public int getTypeId() {
        return type_id;
    }

    public void setTypeId(int type_id) {
        this.type_id = type_id;
    }

    public String getTypeName() {
        return type_name;
    }

    public void setTypeName(String type_name) {
        this.type_name = type_name;
    }

    @Override
    public String toString() {
        return "Product_type{" +
                "type_id=" + type_id +
                ", type_name='" + type_name + '\'' +
                '}';
    }
}
