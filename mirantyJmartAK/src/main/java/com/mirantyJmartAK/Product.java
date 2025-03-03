package com.mirantyJmartAK;


import com.mirantyJmartAK.dbjson.Serializable;

/**
 * This class is about prodyct.
 *
 * @author Miranty Anjani Putri
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
    public byte shipmentPlans;

    public Product(int accountId, String name, int weight, boolean conditionUsed, double price, double discount, ProductCategory category, byte shipmentPlans) {
        this.accountId = accountId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.price = price;
        this.discount = discount;
        this.category = category;
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
        return ("Name: " + name + "\nWeight: " + weight + "\nconditionUsed: " + conditionUsed + "\nprice: " + price + "\ncategory: " + category);
    }
}