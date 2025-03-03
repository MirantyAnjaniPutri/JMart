package com.mirantyJmartAK.controller;

import com.mirantyJmartAK.Algorithm;
import com.mirantyJmartAK.dbjson.JsonTable;
import com.mirantyJmartAK.dbjson.Serializable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This class controls over any class.
 * It can access a user by their id, get Json table for respective data, and
 * get page for the display on the app.
 *
 * @author Miranty Anjani Putri
 */

@RestController
public interface BasicGetController <T extends Serializable> {
    @GetMapping("/{id}")
    public default T getById (@PathVariable int id){
        return Algorithm.<T>find(getJsonTable(),e -> e.id == id);
    }

    public abstract JsonTable<T> getJsonTable ();

    @GetMapping("/page")
    public default List<T> getPage(@RequestParam int page,@RequestParam int pageSize){
        final JsonTable<T> table = getJsonTable();
        return Algorithm.paginate(table,page,pageSize,o->true);
    }
}
