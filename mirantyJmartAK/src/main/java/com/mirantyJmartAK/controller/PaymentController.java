package com.mirantyJmartAK.controller;

import com.mirantyJmartAK.ObjectPoolThread;
import com.mirantyJmartAK.*;
import com.mirantyJmartAK.Payment;
import com.mirantyJmartAK.Product;
import com.mirantyJmartAK.Shipment;
import com.mirantyJmartAK.dbjson.JsonAutowired;
import com.mirantyJmartAK.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    @JsonAutowired(value = Payment.class, filepath = "Payment.json")
    public static JsonTable<Payment> paymentTable;
    ObjectPoolThread<Payment> poolThread;
    public static final long DELIVERED_LIMIT_MS = 1;
    public static final long ON_DELIVERY_LIMIT_MS = 2;
    public static final long ON_PROGRESS_LIMIT_MS = 3;
    public static final long WAITING_VONF_LIMIT_MS = 4;

    @PostMapping("/{id}/accept")
    @ResponseBody
    boolean accept
            (
                    @RequestParam int id
            )
    {
        for (Payment data : paymentTable)
        {
            if (data.id == id)
            {
                if(data.history.get(data.history.size()-1).status == Invoice.Status.WAITING_CONFIRMATION)
                {
                    data.history.add(new Payment.Record(Invoice.Status.ON_PROGRESS, null));
                    return true;
                }
            }
        }
        return false;
    }

    @PostMapping("/{id}/cancel")
    @ResponseBody
    boolean cancel
            (
                    @RequestParam int id
            )
    {
        for (Payment data : paymentTable)
        {
            if(data.id == id)
            {
                if(data.history.get(data.history.size()-1).status == Invoice.Status.WAITING_CONFIRMATION)
                {
                    data.history.add(new Payment.Record(Invoice.Status.CANCELLED, null));
                    return true;
                }
            }
        }
        return false;
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
        for (Account dataAccount : AccountController.accountTable)
        {
            if (dataAccount.id == buyerId)
            {
                for (Product data : ProductController.productTable)
                {
                    if (data.id == productId)
                    {
                        Payment payment = new Payment(buyerId, productId, productCount,new Shipment(shipmentAddress, 0, ShipmentPlan, null));
                        if (dataAccount.balance >= payment.getTotalPay(data))
                        {
                            dataAccount.balance -= payment.getTotalPay(data);
                            paymentTable.add(payment);
                            return payment;
                        }
                    }
                }
            }
        }
        return null;
    }

    @PostMapping("/{id}/submit")
    @ResponseBody
    boolean submit
            (
                    @RequestParam int id,
                    @RequestParam String receipt
            )
    {
        for (Payment data : paymentTable)
        {
            if(data.id == id)
            {
                if(data.history.get(data.history.size()-1).status == Invoice.Status.ON_PROGRESS)
                {
                    if (!receipt.isBlank())
                    {
                        data.shipment.receipt = receipt;
                        data.history.add(new Payment.Record(Invoice.Status.ON_DELIVERY, null));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }
}