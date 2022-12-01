package Services;

import Market.*;
import Market.Users;

import java.util.List;

public interface ProductServices {
    void save(Product product);
    void update(Long id, double price);
    List<Product> findAll();
    Product findById(Long id);
    void delete(Long id);
    void create();
}
