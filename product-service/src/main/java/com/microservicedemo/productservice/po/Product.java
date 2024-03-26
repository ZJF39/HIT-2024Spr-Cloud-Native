/*package com.microservicedemo.productservice;*/
package com.microservicedemo.productservice.po;
import lombok.Data;

/**
 * 商品的实体
 */
@Data
public class Product {

    private Long id;
    private String productName;
    private Double price;
    private Long stock;
}