package org.example.XpressBees.service;

import com.google.gson.Gson;
import okhttp3.*;
import org.example.XpressBees.model.Customer;
import org.example.XpressBees.model.OrderItem;
import org.example.XpressBees.model.dto.CreateOrder;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class XpressBeesService {

    public static final String BASE_URL = "https://apiv2.shiprocket.in/v1/external/";
    private final OkHttpClient client;

    private Customer customer;

    @Value("${app-token}")
    String token; //The token is stored in the properties file

    public XpressBeesService() {
        this.client = new OkHttpClient().newBuilder().build();
    }
    private final Gson gson = new Gson();

    //---------------------------------------------------------------------------------------------------------------------
    public ResponseEntity<String> createXpressBeesOrder(CreateOrder createOrder) throws IOException {

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");

        String json = createXpressBeesOrderJson(createOrder.getOrderId(), createOrder.getPickupLocation(),createOrder.getChannelId(), createOrder.getComment(),  createOrder.getOrderItems(), createOrder.getPaymentMethod(),createOrder.getShippingCharges(), createOrder.getGiftwrapCharges(),createOrder.getTransactionCharges(), createOrder.getTotalDiscount(), createOrder.getSubTotal(), createOrder.getLength(), createOrder.getBreadth(), createOrder.getHeight(), createOrder.getWeight(), createOrder);

        RequestBody body = RequestBody.create(mediaType, json);

        Request request = new Request.Builder()
                .url(BASE_URL + "orders/create/adhoc")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + token)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                return ResponseEntity.status(response.code()).body("Error: " + response.message());
            }

            ResponseBody rbody = response.body();
            assert rbody != null;
            String responseString = rbody.string();

            return ResponseEntity.ok(responseString);
        }
    }
    private String createXpressBeesOrderJson(String orderId,
                                             String pickupLocation, String channelId,
                                             String comment, List<OrderItem> orderItems, String paymentMethod,
                                             double shippingCharges, double giftwrapCharges,
                                             double transactionCharges, double totalDiscount,
                                             double subTotal, double length, double breadth,
                                             double height, double weight, CreateOrder createOrder) {
        Map<String, Object> orderData = new HashMap<>();
        List<Map<String, Object>> orderItemsList = new ArrayList<>();
        // Order details
        orderData.put("order_id", orderId);
        orderData.put("order_date", formatDate(new Date()));

        // Pickup location
        orderData.put("pickup_location", pickupLocation);

        // Optional channel ID
        if (channelId != null && !channelId.isEmpty()) {
            orderData.put("channel_id", channelId);
        }

        // Optional comment
        if (comment != null && !comment.isEmpty()) {
            orderData.put("comment", comment);
        }

        // Billing information
        orderData.put("billing_customer_name", createOrder.getCustomer().getName());
        orderData.put("billing_address", createOrder.getCustomer().getAddress());
        if (createOrder.getCustomer().getAddress2() != null && !createOrder.getCustomer().getAddress2().isEmpty()) {
            orderData.put("billing_address_2", createOrder.getCustomer().getAddress2());
        }
        orderData.put("billing_city", createOrder.getCustomer().getCity());
        orderData.put("billing_pincode", createOrder.getCustomer().getPincode());
        orderData.put("billing_state", createOrder.getCustomer().getState());
        orderData.put("billing_country", createOrder.getCustomer().getCountry());
        orderData.put("billing_email", createOrder.getCustomer().getEmail());
        orderData.put("billing_phone", createOrder.getCustomer().getPhone());

        // Shipping information (set to billing by default)
        orderData.put("shipping_is_billing", true);
        for (OrderItem item : orderItems) {
            Map<String, Object> itemMap = getItemMap(item);
            orderItemsList.add(itemMap);
        }
        orderData.put("order_items", orderItemsList);

        // Order specifics
        orderData.put("payment_method", paymentMethod);
        orderData.put("shipping_charges", shippingCharges);
        orderData.put("giftwrap_charges", giftwrapCharges);
        orderData.put("transaction_charges", transactionCharges);
        orderData.put("total_discount", totalDiscount);
        orderData.put("sub_total", subTotal);

        // Package dimensions
        orderData.put("length", length);
        orderData.put("breadth", breadth);
        orderData.put("height", height);

        // Package weight
        orderData.put("weight", weight);

        // Convert the map to JSON
        return gson.toJson(orderData);
    }

    @NotNull
    private static Map<String, Object> getItemMap(OrderItem item) {
        Map<String, Object> itemMap = new HashMap<>();
        itemMap.put("name", item.getName());
        itemMap.put("sku", item.getSku());
        itemMap.put("units", item.getUnits());
        itemMap.put("selling_price", item.getSellingPrice());
        if (item.getDiscount() != null && !item.getDiscount().isEmpty()) {
            itemMap.put("discount", item.getDiscount());
        }
        if (item.getTax() != null && !item.getTax().isEmpty()) {
            itemMap.put("tax", item.getTax());
        }
        itemMap.put("hsn", item.getHsn());
        return itemMap;
    }

    // Helper method to format date
    private String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
    //---------------------------------------------------------------------------------------------------------------------

    //Track Order via Order Id
    public ResponseEntity<String> trackOrder(String orderId, String channelId) throws IOException {
        MediaType mediaType = MediaType.parse("text/plain"); // No request body needed for GET

        Request request = new Request.Builder()
                .url(BASE_URL+ "courier/track?order_id=" + orderId + "&channel_id=" + channelId)
                .method("GET", null)
                .addHeader("Authorization", "Bearer " + token)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                // Handle unsuccessful response with an appropriate status code
                return ResponseEntity.status(response.code()).body("Error: " + response.message());
            }

            ResponseBody rbody = response.body();
            String responseString = rbody.string(); // Read the response body as a String

            return ResponseEntity.ok(responseString);
        }
    }


    //Track Order via AWB
    public ResponseEntity<String> trackByAwb(String awbNumber) throws IOException {
        MediaType mediaType = MediaType.parse("application/json"); // Might not be required by the API, check documentation

        Request request = new Request.Builder()
                .url(BASE_URL + "courier/track/awb/" + awbNumber)
                .method("GET", null)
                .addHeader("Content-Type", "application/json") // Potentially optional depending on Shiprocket API
                .addHeader("Authorization", "Bearer " + token)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                // Handle unsuccessful response with an appropriate status code
                return ResponseEntity.status(response.code()).body("Error: " + response.message());
            }

            ResponseBody rbody = response.body();
            String responseString = rbody.string(); // Read the response body as a String

            return ResponseEntity.ok(responseString);
        }
    }

    //Get all shipment details
    public ResponseEntity<String> getShipmentDetails(String shipmentId) throws IOException {
        MediaType mediaType = MediaType.parse("application/json"); // Might not be required by the API, check documentation

        Request request = new Request.Builder()
                .url(BASE_URL + "shipments/" + shipmentId)
                .method("GET", null)
                .addHeader("Content-Type", "application/json") // Potentially optional depending on Shiprocket API
                .addHeader("Authorization", "Bearer " + token)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                // Handle unsuccessful response with an appropriate status code
                return ResponseEntity.status(response.code()).body("Error: " + response.message());
            }

            ResponseBody rbody = response.body();
            String responseString = rbody.string(); // Read the response body as a String

            return ResponseEntity.ok(responseString);
        }
    }
}




