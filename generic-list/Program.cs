using System;
using System.Collections.Generic;

namespace generic_list
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> sayiListesi = new List<int>();
            sayiListesi.Add(23);
            sayiListesi.Add(10);
            sayiListesi.Add(4);
            sayiListesi.Add(5);
            sayiListesi.Add(66);
            sayiListesi.Add(32);
            sayiListesi.Add(3);

            List<string> renkListesi = new List<string>();
            renkListesi.Add("Kırmızı");
            renkListesi.Add("Mavi");
            renkListesi.Add("Sarı");
            renkListesi.Add("Turuncu");
            renkListesi.Add("Yeşil");


            Console.WriteLine(renkListesi.Count);
            Console.WriteLine(sayiListesi.Count);

            foreach (var item in sayiListesi)
                Console.WriteLine(item);

            foreach (var item in renkListesi)
                Console.WriteLine(item);

            sayiListesi.ForEach(sayi => Console.WriteLine(sayi));
            renkListesi.ForEach(renk => Console.WriteLine(renk));

            sayiListesi.Remove(4);
            renkListesi.Remove("Sarı");

            sayiListesi.ForEach(sayi => Console.WriteLine(sayi));
            renkListesi.ForEach(renk => Console.WriteLine(renk));

            sayiListesi.RemoveAt(0);
            renkListesi.RemoveAt(1);

            sayiListesi.ForEach(sayi => Console.WriteLine(sayi));
            renkListesi.ForEach(renk => Console.WriteLine(renk));

            if (sayiListesi.Contains(66))
                Console.WriteLine("Dizi içerisinde 66 bulundu");

            Console.WriteLine(renkListesi.BinarySearch("Yeşil"));

            string[] hayvanlar = { "kedi", "köpek", "kuş" };

            List<string> hayvanListesi = new List<string>(hayvanlar);

            hayvanListesi.Clear();

            List<Kullanici> kullaniciListesi = new List<Kullanici>();
            Kullanici kullanici1 = new Kullanici();
            kullanici1.Isim = "Ayşe";
            kullanici1.Soyisim = "Türk";
            kullanici1.Yas = 12;

            Kullanici kullanici2 = new Kullanici();
            kullanici2.Isim = "Şaziye";
            kullanici2.Soyisim = "Babacan";
            kullanici2.Yas = 34;

            kullaniciListesi.Add(kullanici1);
            kullaniciListesi.Add(kullanici2);

            List<Kullanici> yeniliste = new List<Kullanici>();

            yeniliste.Add(new Kullanici(){
                Isim = "Ali",
                Soyisim = "Baba",
                Yas = 55
            });

            foreach (var item in kullaniciListesi)
            {
                Console.WriteLine("Kullanıcı Adı : "+item.Isim);
                Console.WriteLine("Kullanıcı SoyAdı : "+item.Soyisim);
                Console.WriteLine("Kullanıcı Yaşı : "+item.Yas);
            }

            yeniliste.Clear();


        }
    }

    class Kullanici
    {
        private string isim;
        private string soyisim;
        private int yas;

        public string Isim { get => isim; set => isim = value; }
        public string Soyisim { get => soyisim; set => soyisim = value; }
        public int Yas { get => yas; set => yas = value; }

    }
}
