package Services;

import Market.Check;
import Market.MarketCategories;

import java.sql.SQLException;
import java.util.List;


public interface CheckService {
    void save(int totalSum);
    void update(int totalSum, Long id);
    List<Check> findAll() throws SQLException;
    Check findById(Long id);
    void delete(Long id);
}
