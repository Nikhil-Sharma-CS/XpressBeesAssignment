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
    public double sellingPrice;
    public String discount;
    public String tax;
    public int hsn;
}
