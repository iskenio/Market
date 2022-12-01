package Services.impl;

import Exceptions.SqlException;
import Market.Market;
import Market.MarketCategories;
import Services.MarketCategoryService;
import dao.DbHelper;
import dao.impl.DbHelperImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarketCategoryServiceImpl implements MarketCategoryService {
    DbHelper dbHelper = new DbHelperImpl();
    @Override
    public void save(Long marketId, Long categoryId) {
        try (PreparedStatement preparedStatement = dbHelper.getStatement
                ("insert into tb_shop_categories(market_id,category_id)values(?,?)")) {
            preparedStatement.setLong(1, marketId);
            //preparedStatement.setBoolean(2,marketCategories.isActive());
            preparedStatement.setLong(2, categoryId);
//            preparedStatement.setString(3, String.valueOf(marketCategories.getMarketTbId()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Long id, Long categoryId) {
        try (PreparedStatement preparedStatement = dbHelper.getStatement
                ("update tb_shop_categories set category_id = ? where id = ?")) {
            //preparedStatement.setBoolean(2,updateShopCategories.isActive());
            preparedStatement.setLong(1, categoryId);
            preparedStatement.setLong(2, id);
            //preparedStatement.setString(3, String.valueOf(updateShopCategories.getCategoriesTbId()));
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throw new SqlException("Произошлда ошибка при сохранении обьекта в магазин к БД");
        }
    }

    @Override
    public List<MarketCategories> findAll() throws SQLException {
        List<MarketCategories> shopCategories = new ArrayList<>();
        try (PreparedStatement preparedStatement = dbHelper.getStatement("select * from tb_shop_categories")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                MarketCategories shops = new MarketCategories();
                shops.setId(resultSet.getLong("id"));
                shops.setMarketTbId(resultSet.getLong("market_id"));
                shops.setCategoriesTbId(resultSet.getLong("category_id"));
                shopCategories.add(shops);
                //preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
           e.printStackTrace();
        }
        return shopCategories;
    }

    @Override
    public MarketCategories findById(Long id) {
        MarketCategories shops = new MarketCategories();
        try (PreparedStatement preparedStatement = dbHelper.getStatement("SELECT * FROM tb_shop_categories WHERE id = ?")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                shops.setId(resultSet.getLong("id"));
                shops.setMarketTbId(resultSet.getLong("market_id"));
                shops.setCategoriesTbId(resultSet.getLong("category_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shops;
    }

    @Override
    public void delete(Long id) {
        try (PreparedStatement preparedStatement = dbHelper.getStatement("DELETE FROM tb_shop_categories WHERE id=?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throw new SqlException("Произошла ошибка при удалении обьекта из БД");
        }
    }
}
