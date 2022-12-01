package Services;

import Market.MarketCategories;

import java.sql.SQLException;
import java.util.List;

public interface MarketCategoryService {
    void save(Long marketId, Long categoryId);
    void update(Long id, Long categoryId);
    List<MarketCategories> findAll() throws SQLException;
    MarketCategories findById(Long id);
    void delete(Long id);
}
