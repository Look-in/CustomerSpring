package com.shs.dao.jdbc;

import com.shs.dao.reference.ItemTypeDao;
import com.shs.entity.ItemType;
import com.shs.jdbc.JdbcConnect;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemTypeDaoImpl implements ItemTypeDao {

    @Override
    public List<ItemType> readItemTypes() {
        final String sql = "SELECT ID,ITEM_TYPE " +
                "FROM ITEM_TYPE;";
        List<ItemType> type = new ArrayList<>();
        Connection connection = JdbcConnect.getInstance().connect();
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                type.add(new ItemType(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException exc) {
            throw new RuntimeException(
                    "Error reading DB:" + exc.getMessage());
        }
        return type;
    }

    private static PreparedStatement selectPreparedStatement(int id) throws SQLException {
        final String SQL = "SELECT " +
                "ITEM_TYPE " +
                "FROM ITEM_TYPE WHERE id= ?;";
        Connection connection = JdbcConnect.getInstance().connect();
        PreparedStatement statement = connection.prepareStatement(SQL);
        statement.setInt(1, id);
        return statement;
    }

    @Override
    public ItemType readItemType(int itemTypeId) {
        ItemType type=null;
        try (PreparedStatement statement = selectPreparedStatement(itemTypeId);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                type=new ItemType(itemTypeId,rs.getString(1));
            }
        } catch (SQLException exc) {
            throw new RuntimeException(
                    "Error reading ItemStatuses:" + exc.getMessage());
        }
        return type;
    }

}