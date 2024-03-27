package org.example.XpressBees.controller;

import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import org.example.XpressBees.model.Order;
import org.example.XpressBees.service.CourierService;
import org.example.XpressBees.service.XpressBeesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {CourierController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class CourierControllerTest {
    @Autowired
    private CourierController courierController;

    @MockBean
    private CourierService courierService;

    @MockBean
    private XpressBeesService xpressBeesService;

    /**
     * Method under test: {@link CourierController#getCourierList()}
     */
    @Test
    void testGetCourierList() throws Exception {
        // Arrange
        when(courierService.getCourierList()).thenReturn(null);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/couriers/all");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(courierController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link CourierController#trackOrder(String, String)}
     */
    @Test
    void testTrackOrder() throws Exception {
        // Arrange
        when(xpressBeesService.trackOrder(Mockito.<String>any(), Mockito.<String>any())).thenReturn(null);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/couriers/track-order-via-orderId")
                .param("channelId", "foo")
                .param("orderId", "foo");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(courierController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link CourierController#trackByAwb(String)}
     */
    @Test
    void testTrackByAwb() throws Exception {
        // Arrange
        when(xpressBeesService.trackByAwb(Mockito.<String>any())).thenReturn(null);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/couriers/track-order-via-awb")
                .param("awbNumber", "foo");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(courierController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link CourierController#getShipmentDetails(String)}
     */
    @Test
    void testGetShipmentDetails() throws Exception {
        // Arrange
        when(xpressBeesService.getShipmentDetails(Mockito.<String>any())).thenReturn(null);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/couriers/get-all-shipment-details")
                .param("shipmentId", "foo");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(courierController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link CourierController#createXpressBeesOrder(Order)}
     */
    @Test
    void testCreateXpressBeesOrder() throws Exception {
        // Arrange
        when(xpressBeesService.createXpressBeesOrder(Mockito.<Order>any())).thenReturn(null);

        Order order = new Order();
        order.setBilling_address("42 Main St");
        order.setBilling_address_2("42 Main St");
        order.setBilling_alternate_phone(1);
        order.setBilling_city("Billing city");
        order.setBilling_country("GB");
        order.setBilling_customer_name("Billing customer name");
        order.setBilling_email("jane.doe@example.org");
        order.setBilling_isd_code("Billing isd code");
        order.setBilling_last_name("Doe");
        order.setBilling_phone(1);
        order.setBilling_pincode(1);
        order.setBilling_state("Billing state");
        order.setBreadth(10.0f);
        order.setChannel_id(1);
        order.setCheckout_shipping_method("Checkout shipping method");
        order.setComment("Comment");
        order.setCompany_name("Company name");
        order.setCustomer_gstin("Customer gstin");
        order.setEwaybill_no("Ewaybill no");
        order.setGiftwrap_charges(1);
        order.setHeight(10.0f);
        order.setInvoice_number("42");
        order.setLength(10.0f);
        order.setOrder_date("2020-03-01");
        order.setOrder_id("Order id");
        order.setOrder_items(new ArrayList<>());
        order.setOrder_type("Order type");
        order.setPayment_method("Payment method");
        order.setPickup_location("Pickup location");
        order.setReseller_name("Reseller name");
        order.setShipping_address("42 Main St");
        order.setShipping_address_2("42 Main St");
        order.setShipping_charges(1);
        order.setShipping_city("Shipping city");
        order.setShipping_country("GB");
        order.setShipping_customer_name("Shipping customer name");
        order.setShipping_email("jane.doe@example.org");
        order.setShipping_is_billing(true);
        order.setShipping_last_name("Doe");
        order.setShipping_phone(1);
        order.setShipping_pincode(1);
        order.setShipping_state("Shipping state");
        order.setSub_total(1);
        order.setTotal_discount(3);
        order.setTransaction_charges(1);
        order.setWeight(10.0f);
        order.setWhat3words_address("42 Main St");
        order.set_insurance_opt(true);
        String content = (new ObjectMapper()).writeValueAsString(order);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/couriers/create-order")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(courierController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
