package Services.impl;

import Exceptions.SqlException;
import Market.Categories;
import Market.*;
import Services.ProductServices;
import dao.DbHelper;
import dao.impl.DbHelperImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.util.*;

public class ProductServicesImpl implements ProductServices {
    DbHelper dbHelper = new DbHelperImpl();
    Scanner scanner = new Scanner(System.in);
    @Override
    public void save(Product product) {
        try (PreparedStatement preparedStatement = dbHelper.getStatement("insert into tb_product (name, active, add_date, price, discount, categories_id) values (?,?,?,?,?,?)")){

            preparedStatement.setString(1, product.getName());
            preparedStatement.setBoolean(2, true);
            preparedStatement.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setInt(5, product.getDiscount());
            preparedStatement.setLong(6, product.getCategoriesId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
//            throw new SqlException("Ошибка при заполнении таблицы Продукты");
        }
    }

    @Override
    public void update(Long id, double price) {
        try(PreparedStatement preparedStatement = dbHelper.getStatement("update tb_product set price=? where id=?")) {
            preparedStatement.setDouble(1, price);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList();
        try (PreparedStatement preparedStatement = dbHelper.getStatement("select * from tb_product")){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Product product = new Product();
                product.setId(rs.getLong("id"));
                product.setName(rs.getString("name"));
                product.setActive(rs.getBoolean("active"));
                product.setAddDate(rs.getDate("add_date"));
                product.setPrice(rs.getDouble("price"));
                product.setDiscount(rs.getInt("discount"));
                product.setCategoriesId(rs.getLong("categories_id"));
                products.add(product);
                //System.out.println(rs.getString("id") + " | " + rs.getString("name") + " | " +
                  //              " | " +rs.getBoolean("active") + " | " + rs.getDate("add_date") + " | "+
                    //    rs.getDouble("price") + " | " + rs.getInt("discount") + " | " + rs.getLong("categories_id"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    @Override
    public Product findById(Long id) {
        Product product = new Product();
        try (PreparedStatement preparedStatement = dbHelper.getStatement("select * from tb_product where id = ?")){
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                product.setId(rs.getLong("id"));
                product.setName(rs.getString("name"));
                product.setActive(rs.getBoolean("active"));
                product.setAddDate(rs.getDate("add_date"));
                product.setPrice(rs.getDouble("price"));
                product.setDiscount(rs.getInt("discount"));
                product.setCategoriesId(rs.getLong("categories_id"));
//                System.out.println(rs.getString("id") + " | " + rs.getString("name") + " | " +
//                        rs.getBoolean("active") + " | " + rs.getDate("add_date") + " | "+
//                        rs.getDouble("price") + " | " + rs.getInt("discount") + " | " + rs.getLong("categories_id"));
            }
        } catch (SQLException throwables){
            throw new SqlException("Ошибка при поиске по ID");
        }
        return product;
    }

    @Override
    public void delete(Long id) {
        try (PreparedStatement ps = dbHelper.getStatement("delete from tb_product where id = ?")){
            ps.setLong(1, id);
            int rs = ps.executeUpdate();
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Override
    public void create() {
        Product product = new Product();
        System.out.println("Напишите название продукта ");
        scanner.nextLine();
        product.setName(scanner.nextLine());
        System.out.println("Напишите цену ");
        product.setPrice(scanner.nextDouble());
        System.out.println("Напишите скидку ");
        product.setDiscount(scanner.nextInt());
        System.out.println("Напишите ID категории товара ");
        product.setCategoriesId(scanner.nextLong());
        save(product);
    }
}
