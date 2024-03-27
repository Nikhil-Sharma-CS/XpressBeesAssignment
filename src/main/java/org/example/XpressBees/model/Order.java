package org.example.XpressBees.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

        private String order_id;
        private String order_date;
        private String pickup_location;
        private int channel_id;
        private String comment;

        private String reseller_name;
        private String company_name;

        private String billing_customer_name;
        private String billing_last_name;
        private String billing_address;
        private String billing_address_2;
        private String billing_isd_code;
        private String billing_city;
        private int billing_pincode;
        private String billing_state;
        private String billing_country;
        private String billing_email;
        private Integer billing_phone;
        private int billing_alternate_phone;

        private boolean shipping_is_billing;
        private String shipping_customer_name;
        private String shipping_last_name;
        private String shipping_address;
        private String shipping_address_2;
        private String shipping_city;
        private int shipping_pincode;
        private String shipping_country;
        private String shipping_state;
        private String shipping_email;
        private int shipping_phone;

        private List<OrderItem> order_items;

        private String payment_method;
        private int shipping_charges;
        private int giftwrap_charges;
        private int transaction_charges;
        private int total_discount;
        private int sub_total;

        private float length;
        private float breadth;
        private float height;
        private float weight;

        private String ewaybill_no;
        private String customer_gstin;
        private String invoice_number;
        private String order_type;

        private String checkout_shipping_method;
        private String what3words_address;
        private boolean is_insurance_opt;


}
