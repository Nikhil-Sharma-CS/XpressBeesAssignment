package org.example.XpressBees.service;

import com.google.gson.Gson;
import okhttp3.*;
import org.example.XpressBees.model.Order;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class XpressBeesService {

    private static final Logger logger = Logger.getLogger(XpressBeesService.class.getName());
    ObjectMapper mapper = new ObjectMapper();
    public static final String BASE_URL = "https://apiv2.shiprocket.in/v1/external/";
    private final OkHttpClient client;


    @Value("${app-token}")
    String token; //The token is stored in the properties file

    public XpressBeesService() {
        this.client = new OkHttpClient().newBuilder().build();
    }
    private final Gson gson = new Gson();

    //---------------------------------------------------------------------------------------------------------------------
    public ResponseEntity<String> createXpressBeesOrder(Order order) throws IOException {

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        String json =  mapper.writeValueAsString(order);

        RequestBody body = RequestBody.create(mediaType, json);

        Request request = new Request.Builder()
                .url(BASE_URL + "orders/create/adhoc")
                .method("POST", body)
                .addHeader("Content-Type", "application/json; charset=utf-8")
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




