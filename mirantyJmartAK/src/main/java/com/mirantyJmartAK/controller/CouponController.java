package com.mirantyJmartAK.controller;

import com.mirantyJmartAK.Coupon;
import com.mirantyJmartAK.Product;
import com.mirantyJmartAK.dbjson.JsonAutowired;
import com.mirantyJmartAK.dbjson.JsonTable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/coupon")
public class CouponController implements BasicGetController<Coupon> {
    public static @JsonAutowired
            (value = Coupon.class, filepath = "C:\\Users\\Lenovo\\OneDrive\\Documents\\randomPaymentList.json")
    JsonTable<Coupon> couponTable;

    public JsonTable<Coupon> getJsonTable () {
        return couponTable;
    }

    @GetMapping("/getAvailable")
    List<Coupon> getAvailable
            (
                    @RequestParam int page,
                    @RequestParam int pageSize
            )
    {
        return null;
    }

    @GetMapping("/{id}/canApply")
    boolean canApply
            (
                    @RequestParam int id,
                    @RequestParam double price,
                    @RequestParam double discount
            )
    {
        return true;
    }

    @GetMapping("/{id}/isUsed")
    boolean isUsed
            (
                    @RequestParam int id
            )
    {
        return false;
    }
}
