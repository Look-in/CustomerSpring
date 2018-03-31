package com.shs.dao;


import com.shs.entity.Bicycle;
import com.shs.jdbc.JdbcConnect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service("ReadBicycle")
public class ReadBicycleDao implements ReadItem<Bicycle> {

    @Autowired
    @Qualifier("ReadDefaultItem")
    private ReadByItem readItem;

    private PreparedStatement selectPreparedStatement(int id) throws SQLException {
        final String sql = "SELECT " +
                "FORK, BRAKES, FRAME" +
                " FROM BICYCLE " +
                "WHERE ID=?;";
        Connection connection = JdbcConnect.getInstance().connect();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        return statement;
    }

    @Override
    public Bicycle readItem(int itemId) {
        //Заполнить базовые свойства
        Bicycle bicycle= new Bicycle();
        bicycle.setItemId(itemId);
        readItem.readItem(bicycle);
        try (PreparedStatement statement = selectPreparedStatement(itemId);
             ResultSet rs = statement.executeQuery();) {
            while (rs.next()) {
                bicycle.setFork(rs.getString(1));
                bicycle.setBrakes(rs.getString(2));
                bicycle.setFrame(rs.getString(3));
            }
        } catch (Exception exc) {
            throw new RuntimeException(
                    "Error reading DB:" + exc.getMessage());
        }
        return bicycle;
    }
}
