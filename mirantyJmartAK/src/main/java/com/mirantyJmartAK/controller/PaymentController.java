package com.mirantyJmartAK.controller;

import com.mirantyJmartAK.ObjectPoolThread;
import com.mirantyJmartAK.Payment;
import com.mirantyJmartAK.Shipment;
import com.mirantyJmartAK.controller.BasicGetController;
import com.mirantyJmartAK.dbjson.JsonAutowired;
import com.mirantyJmartAK.dbjson.JsonTable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    @JsonAutowired(value = Payment.class, filepath = "C:\\Users\\Lenovo\\OneDrive\\Documents\\randomPaymentList.json") JsonTable<Payment> paymentTable;
    public static final long DELIVERED_LIMIT_MS = 0;
    public static final long ON_DELIVERY_LIMIT_MS = 1;
    public static final long ON_PROGRESS_LIMIT_MS = 2;
    public static final long WAITING_VONF_LIMIT_MS = 3;

    public static ObjectPoolThread<Payment> poolThread;

    @PostMapping("/{id}/accept")
    boolean accept (int id) {
        return true;
    }

    @PostMapping("/{id}/cancel")
    boolean cancel (int id) {
        return true;
    }

    @PostMapping("/create")
    Payment create
            (
                    @RequestParam int buyerId,
                    @RequestParam int productId,
                    @RequestParam int productCount,
                    @RequestParam String shipmentAddress,
                    @RequestParam byte ShipmentPlan
            )
    {
        //Shipment ship = new Shipment(shipmentAddress, 0, (Duration).ShipmentPlan,buyerId);
        // Integer buyerId, Integer productId, Integer productCount, Shipment shipment
        Shipment shipment = new Shipment(shipmentAddress, 0, ShipmentPlan, "Receipt");
        return new Payment(buyerId, productId, productCount, shipment);
    }

    public JsonTable<Payment> getJsonTable () {
        return paymentTable;
    }

    @PostMapping("/{id}/submit")
    boolean submit
            (
                    @RequestParam int id,
                    @RequestParam String receipt
            )
    {
        return true;
    }
}