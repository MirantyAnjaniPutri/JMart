package com.mirantyJmartAK.controller;

import com.mirantyJmartAK.Algorithm;
import com.mirantyJmartAK.Coupon;
import com.mirantyJmartAK.dbjson.JsonAutowired;
import com.mirantyJmartAK.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class controls over the class Coupon.
 * It can check whether a coupon is available to be used by the user,
 * apply coupon for the user's purchase.
 *
 * @author Miranty Anjani Putri
 */

@RestController
@RequestMapping("/coupon")
public class CouponController implements BasicGetController<Coupon> {
    @JsonAutowired (value = Coupon.class, filepath = "Coupon.json")
    public static JsonTable<Coupon> couponTable;

    public JsonTable<Coupon> getJsonTable () {
        return couponTable;
    }

    @GetMapping("/getAvailable")
    @ResponseBody
    List<Coupon> getAvailable
            (
                    @RequestParam int page,
                    @RequestParam int pageSize
            )
    {
        return Algorithm.paginate(couponTable, page, pageSize, pred -> !pred.isUsed());
    }

    @GetMapping("/{id}/canApply")
    @ResponseBody
    boolean canApply
            (
                    @RequestParam int id,
                    @RequestParam double price,
                    @RequestParam double discount
            )
    {
        for (Coupon data : couponTable)
        {
            if (data.id == id) {
                return data.canApply(price, discount);
            }
        }
        return false;
    }

    @GetMapping("/{id}/isUsed")
    @ResponseBody
    boolean isUsed
            (
                    @RequestParam int id
            )
    {
        for (Coupon data : couponTable)
        {
            if (data.id == id)
            {
                return data.isUsed();
            }
        }
        return false;
    }

    @Override
    public Coupon getById (int id)
    {
        return BasicGetController.super.getById(id);
    }

    @Override
    public List getPage (int page, int pageSize)
    {
        return BasicGetController.super.getPage(page, pageSize);
    }
}
