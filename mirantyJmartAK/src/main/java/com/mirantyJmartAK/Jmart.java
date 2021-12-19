package com.mirantyJmartAK;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import com.mirantyJmartAK.dbjson.JsonDBEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * Main class, aka using SpringApplication,
 * it makes the complex program runnable.
 * @author Miranty Anjani Putri
 */

@SpringBootApplication
public class Jmart {
    public static long DELIVERED_LIMIT_MS = 1;
    public static long ON_DELIVERY_LIMIT_MS = 2;
    public static long ON_PROGRESS_LIMIT_MS = 3;
    public static long WAITING_CONF_LIMIT_MS = 4;

    public static void main(String[] args) {
        JsonDBEngine.Run(Jmart.class);
        SpringApplication.run(Jmart.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
    }

    public static boolean paymentKeeper(Payment payment)
    {

        long start = System.currentTimeMillis();
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;

        if (payment.history.equals(Invoice.Status.WAITING_CONFIRMATION) && timeElapsed > WAITING_CONF_LIMIT_MS)
        {
            payment.history.add(new Payment.Record(Invoice.Status.FAILED, "FAILED"));
        }
        else if(payment.history.equals(Invoice.Status.ON_PROGRESS) && timeElapsed > ON_PROGRESS_LIMIT_MS)
        {
            payment.history.add(new Payment.Record(Invoice.Status.FAILED, "FAILED"));
        }
        else if(payment.history.equals(Invoice.Status.ON_DELIVERY) && timeElapsed > ON_DELIVERY_LIMIT_MS)
        {
            payment.history.add(new Payment.Record(Invoice.Status.ON_DELIVERY, "ON_DELIVERY"));
            return true;
        }
        else if(payment.history.equals(Invoice.Status.FINISHED) && timeElapsed > DELIVERED_LIMIT_MS)
        {
            payment.history.add(new Payment.Record(Invoice.Status.FINISHED, "DELIVERED"));
            return true;
        }

        return false;
    }
}

    /*public static List<Product> filterByAccountId (List<Product> list, int accountId, int page, int pageSize) {
        List<Product> tempo = new ArrayList<Product>();
        for (Product product : list) {
            tempo.add(product);
        }
        return null;
    }

    public static List<Product> filterByCategory (List<Product> list, ProductCategory category) {
        List<Product> tempo = new ArrayList<Product>();
        for (Product product : list) {
            tempo.add(product);
        }
        return null;
    }

    public static List<Product> filterByName (List<Product> list, String search, int page, int pageSize) {
        List<Product> tempo = new ArrayList<Product>();
        for (Product product : list) {
            tempo.add(product);
        }
        return null;
    }

    public static List<Product> filterByPrice (List<Product> list, double minPrice, double maxPrice) {
        if (minPrice <= 0) {
            return Algorithm.<Product>collect(list, prod -> prod.price <= maxPrice);
        }
        else if (maxPrice <= 0) {
            return Algorithm.<Product>collect(list, prod -> prod.price >= minPrice);
        }
        return Algorithm.<Product>collect(list, prod -> prod.price <= maxPrice && prod.price >= minPrice);
    }*/

    /*private static List<Product> paginate (List<Product> list, int page, int pageSize, Predicate<Product> pred) {
        int iteration = 0;
        int occurences = 0;
        int startingIdx = page * pageSize;
        List<Product> pageList = new ArrayList<>(pageSize);

        for (; iteration < list.size() && occurences < startingIdx; ++iteration) {
            if (pred.predicate(list.get(iteration))) {
                ++occurences;
            }
        }
        for (int i = iteration; i < list.size() && pageList.size() < pageSize; ++i) {
            if (pred.predicate(list.get(i))) {
                pageList.add(list.get(i));
            }
        }
        return pageList;
    }

    public static List<Product> read(String filepath) throws FileNotFoundException {
        Gson gson = new Gson();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            Product input = gson.fromJson(br, Product.class);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }*/