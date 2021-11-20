package com.mirantyJmartAK.controller;

import com.mirantyJmartAK.dbjson.JsonTable;
import com.mirantyJmartAK.dbjson.Serializable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/home")
public interface BasicGetController <T extends Serializable> {
    int page = 10;
    int pageSize = 25;

    @GetMapping(value = "/id")
    @ResponseBody
    default <id> ResponseEntity<T> getById(PathVariable id) { //(@PathVariable id)
        return null;
    }

    public default JsonTable<T> getJsonTable() {
        return null;
    }

    @GetMapping(value = "/page")
    public default List<T> getPage (int page, int pageSize) {
        return null;
    }
}
