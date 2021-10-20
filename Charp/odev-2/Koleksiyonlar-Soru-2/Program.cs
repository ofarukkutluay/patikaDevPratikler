using System;
using System.Collections;

namespace Koleksiyonlar_Soru_2
{
    class Program
    {
        static void Main(string[] args)
        {
            int arraySize = 20;
            int[] sayilar = new int[arraySize];

            Console.WriteLine($"Sırasıyla {arraySize} adet pozitif sayı giriniz! ");
            int n = 0;
            while (n < arraySize)
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

                sayilar[n] = number;
                n++;
            }
            Array.Sort(sayilar);
            int[] ilkUcSayi = new int[3];
            for (int i = 0; i < 3; i++)
                ilkUcSayi[i] = sayilar[i];

            int[] sonUcSayi = new int[3];
            for (int i = arraySize - 1; i > arraySize - 4; i--)
                sonUcSayi[arraySize - 1 - i] = sayilar[i];

            int ilkUcSayiTop = 0;
            int sonUcSayiTop = 0;

            for (int i = 0; i < 3; i++)
            {
                ilkUcSayiTop += ilkUcSayi[i];
                sonUcSayiTop += sonUcSayi[i];
            }

            int ilkUcSayiOrt = ilkUcSayiTop / 3;
            int sonUcSayiOrt = sonUcSayiTop / 3;
            Console.WriteLine("Girilen en küçük üç sayının ortalaması : " + ilkUcSayiOrt);
            Console.WriteLine("Girilen en büyük üç sayının ortalaması : " + sonUcSayiOrt);
            Console.WriteLine("İki ortalamanın toplamı : " + ilkUcSayiOrt + sonUcSayiOrt);


        }
    }
}
