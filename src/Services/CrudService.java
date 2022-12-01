package Services;

import java.sql.SQLException;

public interface CrudService {
    void getShopControl();
    void getCategoryControl();
    void getProductControl();
    void getUserControl();
    void getCheckControl() throws SQLException;
    void getCheckProductControl() throws SQLException;
    void getMarketCategoryControl() throws SQLException;
}
