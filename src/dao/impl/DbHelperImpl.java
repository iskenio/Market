package dao.impl;

import Exceptions.SqlException;
import dao.DbHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbHelperImpl implements DbHelper {
    @Override
    public PreparedStatement getStatement(String sql) throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Market", "postgres", "root");{
            return cn.prepareStatement(sql);
        }
    }}
