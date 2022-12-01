package Services.impl;

import Exceptions.SqlException;
import Market.Market;
import Market.Product;

import Services.ShopServices;
import dao.DbHelper;
import dao.impl.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.sql.*;

public class MarketServImpl implements ShopServices {
    DbHelper dbHelper = new DbHelperImpl();
    Scanner scanner=new Scanner(System.in);
    List<Market> markets = null;

    @Override
    public void save(String name) {
        try (PreparedStatement preparedStatement = dbHelper.getStatement("insert into tb_market(name, active, varchar) values (?, ?, ?)")){
            preparedStatement.setString(1, name);
            preparedStatement.setBoolean(2, true);
            preparedStatement.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throw new SqlException("Ошибка при сохранении объекта Магазин");
        }
    }



    @Override
    public void update(String name, Long id) {
        try (PreparedStatement preparedStatement = dbHelper.getStatement("update tb_market set name=? where id=?")){
            preparedStatement.setString(1, name);
            preparedStatement.setLong(2, id);
            int updateCount = preparedStatement.executeUpdate();
            System.out.println("update count = " + updateCount);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Market> findAll() {

        try (PreparedStatement preparedStatement = dbHelper.getStatement("select * from tb_market")) {
            ResultSet rs = preparedStatement.executeQuery();
            markets = new ArrayList();
            while (rs.next()) {
                Market market = new Market();
                market.setId(rs.getLong("id"));
                market.setName(rs.getString("name"));
                market.setActive(rs.getBoolean("active"));
                market.setAddDate(rs.getDate("varchar"));
                markets.add(market);
                //System.out.println(rs.getInt("id") + " | "+rs.getString("name") +" | "+rs.getBoolean("active") + " | "+rs.getString("varchar"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return markets;
    }

    @Override
    public Market findById(Long id) {
        Market market = new Market();
        try (PreparedStatement preparedStatement = dbHelper.getStatement("select * from tb_market where id = ?")){
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                //System.out.println(rs.getInt("id") + " | "+rs.getString("name")+" | "+rs.getBoolean("active") + " | "+rs.getString("varchar"));

                market.setId(rs.getLong("id"));
                market.setName(rs.getString("name"));
                market.setActive(rs.getBoolean("active"));
                market.setAddDate(rs.getDate("varchar"));

            }
        } catch (SQLException throwables){
            throw new SqlException("Ошибка при поиске по ID");
        }
        return market;
    }

    @Override
    public void delete(Long id) {
        try (PreparedStatement ps = dbHelper.getStatement("delete from tb_market where id = ?")){
            ps.setLong(1, id);
//            ResultSet rs = ps.executeUpdate();
            int delCount = ps.executeUpdate();
            System.out.println(delCount);
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }

    }

    @Override
    public void create() {
        System.out.println("Напишите название магазина ");
        Market shop=new Market();
        shop.setName(scanner.next());
        save(shop.getName());
    }
}
