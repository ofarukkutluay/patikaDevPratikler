package com.company;

public class BrandManager {
    public Brand getById(int id) {
        Brand brand = null;
        for (Brand x :
                InMemoryDB.brands) {
            if (x.getId() == id) {
                brand = x;
                break;
            }
        }
        return brand;
    }
}
