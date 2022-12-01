package Services;

import Market.CheckProduct;

import java.sql.SQLException;
import java.util.List;

public interface CheckProductService {
    void save(long idChecks, long idProduct, int count);
    void update(Long id, int count);
    List<CheckProduct> findAll() throws SQLException;
    CheckProduct findById(Long id);
    void delete(Long id);
}
