package com.project.udacity.inventoryapp.models;

import java.io.Serializable;

public class Book implements Serializable {

    public static final int MIN_BOOK_PRICE_= 0;
    public static final int MIN_BOOK_QUANTITY = 0;

    private long mId;
    private String mName;
    private double mPrice;
    private int mQuantity;
    private String mSupplierName;
    private String mSupplierPhoneNumber;

    public Book(String name, double price, int quantity, String supplierName, String supplierPhoneNumber) {
        this(0, name, price, quantity, supplierName, supplierPhoneNumber);
    }

    public Book(long id, String name, double price, int quantity, String supplierName, String supplierPhoneNumber) {
        this.mId = id;
        this.mName = name;
        this.mPrice = price;
        this.mQuantity = quantity;
        this.mSupplierName = supplierName;
        this.mSupplierPhoneNumber = supplierPhoneNumber;
    }

    public long getId() {
        return mId;
    }

    public void setId(long mId) {
        this.mId = mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double mPrice) {
        this.mPrice = mPrice;
    }

    public int getQuantity() {
        return mQuantity;
    }

    public void setQuantity(int mQuantity) {
        this.mQuantity = mQuantity;
    }

    public String getSupplierName() {
        return mSupplierName;
    }

    public void setSupplierName(String mSupplierName) {
        this.mSupplierName = mSupplierName;
    }

    public String getSupplierPhoneNumber() {
        return mSupplierPhoneNumber;
    }

    public void setSupplierPhoneNumber(String mSupplierPhoneNumber) {
        this.mSupplierPhoneNumber = mSupplierPhoneNumber;
    }
}
