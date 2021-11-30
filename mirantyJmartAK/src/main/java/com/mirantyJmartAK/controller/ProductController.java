package com.mirantyJmartAK.controller;

import com.mirantyJmartAK.Algorithm;
import com.mirantyJmartAK.Product;
import com.mirantyJmartAK.ProductCategory;
import com.mirantyJmartAK.Store;
import com.mirantyJmartAK.dbjson.JsonAutowired;
import com.mirantyJmartAK.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController implements BasicGetController<Product> {
    @JsonAutowired (value = Product.class, filepath = "Product.json")
    public static JsonTable<Product> productTable;

    public JsonTable<Product> getJsonTable() {
        return productTable;
    }

    @PostMapping("/create")
    @ResponseBody
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
        for (Product data : productTable)
        {
            if (data.accountId == accountId)
            {
                Product product = new Product(accountId, name, weight, conditionUsed, price, discount, category, ShipmentPlans);
                productTable.add(product);
                return product;
            }
        }
        return null;
    }

    @GetMapping("/{id}/store")
    @ResponseBody
    List<Product> getProductByStore
            (
                    @PathVariable int id,
                    @RequestParam int page,
                    @RequestParam int pageSize
            )
    {
        return Algorithm.paginate(productTable, page, pageSize, pred -> pred.accountId == id);
    }

    @GetMapping("/getProductFiltered")
    @ResponseBody
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
        List<Product> tempProduct = new ArrayList<Product>();
        for (Product data : productTable)
        {
            if (data.accountId == accountId)
            {
                if (data.name.contains(search))
                {
                    if (minPrice <= data.price)
                    {
                        if (maxPrice >= data.price)
                        {
                            if (data.category == category)
                            {
                                tempProduct.add(data);
                            }
                        }
                    }
                }
            }
        }
        return tempProduct;
    }
}