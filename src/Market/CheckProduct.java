package Market;

public class CheckProduct {
    private Long id;
    private Check checkId;
    private Product productId;
    private int count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Check getCheckId() {
        return checkId;
    }

    public void setCheckId(Check checkId) {
        this.checkId = checkId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
