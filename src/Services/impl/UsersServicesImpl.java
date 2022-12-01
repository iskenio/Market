package Services.impl;

import Exceptions.SqlException;
import Market.Users;
import Services.UsersServices;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.*;

import dao.*;
import dao.impl.DbHelperImpl;


public class UsersServicesImpl implements UsersServices {
    DbHelper dbHelper = new DbHelperImpl();
    Scanner scanner = new Scanner(System.in);
    @Override
    public void save(String name, String login, String password, Long marketId) {
        try(PreparedStatement preparedStatement = dbHelper.getStatement("insert into tb_users (name, active, adddate, login, password, marketId) values (?,?,?,?,?,?)")) {
            preparedStatement.setString(1, name);
            preparedStatement.setBoolean(2, true);
            preparedStatement.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
            preparedStatement.setString(4, login);
            preparedStatement.setString(5, password);
            preparedStatement.setLong(6, marketId);
            int insertCount = preparedStatement.executeUpdate();
            System.out.println("insertCount = " + insertCount);
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void update(String name, Long id) {
        try (PreparedStatement preparedStatement = dbHelper.getStatement("update tb_users set name = ? where id = ?")){
            preparedStatement.setString(1, name);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Users> findAll() {
        List<Users> users= new ArrayList();
        try (PreparedStatement preparedStatement = dbHelper.getStatement("select * from tb_users")){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
//                System.out.println(rs.getInt("id") + " | "+rs.getString("name") +" | " +
//                        rs.getString("login") + " | " + rs.getString("password") + " | "
//                        + rs.getLong("marketId") + " | "+rs.getBoolean("active") + " | " + rs.getDate("adddate"));
            Users user = new Users();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
            user.setMarketId(rs.getLong("marketId"));
            user.setActive(rs.getBoolean("active"));
            user.setAddDate(rs.getDate("adddate"));
            users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    @Override
    public Users findById(Long id) {
        Users user = new Users();
        try (PreparedStatement preparedStatement = dbHelper.getStatement("select * from tb_users where id = ?")){
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setMarketId(rs.getLong("marketId"));
                user.setActive(rs.getBoolean("active"));
                user.setAddDate(rs.getDate("adddate"));
//                System.out.println(rs.getInt("id") + " | "+rs.getString("name") +" | " +
//                        rs.getString("login") + " | " + rs.getString("password") + " | "
//                        + rs.getLong("marketId") + " | "+rs.getBoolean("active") + " | " + rs.getDate("adddate"));
            }
        } catch (SQLException throwables){
            throw new SqlException("Ошибка при поиске по ID");
        }
        return user;
    }

    @Override
    public void delete(Long id) {
        try (PreparedStatement ps = dbHelper.getStatement("delete from tb_users where id = ?")){
            ps.setLong(1, id);
            int delCount = ps.executeUpdate();
            System.out.println(delCount);
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    public void create(){
        Users user = new Users();
        System.out.println("Введите имя пользователя: ");
        user.setName(scanner.nextLine());
        System.out.println("Введите login пользователя: ");
        user.setLogin(scanner.nextLine());
        System.out.println("Введите password пользователя: ");
        user.setPassword(scanner.nextLine());
        System.out.println("Введите ID магазина: ");
        user.setMarketId(scanner.nextLong());
        save(user.getName(), user.getLogin(), user.getPassword(), user.getMarketId());
    }
}
