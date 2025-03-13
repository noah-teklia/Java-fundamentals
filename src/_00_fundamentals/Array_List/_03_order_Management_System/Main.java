package _00_fundamentals.Array_List._03_order_Management_System;

import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        OrderSystem orderSystem = new OrderSystem();
        Order order1 = new Order(11, "Noah", 2000, OrderStatus.PENDING);
        Order order2 = new Order(12, "David", 3000, OrderStatus.CANCELED);
        Order order3 = new Order(13, "Sara", 5000, OrderStatus.PENDING);

        List<Order> orderList = List.of(order1, order2, order3);
        System.out.println("********************************CREATE*****************************************");
        for (Order item : orderList) {
            if (orderSystem.addOrder(item)) {
                System.out.println( "Order is added successfully");
            } else {
                System.out.println("Something went wrong.Please try again");
            }
        }

        System.out.println();
        System.out.println("********************************SELECT*****************************************");
        try {
            System.out.print("Enter  Order ID: ");
            int orderID = scanner.nextInt();
            scanner.nextLine();


            Order searchOrderD = orderSystem.findOrderByOrderID(orderID);
            if (searchOrderD != null) {
                searchOrderD.displayDetails();




            } else {
                System.out.println("Order not found");
            }

        } catch (Exception e) {
            System.out.println("Something went wrong with the order");
        }


        System.out.println();
        System.out.println("********************************UPDATE*****************************************");
        boolean isUpdated = orderSystem.updateOrderStatus(order1.getOrderID(), "Delivered");

        if (isUpdated) {
            System.out.println("Order updated successfully");
            order1.displayDetails();



        } else {
            System.out.println("Something went wrong with the order");
        }
      //  scanner.nextLine();


        System.out.println();
        System.out.println("********************************DELETE*****************************************");
        System.out.println("Orders count: "+ orderSystem.orderList.size());
        boolean isRemoved = orderSystem.removeOrderStatus(12);
        //boolean isRemoved = orderSystem.removeOrderStatus(15);
        System.out.println("Orders count: "+ orderSystem.orderList.size());
        if (isRemoved) {

            System.out.println("Order removed successfully");
                       // System.out.println("Orders count: "+ orderSystem.orderList.size());


        } else {
            System.out.println("Something went wrong with removing orders");

        }


    }
}
