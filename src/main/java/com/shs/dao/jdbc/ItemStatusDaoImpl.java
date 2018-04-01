package com.shs.dao.jdbc;

import com.shs.dao.reference.ItemStatusDao;
import com.shs.entity.ItemStatus;
import com.shs.jdbc.JdbcConnect;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemStatusDaoImpl implements ItemStatusDao {

    public List<ItemStatus> readItemStatuses() {
        final String SQL = "SELECT " +
                "ID,STATUS " +
                "FROM ITEM_STATUS order by id;";
        List<ItemStatus> status = new ArrayList<>();
        Connection connection = JdbcConnect.getInstance().connect();
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(SQL)) {
            while (rs.next()) {
                status.add(new ItemStatus(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException exc) {
            throw new RuntimeException(
                    "Error reading ItemStatuses:" + exc.getMessage());
        }
        return status;
    }

    private static PreparedStatement selectStatusStatement(int id) throws SQLException {
        final String SQL = "SELECT " +
                "STATUS " +
                "FROM ITEM_STATUS WHERE id= ?;";
        Connection connection = JdbcConnect.getInstance().connect();
        PreparedStatement statement = connection.prepareStatement(SQL);
        statement.setInt(1, id);
        return statement;
    }

    public ItemStatus readItemStatus(int itemStatusId) {
        ItemStatus status=null;
        try (PreparedStatement statement = selectStatusStatement(itemStatusId);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                status=new ItemStatus(itemStatusId,rs.getString(1));
            }
        } catch (SQLException exc) {
            throw new RuntimeException(
                    "Error reading ItemStatuses:" + exc.getMessage());
        }
        return status;
    }

}
