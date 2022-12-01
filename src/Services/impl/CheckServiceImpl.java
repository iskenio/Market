package Services.impl;

import Exceptions.SqlException;
import Market.Check;
import Services.CheckService;
import dao.DbHelper;
import dao.impl.DbHelperImpl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;


public class CheckServiceImpl implements CheckService {
    DbHelper dbHelper = new DbHelperImpl();
    Scanner scanner = new Scanner(System.in);
    @Override
    public void save(int totalSum) {
        try (PreparedStatement preparedStatement = dbHelper.getStatement("INSERT INTO tb_checks(total_sum, add_date,active) VALUES (?,?,?)")){
            preparedStatement.setInt(1, totalSum);
            preparedStatement.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now()));
            preparedStatement.setBoolean(3, true);
            int insertCount = preparedStatement.executeUpdate();
            System.out.println("insertCount = " + insertCount);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(int totalSum, Long id) {
        try (PreparedStatement preparedStatement = dbHelper.getStatement("UPDATE tb_checks SET total_sum = ? WHERE id = ?")) {

            preparedStatement.setDouble(1, totalSum);
            preparedStatement.setLong(2, id);

            preparedStatement.executeUpdate();
        }catch (SQLException throwables) {
            throw new SqlException("Ошибка обновления данных по id в таблице Check");
        }
    }

    @Override
    public List<Check> findAll() throws SQLException {
        List<Check> checks = new ArrayList();
        try (PreparedStatement preparedStatement = dbHelper.getStatement("select * from tb_checks")){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Check check = new Check();
//                System.out.println(rs.getInt("id") + " | "+rs.getInt("total_sum")
//                        + " | "+rs.getBoolean("active") + " | "+rs.getDate("add_date"));
                check.setId(rs.getLong("id"));
                check.setTotalSum(rs.getInt("total_sum"));
                check.setAddDate(rs.getDate("add_date"));
                checks.add(check);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return checks;
    }


    @Override
    public Check findById(Long id) {
        Check check = new Check();
        try (PreparedStatement preparedStatement = dbHelper.getStatement("select * from tb_checks where id = ?")){
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                check.setId(rs.getLong("id"));
                check.setTotalSum(rs.getInt("total_sum"));

                check.setAddDate(rs.getDate("add_date"));

//                System.out.println(rs.getInt("id") + " | "+rs.getInt("total_sum")
//                        + " | "+rs.getBoolean("active") + " | "+rs.getDate("add_date"));
            }
        } catch (SQLException throwables){
            throw new SqlException("Ошибка при поиске по ID");
        }
        return check;
    }

    @Override
    public void delete(Long id) {
        try (PreparedStatement ps = dbHelper.getStatement("delete from tb_checks where id = ?")){
            ps.setLong(1, id);
            int delCount = ps.executeUpdate();
            System.out.println(delCount);
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }
}
