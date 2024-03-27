package org.example.XpressBees.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.XpressBees.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class createOrder {
    String orderId;
    String pickupLocation;
    String channelId;
    String comment;
    List<OrderItem> orderItems;
    String paymentMethod;
    double shippingCharges;
    double giftwrapCharges;
    double transactionCharges;
    double totalDiscount;
    double subTotal;
    double length;
    double breadth;
    double height;
    double weight;
}
