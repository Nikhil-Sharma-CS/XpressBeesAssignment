package org.example.XpressBees.model;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    public String name;
    public String sku;
    public int units;
    public int selling_price;
    public int discount;
    public int tax;
    public int hsn;
}
