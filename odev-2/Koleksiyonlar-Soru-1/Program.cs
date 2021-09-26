using System;
using System.Collections;
using System.Collections.Generic;

namespace Koleksiyonlar_Soru_1
{
    class Program
    {
        static void Main(string[] args)
        {
            ArrayList asalSayilar = new ArrayList();
            ArrayList asalOlmayanSayilar = new ArrayList();

            Console.WriteLine("Sırasıyla 20 adet pozitif sayı giriniz : ");
            int n = 0;
            while (n < 20)
            {
                Console.Write($"{n + 1}. sayıyı giriniz : ");
                string sNumber = Console.ReadLine();
                int number;
                try
                {
                    number = Convert.ToInt32(sNumber);
                }
                catch (System.Exception)
                {
                    Console.WriteLine("Sayı dışında başka karakter girilemez! Tekrar deneyiniz...");
                    continue;
                }
                
                if (number < 0)
                {
                    Console.WriteLine("Negatif  sayı girilemez! Tekrar deneyiniz...");
                    continue;
                }
                bool asalMi = true;
                for (int i = 2; i < number; i++)
                {
                    if (number % i == 0 || number==1 || number==0)
                        asalMi = false;
                }
                if (asalMi)
                    asalSayilar.Add(number);
                else
                    asalOlmayanSayilar.Add(number);

                n++;
            }
            asalSayilar.Sort();
            asalSayilar.Reverse();
            asalOlmayanSayilar.Sort();
            asalOlmayanSayilar.Reverse();
            string asal = "";
            string notAsal = "";
            foreach (var item in asalSayilar)
                asal+=item.ToString()+" ";
            foreach (var item in asalOlmayanSayilar)
                notAsal+=item.ToString()+" ";

            Console.WriteLine("Asal girilenler sayılar : " + asal);
            Console.WriteLine("Asal olamayan girilenler sayılar : " + notAsal);

            Console.WriteLine("Asal girilen sayıların adeti : "+ asalSayilar.Count);
            Console.WriteLine("Asal olamayan girilen sayıların adeti : "+ asalOlmayanSayilar.Count);

            int asalTop = 0;
            int notAsalTop = 0;
            foreach (int item in asalSayilar)
                asalTop+=item;
            foreach (int item in asalOlmayanSayilar)
                notAsalTop+=item;

            Console.WriteLine("Asal sayıların ortalaması : "+ asalTop/asalSayilar.Count);
            Console.WriteLine("Asal olmayan sayıların ortalaması : "+ notAsalTop/asalOlmayanSayilar.Count);
        }
    }
}
