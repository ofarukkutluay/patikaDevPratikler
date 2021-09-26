using System;

namespace odev_1_1
{
    class Program
    {
        static void Main(string[] args)
        {
            int n;
            Console.Write("Kaç sayı gireceksiniz? : ");
            n = int.Parse(Console.ReadLine());


            int[] sayilar = new int[n];
            for (int i = 0; i < n; i++)
            {
                Console.Write("{0}. pozitif sayıyı giriniz : ", i + 1);
                int sayi = int.Parse(Console.ReadLine());
                sayilar[i] = sayi;
            }

            string ciftSayilar = "";
            foreach (int sayi in sayilar)
            {
                if (sayi % 2 == 0)
                {
                    ciftSayilar = ciftSayilar + " " + sayi;
                }

            }


            Console.Write("Çift sayılar :" + ciftSayilar);


        }
    }
}
