using System;

namespace diziler_array_sinifi_metodlari
{
    class Program
    {
        static void Main(string[] args)
        {
            //Sort 
            int[] sayiDizisi = {23,12,34,2,56,88,11,27};

            Console.WriteLine("******* sırasız dizi *********");
            foreach (var sayi in sayiDizisi)
            {
                Console.WriteLine(sayi);
            }

            Console.WriteLine("******* sıralı dizi *********");
            Array.Sort(sayiDizisi);
            foreach (var sayi in sayiDizisi)
            {
                Console.WriteLine(sayi);
            }

            //Clear
            Console.WriteLine("******* Array Clear *********");
            //sayıDizisi elemanlarını kullnarak 2. index ten itibaren 2 tane elemanı 0 lar.
            Array.Clear(sayiDizisi,2,2);
            foreach (var sayi in sayiDizisi)
            {
                Console.WriteLine(sayi);
            }

            //Reverse
            Console.WriteLine("******* Array Reverse *********");
            Array.Reverse(sayiDizisi);
            foreach (var sayi in sayiDizisi)
            {
                Console.WriteLine(sayi);
            }

            //Indexof
            Console.WriteLine("******* Array IndexOf *********");
            Console.WriteLine(Array.IndexOf(sayiDizisi,88));

            //Resize 
            Console.WriteLine("******* Array Resize *********");
            Array.Resize<int>(ref sayiDizisi,9);
            sayiDizisi[8]=99;
            foreach (var sayi in sayiDizisi)
            {
                Console.WriteLine(sayi);
            }

        }
    }
}
