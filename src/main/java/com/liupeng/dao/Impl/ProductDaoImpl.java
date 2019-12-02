package com.liupeng.dao.Impl;

import com.liupeng.dao.ProductDao;
import com.liupeng.entiey.PRODUCT;
import com.liupeng.until.Condition;
import com.liupeng.until.Jdbcuntil;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    @Override
    public boolean Productadd(PRODUCT product) {
        String sql="insert into PRODUCT (serialNumber,name,brand,model,price,description) values(?,?,?,?,?,?)";
        Object[]parms={product.getSerialNumber(),product.getName(),product.getBrand(),product.getModel(),product.getPrice(),product.getDescription()};

        return Jdbcuntil.AddDeleteUpdate(sql,parms);
    }

    @Override
    public List<PRODUCT> find() {
        String sql="select*from PRODUCT";
        Object[]parms=null;
        return Jdbcuntil.saveProduct(sql,parms);
    }

    @Override
    public boolean Productupdate(PRODUCT product) {

        String sql = Condition.Productupdate(product);

        List<Object> list = new ArrayList<Object>();


            if (product.getSerialNumber() != null)
                list.add(product.getSerialNumber());
            if (product.getName() != null)
                list.add(product.getName());
            if (product.getBrand() != null)
                list.add(product.getBrand());
            if (product.getModel() != null)
                list.add(product.getModel());
            if (product.getPrice() != 0)
                list.add(product.getPrice());
            if (product.getDescription() != null)
                list.add(product.getDescription());


            list.add(product.getProductID());

            Object[] parms = new Object[list.size()];
            for (int i = 0; i < list.size(); i++) {
                parms[i] = list.get(i);

            }


        return Jdbcuntil.AddDeleteUpdate(sql, parms);
    }

    @Override
    public boolean Productdelete(int id) {
        String sql="delete from PRODUCT where productID=?";
        Object[]parms={id};

        return Jdbcuntil.AddDeleteUpdate(sql,parms);
    }

    @Override
    public List<PRODUCT> Productfindblurry(String s) {
        String sql="select *from PRODUCT where name LIKE ?";

        Object[]parms={"%"+s+"%"};

        return Jdbcuntil.saveProduct(sql,parms);
    }

    @Override
    public List<PRODUCT> ProductfindByid(int productID) {
        String sql="select *from PRODUCT where productID=?";

        Object[]parms={productID};

        return Jdbcuntil.saveProduct(sql,parms);

    }
}
