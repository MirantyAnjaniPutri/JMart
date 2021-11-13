package mirantyJmartAK;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import com.google.gson.*;


public class Jmart
{
    public static List<Product> filterByAccountId (List<Product> list, int accountId, int page, int pageSize) {
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
        List<Product> tempo = new ArrayList<Product>();
        for (Product product : list) {
            tempo.add(product);
        }
        return null;
    }

    public static void main(String[] args)
    {
        try
        {
            List<Product> list = read("H:/SEMESTER 3/PRAK OOP/randomProductList.json");
            List<Product> filtered = filterByPrice(list, 0.0, 2000.0);
            filtered.forEach(product -> System.out.println(product.price));
        }
        catch (Throwable t)
        {
            t.printStackTrace();
        }
    }

    private static List<Product> paginate (List<Product> list, int page, int pageSize, Predicate<Product> pred) {
        List<Product> tempo = new ArrayList<Product>();
        for (Product product : list) {
            tempo.add(product);
        }
        return null;
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
    }
}
