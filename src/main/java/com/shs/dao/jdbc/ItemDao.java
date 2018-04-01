package com.shs.dao.jdbc;

import com.shs.dao.supply.ChangeInstance;
import com.shs.entity.Item;
import com.shs.jdbc.JdbcConnect;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository("PushDefaultItem")
public class ItemDao implements ChangeInstance<Item> {


    private PreparedStatement createPreparedStatement(Item entity) throws SQLException {
        final String sql = "INSERT INTO ITEM "
                + "(PRICE,NAME,DESCRIPTION,ITEM_STATUS_ID,ITEM_TYPE_ID) VALUES "
                + "(?, ?, ?, ?, ?)";
        Connection connection = JdbcConnect.getInstance().connect();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setFloat(1, entity.getPrice());
        statement.setString(2, entity.getName());
        statement.setString(3, entity.getDescription());
        statement.setInt(4, entity.getItemStatus().getItemStatusId());
        statement.setInt(5, entity.getItemType().getItemTypeId());
        return statement;
    }

    private PreparedStatement updatePreparedStatement(Connection connection, Item entity) throws SQLException {
        final String sql = "UPDATE ITEM SET "
                + "PRICE = ? , NAME = ? , DESCRIPTION= ? , ITEM_STATUS_ID = ? "
                + "WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setFloat(1, entity.getPrice());
        statement.setString(2, entity.getName());
        statement.setString(3, entity.getDescription());
        statement.setInt(4, entity.getItemStatus().getItemStatusId());
        statement.setInt(5, entity.getItemId());
        return statement;
    }
    private PreparedStatement deletePreparedStatement(int id) throws SQLException {
        final String sql = "DELETE FROM ITEM "
                + "WHERE id = ?";
        Connection connection = JdbcConnect.getInstance().connect();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        return statement;
    }

    @Override
    public void create(Item entity) {
        try (PreparedStatement statement = createPreparedStatement(entity)) {
            statement.executeUpdate();
            try (ResultSet keys = statement.getGeneratedKeys()) {
                keys.next();
                entity.setItemId(keys.getInt(1));
            }
        } catch (SQLException exc) {
            throw new RuntimeException(
                    "JDBC error:" + exc.getMessage());
        }
    }

    @Override
    public void update(Item entity) {
        Connection connection = JdbcConnect.getInstance().connect();
        try (PreparedStatement statement = updatePreparedStatement(connection, entity)) {
            statement.executeUpdate();
        } catch (SQLException exc) {
            throw new RuntimeException(
                    "JDBC error:" + exc.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        if (id == 0) {
            return;
        }
        try (PreparedStatement statement = deletePreparedStatement(id)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

