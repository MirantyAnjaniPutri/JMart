package mirantyJmartAK;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.*;


public class Jmart
{        
    class Country
    {
        public String name;
        public int population;
        public List<String> listOfStates;
    }

    public static List<Product> filterByCategory (List<Product> list, ProductCategory category) {
        return null;
    }

    public static List<Product> filterByPrice (List<Product> list, double minPrice, double maxPrice) {
        return null;
    }

    public static void main(String[] args)
    {
        String filepath = "C:/Users/Lenovo/JMart/src/lib/city.json";
        Gson gson = new Gson();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            Country input = gson.fromJson(br, Country.class);
            System.out.println("Name: " + input.name);
            System.out.println("Population: " + input.population);
            System.out.println("States: ");
            input.listOfStates.forEach(state -> System.out.println(state));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
