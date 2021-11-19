package com.mirantyJmartAK;


/**
 * Write a description of class Product here.
 *
 * @author Miranty Anjani Putri
 * @version (a version number or a date)
 */

public class Product extends Serializable
{    
    public int accountId;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public double price;
    public double discount;
    public ProductCategory category;
    public ProductRating rating;
    public byte shipmentPlans;

    public Product(int accountId, String name, int weight, boolean conditionUsed, double price, double discount, ProductCategory category, byte shipmentPlans) {
        // main -> Product new Product = new Product(blablabla);
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.price = price;
        this.discount = discount;
        this.category = category;
        this.rating = new ProductRating();
        this.shipmentPlans = shipmentPlans;
    }
    
    /*
    public Product (int id, Store store, String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category) {
        super(id);
        this.storeId = store.id;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.rating = new ProductRating();
    }*/
    
    public String toString() {
        return ("Name: " + name + "\nWeight: " + weight + "\nconditionUsed: " + conditionUsed + "\nprice: " + price + "\ncategory: " + category + "\nrating: " + rating);
    }
}