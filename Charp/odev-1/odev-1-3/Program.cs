using System;

namespace odev_1_3
{
    class Program
    {
        static void Main(string[] args)
        {
            int n;
            Console.Write("Kaç kelime gireceksiniz? : ");
            n = int.Parse(Console.ReadLine());

            string[] kelimeler = new string[n];
            for (int i = 0; i < n; i++)
            {
                Console.Write("{0}. kelimeyi giriniz : ", i + 1);
                string kelime = Console.ReadLine();
                kelimeler[i] = kelime;
            }
            Array.Reverse(kelimeler);
            string tersten = string.Join(",",kelimeler);

            Console.WriteLine($"Sondan başa girdiğiniz kelimeler : {tersten}");
        }
    }
}
