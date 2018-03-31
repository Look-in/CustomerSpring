package com.shs.dao;


import com.shs.entity.Clothes;
import com.shs.jdbc.JdbcConnect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service("ReadClothes")
public class ReadClothesDao implements ReadItem<Clothes> {

    @Autowired
    @Qualifier("ReadDefaultItem")
    private ReadByItem readItem;

    private PreparedStatement selectPreparedStatement(int id) throws SQLException {
        final String sql = "SELECT " +
                "SEASON" +
                " FROM CLOTHES " +
                "WHERE ID=?;";
        Connection connection = JdbcConnect.getInstance().connect();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        return statement;
    }

    @Override
    public Clothes readItem(int itemId) {
        //Заполнить базовые свойства
        Clothes clothes=new Clothes();
        clothes.setItemId(itemId);
        readItem.readItem(clothes);
        //Заполнить св-ва Clothes
        try (PreparedStatement statement = selectPreparedStatement(itemId);
             ResultSet rs = statement.executeQuery();) {
            while (rs.next()) {
                clothes.setSeason(rs.getString(1));
            }
        } catch (Exception exc) {
            throw new RuntimeException(
                    "Error reading DB:" + exc.getMessage());
        }
        return clothes;
    }
}
