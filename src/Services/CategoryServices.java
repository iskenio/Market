package Services;

import Market.*;

import java.util.Date;
import java.util.List;

public interface CategoryServices {
    void save(String name);
    void update(Long id, String name);
    List<Categories> findAll();
    Categories findById(Long id);
    void delete(Long id);
    void create();
}
