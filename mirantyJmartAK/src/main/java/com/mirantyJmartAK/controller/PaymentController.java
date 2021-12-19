package com.mirantyJmartAK.controller;

import com.mirantyJmartAK.ObjectPoolThread;
import com.mirantyJmartAK.*;
import com.mirantyJmartAK.Payment;
import com.mirantyJmartAK.Product;
import com.mirantyJmartAK.Shipment;
import com.mirantyJmartAK.dbjson.JsonAutowired;
import com.mirantyJmartAK.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

/**
 * This class controls over the class payment.
 * It can accept, cancel, create, and submit payment.
 *
 * @author Miranty Anjani Putri
 */

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    @JsonAutowired(value = Payment.class, filepath = "Payment.json")
    public static JsonTable<Payment> paymentTable;
    ObjectPoolThread<Payment> poolThread;
    public static final long DELIVERED_LIMIT_MS = 1;
    public static final long ON_DELIVERY_LIMIT_MS = 2;
    public static final long ON_PROGRESS_LIMIT_MS = 3;
    public static final long WAITING_CONF_LIMIT_MS = 4;

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
    public Payment create
            (
                    @RequestParam int buyerId,
                    @RequestParam int productId,
                    @RequestParam int productCount,
                    @RequestParam String shipmentAddress,
                    @RequestParam byte ShipmentPlan
            )
    {
        for (Account data : AccountController.accountTable) {
            if (data.id == buyerId) {
                for (Product productData : ProductController.productTable) {
                    if (productData.id == productId) {
                        Payment payment = new Payment(buyerId, productId, productCount, new Shipment(shipmentAddress, 0, productData.shipmentPlans, null));
                        if (data.balance >= payment.getTotalPay(productData)) {
                            data.balance -= payment.getTotalPay(productData);
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

    private static boolean timekeeper(Payment payment) {
        Payment.Record record = payment.history.get(payment.history.size() - 1);
        long elapsed = System.currentTimeMillis() - record.date.getTime();
        if (record.status.equals(Invoice.Status.WAITING_CONFIRMATION) && (elapsed > WAITING_CONF_LIMIT_MS)) {
            record.status = Invoice.Status.FAILED;
            return true;
        } else if (record.status.equals(Invoice.Status.ON_PROGRESS) && (elapsed > ON_PROGRESS_LIMIT_MS)) {
            record.status = Invoice.Status.FAILED;
            return true;
        } else if (record.status.equals(Invoice.Status.ON_DELIVERY) && (elapsed > ON_PROGRESS_LIMIT_MS)) {
            record.status = Invoice.Status.FINISHED;
            return true;
        } else if (record.status.equals(Invoice.Status.FINISHED) && (elapsed > DELIVERED_LIMIT_MS)) {
            record.status = Invoice.Status.FINISHED;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }
}