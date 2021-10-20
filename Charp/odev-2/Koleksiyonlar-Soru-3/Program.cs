using System;
using System.Collections.Generic;

namespace Koleksiyonlar_Soru_3
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("Cümleyi giriniz : ");
            string cumle = Console.ReadLine();

            char[] sesliHarfler = {'a','e','ı','i','o','ö','u','ü'};
            char[] charCumle = cumle.ToCharArray();
            List<char> cumleSesliHarfleri = new List<char>();

            foreach (char c in sesliHarfler)
            {
                char[] ca = Array.FindAll(charCumle, cc => cc==c);
                cumleSesliHarfleri.AddRange(ca);
            }

            Console.Write("İçinde bulanan sesli harfler : ");
            cumleSesliHarfleri.ForEach(c=>Console.Write($"{c} "));
        }
    }
}
