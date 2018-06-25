package com.shs.dao.jpa.order;

import com.shs.dao.jpa.BaseJpaDao;
import com.shs.dao.order.OrderDao;
import com.shs.entity.items.Item;
import com.shs.entity.orders.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO that operates with customer orders.
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
@Repository
public class OrderJpaDao extends BaseJpaDao<Integer, Order> implements OrderDao {

    /**
     * Reading order attributes by Id (in developing).
     */
    @Override
    public Order readOrder(int orderId, Item item) {
        List orderIdList = getSession().createQuery("select i.itemId from Order o join o.items i where o.orderId = :orderId").setParameter("orderId", orderId).list();
        orderIdList.forEach(System.out::println);
        //Order order1 = getEntityManager().find(Order.class, orderId);
   /*     Session session = getSession();
        List ids = session.createQuery("SELECT o.OrderId FROM Order o").list();
        ids.forEach(System.out::println);
        Order order = session.load(Order.class, orderId);
        Item item1 = new Item(new ItemType(3, "dgdhfhdh"));
        item1.setItemId(1);
        item1.setName("test");
        item1.setPrice(18);
        item1.setItemStatus(new ItemStatus(1,"sgsgsdg"));
        order.getItems().add(item1);
        session.merge(order);
        session.flush();*/
    /*    Order order = getSessionFactory().openSession().load(Order.class, orderId);
        Item item1 = new Item(new ItemType(3, "dgdhfhdh"));
        //item1.setItemId(1);
        item1.setName("test");
        item1.setPrice(18);
        item1.setItemStatus(new ItemStatus(1,"sgsgsdg"));
        item1.setOrder(order);*/
    //    create(item1);
        return getSession().get(Order.class, orderId);
    }

    /**
     * Reading list of customer orders by Username
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Order> readUserOrders(String username) {
        return getSession().getNamedQuery(Order.ALL_ORDER_QUERY).setParameter("username", username).list();
    }
}
