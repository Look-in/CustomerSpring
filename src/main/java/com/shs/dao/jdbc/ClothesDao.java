package com.shs.dao.jdbc;

import com.shs.dao.supply.ChangeInstance;
import com.shs.entity.Clothes;
import com.shs.jdbc.JdbcConnect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository("PushClothes")
public class ClothesDao implements ChangeInstance<Clothes> {

    @Autowired
    @Qualifier("PushDefaultItem")
    private ChangeInstance changeDefaultInstance;

    private PreparedStatement createPreparedStatement(Clothes entity) throws SQLException {
        final String sql = "INSERT INTO CLOTHES "
                + "(ID,SEASON) VALUES "
                + "(?, ?)";
        Connection connection = JdbcConnect.getInstance().connect();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, entity.getItemId());
        statement.setString(2, entity.getSeason());
        return statement;
    }

    private PreparedStatement updatePreparedStatement(Clothes entity) throws SQLException {
        final String sql = "UPDATE CLOTHES SET "
                + "SEASON = ? "
                + "WHERE id = ?";
        Connection connection = JdbcConnect.getInstance().connect();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, entity.getSeason());
        statement.setInt(2, entity.getItemId());
        return statement;
    }


    @Override
    public void create(Clothes entity) {
        //Заполняет базовую таблицу товара.
        changeDefaultInstance.create(entity);
        try (PreparedStatement statement = createPreparedStatement(entity)) {
            //Заполняет таблицу свойств Clothes
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Clothes entity) {
        try (PreparedStatement statement = updatePreparedStatement(entity)) {
            changeDefaultInstance.update(entity);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private PreparedStatement deletePreparedStatement(int id) throws SQLException {
        final String sql = "DELETE FROM CLOTHES "
                + "WHERE id = ?";
        Connection connection = JdbcConnect.getInstance().connect();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        return statement;
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
