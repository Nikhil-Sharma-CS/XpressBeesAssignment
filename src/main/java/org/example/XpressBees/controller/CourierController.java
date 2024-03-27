package org.example.XpressBees.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.XpressBees.model.Order;
import org.example.XpressBees.service.CourierService;
import org.example.XpressBees.service.XpressBeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
@RequestMapping("/api/couriers")
public class CourierController {

    @Autowired
    CourierService courierService;
    private static final Logger logger = Logger.getLogger(XpressBeesService.class.getName());
    @Autowired
    XpressBeesService xpressBeesService;

    //Get list of all couriers
    @GetMapping("/all")
    public ResponseEntity<String> getCourierList() throws IOException {
            return courierService.getCourierList();
    }

    //Track Order
    @GetMapping("/track-order-via-orderId")
    public ResponseEntity<String> trackOrder(@RequestParam String orderId,@RequestParam String channelId) throws IOException {
        return xpressBeesService.trackOrder(orderId, channelId);
    }

    @GetMapping("/track-order-via-awb")
        public ResponseEntity<String> trackByAwb(@RequestParam String awbNumber) throws IOException
    {
        return xpressBeesService.trackByAwb(awbNumber);
    }

    @GetMapping("/get-all-shipment-details")
    //Get all shipment details
    public ResponseEntity<String> getShipmentDetails(@RequestParam String shipmentId) throws IOException
    {
        return xpressBeesService.getShipmentDetails(shipmentId);
    }

    @PostMapping("/create-order")
    public ResponseEntity<String> createXpressBeesOrder(@RequestBody Order order) throws IOException {

        return xpressBeesService.createXpressBeesOrder(order);
    }
}




