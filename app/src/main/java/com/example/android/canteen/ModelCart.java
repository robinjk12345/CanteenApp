package com.example.android.canteen;

import java.util.ArrayList;

public class
ModelCart{

    private  ArrayList<ModelProducts> cartProducts = new ArrayList<ModelProducts>();


    public ModelProducts getProducts(int pPosition) {

        return cartProducts.get(pPosition);
    }

    public void setProducts(ModelProducts Products) {

        cartProducts.add(Products);

    }

    public int getCartSize() {

        return cartProducts.size();

    }

    public int getTotal() {
        int total = 0;
        for (int i = 0; i < this.getCartSize(); i++) {
            total = total + this.getProducts(i).getProductPrice();
        }
        return total;
    }

    public boolean checkProductInCart(ModelProducts aProduct) {

        return cartProducts.contains(aProduct);

    }

}
