package Services.impl;

import Exceptions.SqlException;
import Market.*;
import Services.CategoryServices;
import dao.DbHelper;
import dao.impl.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.util.*;


public class CategoryServicesImpl implements CategoryServices {
    DbHelper dbHelper = new DbHelperImpl();
    Scanner scanner=new Scanner(System.in);
    @Override
    public void save(String name) {
        try (PreparedStatement preparedStatement = dbHelper.getStatement("insert into tb_categories(name, active, adddate) values (?,?,?)")){
            preparedStatement.setString(1, name);
            preparedStatement.setBoolean(2, true);
            preparedStatement.setDate(3,java.sql.Date.valueOf(java.time.LocalDate.now()));
            preparedStatement.executeUpdate();
        } catch (SQLException throwables){
            throw new SqlException("Ошибка при сохранении таблицы категории");
        }
    }

    @Override
    public void update(Long id, String name) {
        try (PreparedStatement preparedStatement = dbHelper.getStatement("update tb_categories set name = ? where id = ?")){
            preparedStatement.setString(1, name);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables){
            throw new SqlException("Ошибка при изменении в таблице Категории");
        }
    }

    @Override
    public List<Categories> findAll() {
        List<Categories> categories = new ArrayList();
        try(PreparedStatement preparedStatement = dbHelper.getStatement("select * from tb_categories")){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Categories category = new Categories();
                category.setId(rs.getLong("id"));
                category.setName(rs.getString("name"));
                category.setActive(rs.getBoolean("active"));
                category.setAddDate(rs.getDate("adddate"));
//                System.out.println(rs.getInt("id") + " | "+rs.getString("name")+
//                        " | "+rs.getBoolean("active")+ " | "+rs.getDate("adddate"));
                categories.add(category);
            }
    }catch(SQLException throwables){
        }

        return categories;
    }

    @Override
    public Categories findById(Long id) {
        Categories category = new Categories();
        try (PreparedStatement preparedStatement = dbHelper.getStatement("select * from tb_categories where id = ?")){
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                category.setId(rs.getLong("id"));
                category.setName(rs.getString("name"));
                category.setActive(rs.getBoolean("active"));
                category.setAddDate(rs.getDate("adddate"));
//                System.out.println(rs.getInt("id") + " | "+rs.getString("name")+
//                        " | "+rs.getBoolean("active")+ " | "+rs.getDate("adddate"));
            }

        } catch (SQLException throwables){
            throw new SqlException("Ошибка при поиске по ID");
        }
        return category;
    }

    @Override
    public void delete(Long id) {
        try (PreparedStatement ps = dbHelper.getStatement("delete from tb_categories where id = ?")){
            ps.setLong(1, id);
//            ResultSet rs = ps.executeQuery();
            int delCount = ps.executeUpdate();
            System.out.println(delCount);
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Override
    public void create() {
        System.out.println("Напишите название категорию ");
        Categories category =new Categories();
        category.setName(scanner.nextLine());
        save(category.getName());
    }
}
