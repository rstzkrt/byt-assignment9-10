package com.group14.billetsystem.user.discounts;

public abstract class Discount {
    protected final int discountPercentage;
    protected final String discountName;

    public Discount(int discountPercentage, String discountName) {
        if (validateDiscountPercentage(discountPercentage)){
            this.discountPercentage = discountPercentage;
            this.discountName = discountName;
        }
        throw new RuntimeException("discount Percentege out of scope");
    }

    protected boolean validateDiscountPercentage(int discountPercentage){
        return discountPercentage >= 0 && discountPercentage <= 100;
    }


    public int getDiscountPercentage() {
        return discountPercentage;
    }

}
