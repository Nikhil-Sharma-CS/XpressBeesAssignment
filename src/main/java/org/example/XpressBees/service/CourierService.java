package org.example.XpressBees.service;

import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CourierService {

    @Value("${app-token}")
    String token;

    public ResponseEntity<String> getCourierList() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");

        Request request = new Request.Builder()
                .url("https://apiv2.shiprocket.in/v1/external/courier/courierListWithCounts")
                .method("GET", null)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + token)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                // Handle unsuccessful response with an appropriate status code
                return ResponseEntity.status(response.code()).body("Error: " + response.message());
            }

            ResponseBody rbody = response.body();
            String responseString = rbody.string(); // Read the response body as a String

            // You can process the responseString further if needed (e.g., convert to objects)

            return ResponseEntity.ok(responseString);
        }
    }
}
