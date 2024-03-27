package org.example.XpressBees.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;

import org.example.XpressBees.model.Customer;
import org.example.XpressBees.model.OrderItem;
import org.example.XpressBees.model.dto.CreateOrder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {XpressBeesService.class})
@ExtendWith(SpringExtension.class)
class XpressBeesServiceTest {
    @Autowired
    private XpressBeesService xpressBeesService;

    /**
     * Method under test:
     * {@link XpressBeesService#createXpressBeesOrder(CreateOrder)}
     */
    @Test
    void testCreateXpressBeesOrder() throws IOException {
        try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
            // Arrange
            mockInetAddress.when(() -> InetAddress.getAllByName(Mockito.<String>any()))
                    .thenThrow(new IllegalStateException("U/U"));
            Customer customer = mock(Customer.class);
            when(customer.getAddress()).thenReturn("42 Main St");
            when(customer.getAddress2()).thenReturn("42 Main St");
            when(customer.getCity()).thenReturn("Oxford");
            when(customer.getCountry()).thenReturn("GB");
            when(customer.getEmail()).thenReturn("jane.doe@example.org");
            when(customer.getName()).thenReturn("Name");
            when(customer.getPhone()).thenReturn("6625550144");
            when(customer.getPincode()).thenReturn("Pincode");
            when(customer.getState()).thenReturn("MD");
            ArrayList<OrderItem> orderItems = new ArrayList<>();

            CreateOrder createOrder = new CreateOrder("", "U/U", "42", "U/U", orderItems, "U/U", 10.0d, 10.0d, 10.0d, 10.0d,
                    10.0d, 10.0d, 10.0d, 10.0d, 10.0d, new Customer("U/U", "42 Main St", "42 Main St", "Oxford", "U/U", "MD",
                    "GB", "jane.doe@example.org", "6625550144"));
            createOrder.setCustomer(customer);

            // Act and Assert
            assertThrows(IllegalStateException.class, () -> xpressBeesService.createXpressBeesOrder(createOrder));
            mockInetAddress.verify(() -> InetAddress.getAllByName(Mockito.<String>any()));
            verify(customer).getAddress();
            verify(customer, atLeast(1)).getAddress2();
            verify(customer).getCity();
            verify(customer).getCountry();
            verify(customer).getEmail();
            verify(customer).getName();
            verify(customer).getPhone();
            verify(customer).getPincode();
            verify(customer).getState();
        }
    }

    /**
     * Method under test:
     * {@link XpressBeesService#createXpressBeesOrder(CreateOrder)}
     */
    @Test
    void testCreateXpressBeesOrder2() throws IOException {
        try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
            // Arrange
            mockInetAddress.when(() -> InetAddress.getAllByName(Mockito.<String>any()))
                    .thenThrow(new IllegalStateException("U/U"));
            Customer customer = mock(Customer.class);
            when(customer.getAddress()).thenReturn("42 Main St");
            when(customer.getAddress2()).thenReturn("42 Main St");
            when(customer.getCity()).thenReturn("Oxford");
            when(customer.getCountry()).thenReturn("GB");
            when(customer.getEmail()).thenReturn("jane.doe@example.org");
            when(customer.getName()).thenReturn("Name");
            when(customer.getPhone()).thenReturn("6625550144");
            when(customer.getPincode()).thenReturn("Pincode");
            when(customer.getState()).thenReturn("MD");
            ArrayList<OrderItem> orderItems = new ArrayList<>();

            CreateOrder createOrder = new CreateOrder("42", "U/U", "", "U/U", orderItems, "U/U", 10.0d, 10.0d, 10.0d, 10.0d,
                    10.0d, 10.0d, 10.0d, 10.0d, 10.0d, new Customer("U/U", "42 Main St", "42 Main St", "Oxford", "U/U", "MD",
                    "GB", "jane.doe@example.org", "6625550144"));
            createOrder.setCustomer(customer);

            // Act and Assert
            assertThrows(IllegalStateException.class, () -> xpressBeesService.createXpressBeesOrder(createOrder));
            mockInetAddress.verify(() -> InetAddress.getAllByName(Mockito.<String>any()));
            verify(customer).getAddress();
            verify(customer, atLeast(1)).getAddress2();
            verify(customer).getCity();
            verify(customer).getCountry();
            verify(customer).getEmail();
            verify(customer).getName();
            verify(customer).getPhone();
            verify(customer).getPincode();
            verify(customer).getState();
        }
    }

    /**
     * Method under test:
     * {@link XpressBeesService#createXpressBeesOrder(CreateOrder)}
     */
    @Test
    void testCreateXpressBeesOrder3() throws IOException {
        try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
            // Arrange
            mockInetAddress.when(() -> InetAddress.getAllByName(Mockito.<String>any()))
                    .thenThrow(new IllegalStateException("U/U"));
            Customer customer = mock(Customer.class);
            when(customer.getAddress()).thenReturn("42 Main St");
            when(customer.getAddress2()).thenReturn("42 Main St");
            when(customer.getCity()).thenReturn("Oxford");
            when(customer.getCountry()).thenReturn("GB");
            when(customer.getEmail()).thenReturn("jane.doe@example.org");
            when(customer.getName()).thenReturn("Name");
            when(customer.getPhone()).thenReturn("6625550144");
            when(customer.getPincode()).thenReturn("Pincode");
            when(customer.getState()).thenReturn("MD");
            ArrayList<OrderItem> orderItems = new ArrayList<>();

            CreateOrder createOrder = new CreateOrder("42", "U/U", "42", "", orderItems, "U/U", 10.0d, 10.0d, 10.0d, 10.0d,
                    10.0d, 10.0d, 10.0d, 10.0d, 10.0d, new Customer("U/U", "42 Main St", "42 Main St", "Oxford", "U/U", "MD",
                    "GB", "jane.doe@example.org", "6625550144"));
            createOrder.setCustomer(customer);

            // Act and Assert
            assertThrows(IllegalStateException.class, () -> xpressBeesService.createXpressBeesOrder(createOrder));
            mockInetAddress.verify(() -> InetAddress.getAllByName(Mockito.<String>any()));
            verify(customer).getAddress();
            verify(customer, atLeast(1)).getAddress2();
            verify(customer).getCity();
            verify(customer).getCountry();
            verify(customer).getEmail();
            verify(customer).getName();
            verify(customer).getPhone();
            verify(customer).getPincode();
            verify(customer).getState();
        }
    }

    /**
     * Method under test:
     * {@link XpressBeesService#createXpressBeesOrder(CreateOrder)}
     */
    @Test
    void testCreateXpressBeesOrder4() throws IOException {
        try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
            // Arrange
            mockInetAddress.when(() -> InetAddress.getAllByName(Mockito.<String>any()))
                    .thenThrow(new IllegalStateException("U/U"));
            Customer customer = mock(Customer.class);
            when(customer.getAddress()).thenReturn("42 Main St");
            when(customer.getAddress2()).thenReturn("");
            when(customer.getCity()).thenReturn("Oxford");
            when(customer.getCountry()).thenReturn("GB");
            when(customer.getEmail()).thenReturn("jane.doe@example.org");
            when(customer.getName()).thenReturn("Name");
            when(customer.getPhone()).thenReturn("6625550144");
            when(customer.getPincode()).thenReturn("Pincode");
            when(customer.getState()).thenReturn("MD");
            ArrayList<OrderItem> orderItems = new ArrayList<>();

            CreateOrder createOrder = new CreateOrder("42", "U/U", "42", "U/U", orderItems, "U/U", 10.0d, 10.0d, 10.0d, 10.0d,
                    10.0d, 10.0d, 10.0d, 10.0d, 10.0d, new Customer("U/U", "42 Main St", "42 Main St", "Oxford", "U/U", "MD",
                    "GB", "jane.doe@example.org", "6625550144"));
            createOrder.setCustomer(customer);

            // Act and Assert
            assertThrows(IllegalStateException.class, () -> xpressBeesService.createXpressBeesOrder(createOrder));
            mockInetAddress.verify(() -> InetAddress.getAllByName(Mockito.<String>any()));
            verify(customer).getAddress();
            verify(customer, atLeast(1)).getAddress2();
            verify(customer).getCity();
            verify(customer).getCountry();
            verify(customer).getEmail();
            verify(customer).getName();
            verify(customer).getPhone();
            verify(customer).getPincode();
            verify(customer).getState();
        }
    }

    /**
     * Method under test: {@link XpressBeesService#trackOrder(String, String)}
     */
    @Test
    void testTrackOrder() throws IOException {
        try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
            // Arrange
            mockInetAddress.when(() -> InetAddress.getAllByName(Mockito.<String>any()))
                    .thenThrow(new IllegalStateException("U/U"));

            // Act and Assert
            assertThrows(IllegalStateException.class, () -> xpressBeesService.trackOrder("Order Id", "42"));
            mockInetAddress.verify(() -> InetAddress.getAllByName(Mockito.<String>any()));
        }
    }

    /**
     * Method under test: {@link XpressBeesService#trackOrder(String, String)}
     */
    @Test
    void testTrackOrder2() throws IOException {
        try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
            // Arrange
            mockInetAddress.when(() -> InetAddress.getAllByName(Mockito.<String>any()))
                    .thenThrow(new IllegalStateException("U/U"));

            // Act and Assert
            assertThrows(IllegalStateException.class, () -> xpressBeesService.trackOrder("Order Id", "; U=U"));
            mockInetAddress.verify(() -> InetAddress.getAllByName(Mockito.<String>any()));
        }
    }

    /**
     * Method under test: {@link XpressBeesService#trackByAwb(String)}
     */
    @Test
    void testTrackByAwb() throws IOException {
        try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
            // Arrange
            mockInetAddress.when(() -> InetAddress.getAllByName(Mockito.<String>any()))
                    .thenThrow(new IllegalStateException("U/U"));

            // Act and Assert
            assertThrows(IllegalStateException.class, () -> xpressBeesService.trackByAwb("Awb Number"));
            mockInetAddress.verify(() -> InetAddress.getAllByName(Mockito.<String>any()));
        }
    }

    /**
     * Method under test: {@link XpressBeesService#trackByAwb(String)}
     */
    @Test
    void testTrackByAwb2() throws IOException {
        try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
            // Arrange
            mockInetAddress.when(() -> InetAddress.getAllByName(Mockito.<String>any()))
                    .thenThrow(new IllegalStateException("U/U"));

            // Act and Assert
            assertThrows(IllegalStateException.class, () -> xpressBeesService.trackByAwb("Awb NumberAwb Number"));
            mockInetAddress.verify(() -> InetAddress.getAllByName(Mockito.<String>any()));
        }
    }

    /**
     * Method under test: {@link XpressBeesService#getShipmentDetails(String)}
     */
    @Test
    void testGetShipmentDetails() throws IOException {
        try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
            // Arrange
            mockInetAddress.when(() -> InetAddress.getAllByName(Mockito.<String>any()))
                    .thenThrow(new IllegalStateException("U/U"));

            // Act and Assert
            assertThrows(IllegalStateException.class, () -> xpressBeesService.getShipmentDetails("Shipment Id"));
            mockInetAddress.verify(() -> InetAddress.getAllByName(Mockito.<String>any()));
        }
    }

    /**
     * Method under test: {@link XpressBeesService#getShipmentDetails(String)}
     */
    @Test
    void testGetShipmentDetails2() throws IOException {
        try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
            // Arrange
            mockInetAddress.when(() -> InetAddress.getAllByName(Mockito.<String>any()))
                    .thenThrow(new IllegalStateException("U/U"));

            // Act and Assert
            assertThrows(IllegalStateException.class, () -> xpressBeesService.getShipmentDetails("Shipment IdShipment Id"));
            mockInetAddress.verify(() -> InetAddress.getAllByName(Mockito.<String>any()));
        }
    }
}
