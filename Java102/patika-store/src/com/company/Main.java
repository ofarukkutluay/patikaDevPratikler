package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static NotebookManager notebookManager = new NotebookManager();
    private static MobilePhoneManager mobilePhoneManager = new MobilePhoneManager();
    private static Scanner in =new Scanner(System.in).useLocale(Locale.US);

    public static void main(String[] args) {
        int select;
        boolean loop = true;

        while (loop){
            select = mainView();
            switch (select){
                case 0:
                    loop = false;
                    break;
                case 1:
                    noteBookView();
                    break;
                case 2:
                    mobilePhoneView();
                    break;

                case 3:
                    listBrands();
                    break;
                default:
                    System.out.println("Hatalı seçim yaptınız tekrar deneyiniz...");
                    select = -1;
            }
            System.out.println("------------------- End --------------------\n");
        }



    }
    private static int mainView(){
        System.out.print("PatikaStore Ürün Yönetim Paneli !\n" +
                "1 - Notebook İşlemleri\n" +
                "2 - Cep Telefonu İşlemleri\n" +
                "3 - Marka Listele\n" +
                "0 - Çıkış Yap\n" +
                "Tercihiniz : ");

        return in.nextInt();
    }

    private static void listBrands(){
        System.out.println("Markalarımız");
        System.out.println("--------------------");
        for (Brand brand:InMemoryDB.brands) {
            System.out.println("- "+brand.getName());
        }
    }

    private static void noteBookView(){
            System.out.println("Notebook İşlemleri : ");
            System.out.print("1- Ekle\n" +
                    "2- Sil\n" +
                    "3- Listele\n" +
                    "0 - Geri dön\n" +
                    "Seçiminiz : ");
            int n = in.nextInt();
            switch (n){
                case 1:
                    Notebook notebook = new Notebook();

                    System.out.print("Id : ");
                    notebook.setId(in.nextInt());

                    System.out.print("Name : ");
                    notebook.setName(in.next());

                    System.out.print("Price : ");
                    notebook.setPrice(in.nextDouble());

                    System.out.print("Discount : ");
                    notebook.setDiscount(in.nextDouble());

                    System.out.print("Stock : ");
                    notebook.setStock(in.nextInt());

                    System.out.print("BrandId : ");
                    int brandId = in.nextInt();
                    BrandManager brandManager = new BrandManager();
                    notebook.setBrand(brandManager.getById(brandId));

                    System.out.print("Ram : ");
                    notebook.setRam(in.nextInt());
                    System.out.print("Storage : ");
                    notebook.setStorage(in.nextInt());
                    System.out.print("Screen Size : ");
                    notebook.setScreenSize(in.nextDouble());

                    var resultCreate = notebookManager.create(notebook);
                    if(resultCreate)
                        System.out.println("Notebook eklendi!");
                    else
                        System.out.println("Db ye eklenirken bir hata oluştu");
                    break;
                case 2:
                    System.out.println("Notebook silme ekranı");
                    System.out.print("Silmek istediğiniz ntebookun id sini giriniz : ");
                    int id = in.nextInt();
                    var resultDelete = notebookManager.delete(id);
                    if(resultDelete)
                        System.out.println("Notebook silindi!");
                    else
                        System.out.println("Db den silinirken bir hata oluştu");
                    break;
                case 3:
                    System.out.println("---- Satıştaki Notebooklar ----");
                    String leftAlignFormat = "| %-2s | %-29s | %-8g TL | %-9s | %-6s GB | %-6s INC | %-7s GB |%n";

                    System.out.format("+----+-------------------------------+-------------+-----------+-----------+------------+------------+%n");
                    System.out.format("| ID | Ürün Adı                      | Fiyat       | Marka     | Depolama  | Ekran      | RAM        |%n");
                    System.out.format("+----+-------------------------------+-------------+-----------+-----------+------------+------------+%n");
                    for (Notebook x :
                            notebookManager.getAll()) {
                        System.out.format(leftAlignFormat,x.getId(),x.getName(),x.getPriceDiscount(),x.getBrand().getName(),x.getStorage(),x.getScreenSize(),x.getRam());
                    }
                    System.out.format("+----+-------------------------------+-------------+-----------+-----------+------------+------------+%n");
                    break;
                case 0 :
                    break;
                default:
                    System.out.println("Hatalı seçim yaptınız tekrar deneyiniz...");
                    break;
            }
    }

    private static void mobilePhoneView(){
        System.out.println("Cep Telefonu İşlemleri : ");
        System.out.print("1- Ekle\n" +
                "2- Sil\n" +
                "3- Listele\n" +
                "0 - Geri dön\n" +
                "Seçiminiz : ");
        int n = in.nextInt();
        switch (n){
            case 1:
                MobilePhone mobilePhone = new MobilePhone();

                System.out.print("Id : ");
                mobilePhone.setId(in.nextInt());

                System.out.print("Name : ");
                mobilePhone.setName(in.next());

                System.out.print("Price : ");
                mobilePhone.setPrice(in.nextDouble());

                System.out.print("Discount : ");
                mobilePhone.setDiscount(in.nextDouble());

                System.out.print("Stock : ");
                mobilePhone.setStock(in.nextInt());

                System.out.print("BrandId : ");
                int brandId = in.nextInt();
                BrandManager brandManager = new BrandManager();
                mobilePhone.setBrand(brandManager.getById(brandId));

                System.out.print("Ram : ");
                mobilePhone.setRam(in.nextInt());
                System.out.print("Storage : ");
                mobilePhone.setStorage(in.nextInt());
                System.out.print("Screen Size : ");
                mobilePhone.setScreenSize(in.nextDouble());
                System.out.print("Battery Size : ");
                mobilePhone.setBatterySize(in.nextInt());

                System.out.print("Color : ");
                mobilePhone.setColor(in.next());

                var resultCreate = mobilePhoneManager.create(mobilePhone);
                if(resultCreate)
                    System.out.println("Cep Telefonu eklendi!");
                else
                    System.out.println("Db ye eklenirken bir hata oluştu");
                break;
            case 2:
                System.out.println("Cep Telefonu silme ekranı");
                System.out.print("Silmek istediğiniz cep telefonun id sini giriniz : ");
                int id = in.nextInt();
                var resultDelete = mobilePhoneManager.delete(id);
                if(resultDelete)
                    System.out.println("Cep Telefonu silindi!");
                else
                    System.out.println("Db den silinirken bir hata oluştu");
                break;
            case 3:
                System.out.println("---- Satıştaki Cep Telefonları ----");
                String leftAlignFormat = "| %-2s | %-29s | %-8g TL | %-9s | %-6s GB | %-6s INC | %-9s | %-9s | %-7s GB | %-9s |%n";

                System.out.format("+----+-------------------------------+-------------+-----------+-----------+------------+------------+-----------+-----------+-----------+%n");
                System.out.format("| ID | Ürün Adı                      | Fiyat       | Marka     | Depolama  | Ekran      | Kamera     | Pil       | RAM       | Renk      |%n");
                System.out.format("+----+-------------------------------+-------------+-----------+-----------+------------+------------+-----------+-----------+-----------+%n");
                for (MobilePhone x :
                        mobilePhoneManager.getAll()) {
                    System.out.format(leftAlignFormat,x.getId(),x.getName(),x.getPriceDiscount(),x.getBrand().getName(),x.getStorage(),x.getScreenSize(),"",x.getBatterySize(),x.getRam(),x.getColor());
                }
                System.out.format("+----+-------------------------------+-------------+-----------+-----------+------------+------------+-----------+-----------+-----------+%n");
                break;
            case 0 :
                break;
            default:
                System.out.println("Hatalı seçim yaptınız tekrar deneyiniz...");
                break;
        }
    }
}
