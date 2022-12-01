package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public interface DbHelper {
    PreparedStatement getStatement(String sql) throws SQLException;
}
