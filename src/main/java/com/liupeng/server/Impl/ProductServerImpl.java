package com.liupeng.server.Impl;

import com.liupeng.dao.Impl.ProductDaoImpl;
import com.liupeng.entiey.PRODUCT;
import com.liupeng.server.ProductServer;

import java.util.List;

public class ProductServerImpl implements ProductServer {

    ProductDaoImpl productDao=new ProductDaoImpl();
    @Override
    public boolean Productadd(PRODUCT product) {
        return productDao.Productadd(product);
    }

    @Override
    public List<PRODUCT> find() {

        return productDao.find();
    }

    @Override
    public boolean Productupdate(PRODUCT product) {

        return productDao.Productupdate(product);
    }

    @Override
    public boolean Productdelete(int id) {

        return productDao.Productdelete(id);
    }

    @Override
    public boolean ProductfindByid(int productID) {
      List<PRODUCT> productList=  productDao.ProductfindByid(productID);
      if(productList!=null){
          return true;
      }
      else  return  false;
    }

    @Override
    public List<PRODUCT> Productfindblurry(String s)
    {
        return productDao.Productfindblurry(s);
    }
}
