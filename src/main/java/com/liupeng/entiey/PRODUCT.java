package com.liupeng.entiey;

/*
产品表
 */
public class PRODUCT {
    private int productID;          //标识id
    private String serialNumber;    //商品编号
    private String name;            //商品名称
    private String brand;           //商品品牌
    private String model;           //型号
    private double price;           //价格
    private String description;     //描述

    public PRODUCT() {
    }

    public PRODUCT(int productID, String serialNumber, String name, String brand, String model, double price, String description) {
        this.productID = productID;
        this.serialNumber = serialNumber;
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.description = description;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return
                "标识id：" + productID +
                "\n 商品编号:" + serialNumber +
                "\n 商品名称:" + name +
                "\n 商品品牌:" + brand +
                "\n 型号:" + model +
                "\n 价格:" + price +
                "\n 描述:" + description;
    }
}
