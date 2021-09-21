using System;

namespace donguler_while_foreach
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Bir sayı giriniz: ");
            int sayac = 1;
            int sayi = int.Parse(Console.ReadLine());
            int toplam = 0;
            while (sayac<=sayi)
            {
                 toplam+=sayac;
                 sayac++;
            }
            Console.WriteLine(toplam/sayac);
            

            char character = 'a';
            while (character<'z')
            {
                 Console.Write(character);
                 character++;
            }

            string[] arabalar = {"BMW","Audi","Mercedes","Renault","Fiat"};

            foreach (var araba in arabalar)
            {
                Console.WriteLine(araba);
            }

        }
    }
}
