package com.mirantyJmartAK.controller;

import com.mirantyJmartAK.Payment;

public class PaymentController implements BasicGetController<Payment> {
    public static final long DELIVERED_LIMIT_MS = 1;
    public static final long ON_DELIVERY_LIMIT_MS = 2;
    public static final long ON_PROGRESS_LIMIT_MS = 3;
    public static final long WAITING_CONF_LIMIT_MS = 4;
}
