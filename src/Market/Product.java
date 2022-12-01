package Market;

import java.util.Date;

public class Product extends BaseEntity {
    private double price;
    private int discount;
    private Long categoriesId;

    public Product(Long id, String name, boolean active, Date addDate, double price, int discount, Long categoriesId) {
        super(id, name, active, addDate);
        this.price = price;
        this.discount = discount;
        this.categoriesId = categoriesId;
    }

    public Product() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Long getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(Long categoriesId) {
        this.categoriesId = categoriesId;
    }
    @Override
    public String toString() {
        return super.toString() +
                " |  price = " + price +
                " |  discount = " + discount +
                " | categoriesId = " + categoriesId;
    }
}
