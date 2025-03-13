package _00_fundamentals.Array_List._03_order_Management_System;

import java.util.Objects;

public class Order {
    private int orderID;
    private String customerName;
    private double totalAmount;
    private OrderStatus status;


    public Order(int orderID, String customerName, double totalAmount, OrderStatus status) {
        this.orderID = orderID;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void displayDetails() {
        System.out.println("Order ID: " + orderID);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Total Amount: " + totalAmount);
        System.out.println("Status: " + status.getStatus());

    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", customerName='" + customerName + '\'' +
                ", totalAmount=" + totalAmount +
                ", status=" + status.getStatus() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderID == order.orderID && Double.compare(totalAmount, order.totalAmount) == 0 && Objects.equals(customerName, order.customerName) && status == order.status;
    }



    @Override
    public int hashCode() {
        return Objects.hash(orderID, customerName, totalAmount, status);
    }




}
