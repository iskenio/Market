package Services.impl;

import Exceptions.SqlException;
import Market.CheckProduct;
import Services.CheckProductService;
import dao.DbHelper;
import dao.impl.DbHelperImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CheckProductServiceImpl implements CheckProductService {
    DbHelper dbHelper = new DbHelperImpl();
    Scanner scanner = new Scanner(System.in);
    @Override
    public void save(long idChecks, long idProduct, int count) {
        try (PreparedStatement preparedStatement = dbHelper.getStatement("insert into tb_checks_product (check_id, product_id, count) values (?,?,?)")){

            preparedStatement.setLong(1, idChecks);
//            preparedStatement.setString(2, new Date().toString());
//            preparedStatement.setString(3, String.valueOf(true));
            preparedStatement.setLong(2, idProduct);
            preparedStatement.setInt(3, count);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
//            throw new SqlException("Ошибка при заполнении таблицы Продукты");
        }
    }

    @Override
    public void update(Long id, int count) {
        try (PreparedStatement preparedStatement = dbHelper.getStatement("update tb_checks_product set count = ? where id = ?")){
            preparedStatement.setInt(1, count);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables){
            throw new SqlException("Ошибка при изменении в таблице Категории");
        }
    }

    @Override
    public List<CheckProduct> findAll() throws SQLException {
        try(PreparedStatement preparedStatement = dbHelper.getStatement("select * from tb_checks_product")){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                System.out.println(rs.getInt("id") + " | "+rs.getInt("check_id")
                + " | " + rs.getInt("product_id") + " | " + rs.getInt("count"));
            }
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public CheckProduct findById(Long id) {
        try (PreparedStatement preparedStatement = dbHelper.getStatement("select * from tb_checks_product where id = ?")){
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                System.out.println(rs.getInt("id") + " | "+rs.getInt("check_id")
                        + " | " + rs.getInt("product_id") + " | " + rs.getInt("count"));
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        try (PreparedStatement ps = dbHelper.getStatement("delete from tb_checks_product where id = ?")){
            ps.setLong(1, id);
//            ResultSet rs = ps.executeQuery();
            int delCount = ps.executeUpdate();
            System.out.println(delCount);
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }
}
