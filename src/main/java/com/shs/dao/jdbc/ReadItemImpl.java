package com.shs.dao.jdbc;

import com.shs.dao.reference.ItemStatusDao;
import com.shs.dao.reference.ItemTypeDao;
import com.shs.dao.supply.ReadByItem;
import com.shs.dao.supply.ReadItem;
import com.shs.dao.supply.ReadListItems;
import com.shs.entity.Item;
import com.shs.jdbc.JdbcConnect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("ReadDefaultItem")
public class ReadItemImpl implements ReadItem, ReadListItems, ReadByItem {

    @Autowired
    private ItemTypeDao itemTypeDao;

    @Autowired
    private ItemStatusDao itemStatusDao;

    private static PreparedStatement selectAllPreparedStatement(int id) throws SQLException {
        final String SQL = "SELECT " +
                "ID,PRICE,NAME,DESCRIPTION,ITEM_STATUS_ID, ITEM_TYPE_ID " +
                "FROM ITEM WHERE ITEM_TYPE_ID=?;";
        Connection connection = JdbcConnect.getInstance().connect();
        PreparedStatement statement = connection.prepareStatement(SQL);
        statement.setInt(1, id);
        return statement;
    }

    @Override
    public List<Item> readListItem(int typeItem) {
        List<Item> items = new ArrayList<>();
        if (typeItem == 0) {
            readAllListItem(items);
        } else {
            try (PreparedStatement statement = selectAllPreparedStatement(typeItem);
                 ResultSet rs = statement.executeQuery()) {
                Item item;
                while (rs.next()) {
                    item = new Item();
                    setItemParameter(rs, item);
                    items.add(item);
                }
            } catch (Exception exc) {
                throw new RuntimeException(exc);
            }
        }
        return items;
    }

    private void setItemParameter(ResultSet rs, Item item) throws SQLException {
        item.setItemId(rs.getInt(1));
        item.setPrice(rs.getInt(2));
        item.setName(rs.getString(3));
        item.setDescription(rs.getString(4));
        item.setItemStatus(itemStatusDao.readItemStatus(rs.getInt(5)));
        item.setItemType(itemTypeDao.readItemType(rs.getInt(6)));
        //Преобразуем Blob в строку формата base 64
                            /*Blob ph = rs.getBlob(7);
                            tmpItem.setImage(ph.getBytes(1, (int) ph.length()));*/
    }

    private void readAllListItem(List<Item> items) {
        Connection connection = JdbcConnect.getInstance().connect();
        final String SQL = "SELECT " +
                "ID,PRICE,NAME,DESCRIPTION, ITEM_STATUS_ID,ITEM_TYPE_ID " +
                "FROM ITEM;";
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(SQL)) {
            Item item;
            while (rs.next()) {
                item = new Item();
                setItemParameter(rs, item);
                items.add(item);
            }
        } catch (SQLException exc) {
            throw new RuntimeException(exc);
        }
    }

    private PreparedStatement selectPreparedStatement(int id) throws SQLException {
        final String SQL = "SELECT " +
                "ID, PRICE, NAME, DESCRIPTION, ITEM_STATUS_ID, ITEM_TYPE_ID " +
                "FROM ITEM WHERE ITEM.ID=?;";
        Connection connection = JdbcConnect.getInstance().connect();
        PreparedStatement statement = connection.prepareStatement(SQL);
        statement.setInt(1, id);
        return statement;
    }

    @Override
    public void readItem(Item item) {
        try (PreparedStatement statement = selectPreparedStatement(item.getItemId());
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                setItemParameter(rs, item);
            }
        } catch (Exception exc) {
            throw new RuntimeException(
                    "Error reading DB:" + exc.getMessage());
        }
    }

    @Override
    public Item readItem(int itemId) {
        Item item=new Item();
        item.setItemId(itemId);
        readItem(item);
        return item;
    }
}