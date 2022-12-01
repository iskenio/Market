package Services;

import Market.*;
import java.util.List;


public interface UsersServices {
    void save(String name, String login, String password, Long marketId);
    void update(String name, Long id);
    List<Users> findAll();
    Users findById(Long id);
    void delete(Long id);
    void create();
}
