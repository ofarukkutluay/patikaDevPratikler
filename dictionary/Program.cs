using System;
using System.Collections.Generic;

namespace dictionary
{
    class Program
    {
        static void Main(string[] args)
        {
            Dictionary<int,string> kullanicilar = new Dictionary<int, string>();

            kullanicilar.Add(10,"ayşe");
            kullanicilar.Add(23,"Özcan");
            kullanicilar.Add(24,"Ahmet");
            kullanicilar.Add(11,"selma");

            Console.WriteLine("****** elemanlara erişim ************");
            Console.WriteLine(kullanicilar[11]);
            foreach (var item in kullanicilar)
                Console.WriteLine(item);

            Console.WriteLine("********* contains **********");
            Console.WriteLine(kullanicilar.ContainsKey(23));
            Console.WriteLine(kullanicilar.ContainsValue("Selami"));

            Console.WriteLine("******** remove ***********");
            kullanicilar.Remove(11);
            foreach (var item in kullanicilar)
                Console.WriteLine(item.Value);

            Console.WriteLine("******** keys ***********");
            foreach (var item in kullanicilar.Keys)
                Console.WriteLine(item);

            Console.WriteLine("******** values ***********");
            foreach (var item in kullanicilar.Values)
                Console.WriteLine(item);



        }
    }
}
