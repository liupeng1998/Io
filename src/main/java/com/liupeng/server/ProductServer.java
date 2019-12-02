package com.liupeng.server;

import com.liupeng.entiey.PRODUCT;

import java.util.List;

public interface ProductServer {

    boolean Productadd(PRODUCT product);

    List<PRODUCT> find();

    boolean Productupdate(PRODUCT product);

    boolean Productdelete(int id);

    boolean ProductfindByid(int productID);

    List<PRODUCT> Productfindblurry(String s);
}
