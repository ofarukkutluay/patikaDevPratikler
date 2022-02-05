package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class InMemoryDB {

    private static BrandManager brandManager = new BrandManager();
    //Samsung, Lenovo, Apple, Huawei, Casper, Asus, HP, Xiaomi, Monster
    public static TreeSet<Brand> brands = new TreeSet<Brand>(List.of(new Brand[]{
            new Brand(1, "Samsung"),
            new Brand(2, "Lenovo"),
            new Brand(3, "Apple"),
            new Brand(4, "Huawei"),
            new Brand(5, "Casper"),
            new Brand(6, "Asus"),
            new Brand(7, "HP"),
            new Brand(8, "Xiaomi"),
            new Brand(9, "Monster")
    }));
    public static List<Notebook> notebooks = new ArrayList<Notebook>(List.of(new Notebook[]{
            new Notebook(1, 10000, 10, 1200, "Hp 14' Laptop", brandManager.getById(7), 8, 128, 14.1),
            new Notebook(2, 21255.45, 5, 1212, "Apple 14' Laptop", brandManager.getById(3), 16, 256, 14.1),
            new Notebook(3, 35499.5, 50, 11, "Lenovo 15.6' Gaming Laptop", brandManager.getById(2), 32, 1000, 15.6),
            new Notebook(4, 6999.99, 2, 3500, "Casper 17' Laptop", brandManager.getById(5), 4, 128, 17.0),
            new Notebook(5, 9999.99, 0, 2000, "Huawei 13.3' Laptop", brandManager.getById(4), 16, 512, 13.3),
    }));
    public static List<MobilePhone> mobilePhones = new ArrayList<>(List.of(new MobilePhone[]{
            new MobilePhone(1, 3450.90, 10, 1200, "Xiaomi Cep Telefonu", brandManager.getById(8), 8, 128, 6.1,3300,"Kırmızı"),
            new MobilePhone(2, 9754.3, 1, 1200, "Apple Cep Telefonu", brandManager.getById(3), 4, 256, 5.3,2800,"Siyah"),
            new MobilePhone(3, 2250, 0, 1200, "Lenovo Cep Telefonu", brandManager.getById(2), 8, 512, 6.7,5000,"Sarı"),
            new MobilePhone(4, 1312, 5, 1200, "Casper Cep Telefonu", brandManager.getById(5), 6, 128, 5.2,3000,"Mavi"),
            new MobilePhone(5, 12342.98, 10, 1200, "Huawei Cep Telefonu", brandManager.getById(4), 12, 1000, 6.4,5000,"Alev"),
    }));

}
