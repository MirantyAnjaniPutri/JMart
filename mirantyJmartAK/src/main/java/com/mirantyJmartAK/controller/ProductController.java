package com.mirantyJmartAK.controller;

import com.google.gson.annotations.JsonAdapter;
import com.mirantyJmartAK.Account;
import com.mirantyJmartAK.Product;
import com.mirantyJmartAK.ProductCategory;
import com.mirantyJmartAK.Store;
import com.mirantyJmartAK.dbjson.JsonAutowired;
import com.mirantyJmartAK.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController implements BasicGetController<Product> {
    public static @JsonAutowired
            (value = Product.class, filepath = "C:\\Users\\Lenovo\\OneDrive\\Documents\\randomPaymentList.json")
    JsonTable<Product> productTable;

    public JsonTable<Product> getJsonTable () {
        return productTable;
    }

    @PostMapping("/create")
    Product create
            (
                    @RequestParam int accountId,
                    @RequestParam String name,
                    @RequestParam int weight,
                    @RequestParam boolean conditionUsed,
                    @RequestParam double price,
                    @RequestParam double discount,
                    @RequestParam ProductCategory category,
                    @RequestParam byte ShipmentPlans
            )
    {
        return null;
    }

    @GetMapping("/{id}/store")
    List<Product> getProductByStore
            (
                    @RequestParam int id,
                    @RequestParam int page,
                    @RequestParam int pageSize
            )
    {
        return null;
    }

    @GetMapping("/{id}/store")
    List<Product> getProductByFilter
            (
                    @RequestParam int page,
                    @RequestParam int pageSize,
                    @RequestParam int accountId,
                    @RequestParam String search,
                    @RequestParam int minPrice,
                    @RequestParam int maxPrice,
                    @RequestParam ProductCategory category
            )
    {
        return null;
    }
}