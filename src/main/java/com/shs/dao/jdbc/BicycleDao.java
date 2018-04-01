package com.shs.dao.jdbc;

import com.shs.dao.supply.ChangeInstance;
import com.shs.entity.Bicycle;
import com.shs.jdbc.JdbcConnect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository("PushBicycle")
public class BicycleDao implements ChangeInstance<Bicycle> {

    @Autowired
    @Qualifier("PushDefaultItem")
    private ChangeInstance changeDefaultInstance;

    private PreparedStatement createPreparedStatement(Bicycle entity) throws SQLException {
        final String sql = "INSERT INTO BICYCLE "
                + "(ID, FORK, BRAKES, FRAME) VALUES "
                + "(?, ?, ?, ?)";
        Connection connection = JdbcConnect.getInstance().connect();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, entity.getItemId());
        statement.setString(2, entity.getFork());
        statement.setString(3, entity.getBrakes());
        statement.setString(4, entity.getFrame());
        return statement;
    }

    private PreparedStatement updatePreparedStatement(Bicycle entity) throws SQLException {
        final String sql = "UPDATE BICYCLE SET "
                + "FORK = ?, BRAKES=?, FRAME=? "
                + "WHERE id = ?";
        Connection connection = JdbcConnect.getInstance().connect();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, entity.getFork());
        statement.setString(2, entity.getBrakes());
        statement.setString(3, entity.getFrame());
        statement.setInt(4, entity.getItemId());
        return statement;
    }


    @Override
    public void create(Bicycle entity) {
        /*Try с ресурсами закрывает коннект после заверш обработки запроса
        На каждый запрос свой коннект, что замедляет работу, но на тестовом проекте это некритично*/
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
    public void update(Bicycle entity) {
        try (PreparedStatement statement = updatePreparedStatement(entity)) {
            changeDefaultInstance.update(entity);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private PreparedStatement deletePreparedStatement(int id) throws SQLException {
        final String sql = "DELETE FROM BICYCLE "
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
