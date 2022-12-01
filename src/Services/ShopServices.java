package Services;

import Market.Market;

import java.util.List;

public interface ShopServices {
    void save(String name);
    void update(String name, Long id);
    List<Market> findAll();
    Market findById(Long id);
    void delete(Long id);

    void create();

}

