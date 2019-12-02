package com.liupeng.dao;

import com.liupeng.entiey.PRODUCT;

import java.util.List;

public interface ProductDao {
    boolean Productadd(PRODUCT product);

    List<PRODUCT> find();

    boolean Productupdate(PRODUCT product);

    boolean Productdelete(int id);

    List<PRODUCT> Productfindblurry(String s);

    List<PRODUCT> ProductfindByid(int productID);
}
