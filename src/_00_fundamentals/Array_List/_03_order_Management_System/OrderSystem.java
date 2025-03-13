package _00_fundamentals.Array_List._03_order_Management_System;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderSystem {

    List<Order> orderList = new ArrayList<>();

    public boolean addOrder(Order order) {
        if (order != null) {
            orderList.add(order);
            return true;
        }
        return false;

    }

    public Order findOrderByOrderID(int orderID) {
        for (Order order : orderList) {
            if (order.getOrderID() == orderID) {
                return order;
            }
        }


        return null;
    }

    public boolean updateOrderStatus(int orderID, String status) {
        Order order = findOrderByOrderID(orderID);
        if (order != null) {
            try {
                order.setStatus(OrderStatus.valueOf(status.toUpperCase()));

                return true;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid status! Use: PENDING, SHIPPED, DELIVERED, CANCELED.");
            }


        }
        return false;


    }

    public boolean removeOrderStatus(int orderID) {

      /*  Iterator<Order> iterator = orderList.iterator();
        while (iterator.hasNext()) {
            Order item = iterator.next();
            if (item.getOrderID() == orderID && item.getStatus() == OrderStatus.CANCELED) {
                iterator.remove();
                return true;
            }
        }

       */



        Order order2 = new Order(12, "David", 3000, OrderStatus.CANCELED);
        Order order=findOrderByOrderID(orderID);
        for(Order item:orderList){
            if(item.equals(order2) && item.getStatus()==OrderStatus.CANCELED){
                orderList.remove(item);
                return true;
            }
        }




        return false;
    }


}
