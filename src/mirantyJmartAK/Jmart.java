package mirantyJmartAK;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import com.google.gson.*;


public class Jmart {
    public static long DELIVERED_LIMIT_MS = 1;
    public static long ON_DELIVERY_LIMIT_MS = 2;
    public static long ON_PROGRESS_LIMIT_MS = 3;
    public static long WAITING_CONF_LIMIT_MS = 4;

    public static void main(String[] args) throws IOException {
        try {
            JsonTable<Payment> table = new JsonTable<>(Payment.class, "C:/Users/Lenovo/JMart/src/lib/randomPaymentList.json");
            ObjectPoolThread<Payment> paymentPool = new ObjectPoolThread<Payment>("Thread-PP", Jmart::paymentTimekeeper);
            paymentPool.start();
            table.forEach(payment -> paymentPool.add((Payment) payment));
            while (paymentPool.isAlive()) ;
            System.out.println("Thread exited successfully");
            Gson gson = new Gson();
            table.forEach(payment -> {
                String history = gson.toJson(payment);
                System.out.println(history);
            });
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static boolean paymentTimekeeper(Payment payment) {
        return true;
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
}