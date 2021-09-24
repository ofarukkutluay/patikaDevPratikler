using System;

namespace diziler
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] renkler = new string[5];

            string[] hayvanlar = {"kedi","köpek","kuş","MAYMUN"};

            int[] dizi;

            dizi = new int[5];

            renkler[0]= "Mavi";
            Console.WriteLine(hayvanlar[1]);
            dizi[3] = 10;

            Console.WriteLine(dizi[1]);
            Console.WriteLine(renkler[0]);


            Console.WriteLine("lütfen dizinin eleman sayısını giriniz: ");
            int diziUzunlugu = int.Parse(Console.ReadLine());
            int[] sayiDizisi = new int[diziUzunlugu];

            for (int i = 0; i  < diziUzunlugu; i ++)
            {
                Console.Write("Litfen {0} sayısı gisiniz",i+1);
                sayiDizisi[i] = int.Parse(Console.ReadLine());

            }

            int toplam = 0;
            foreach (var sayi in sayiDizisi)
            {
                toplam+=sayi;
            }

            Console.WriteLine("Ortalamam : "+ toplam/diziUzunlugu);


        }
    }
}
