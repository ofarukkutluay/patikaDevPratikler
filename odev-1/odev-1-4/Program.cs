using System;

namespace odev_1_4
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Cümle giriniz: ");
            string cumle = Console.ReadLine();

            Console.WriteLine("Cümledeki harf sayısı : " + cumle.Replace(" ","").Length);
            Console.WriteLine("Cümledek kelime sayısı : "+ cumle.Split(" ").Length);
            
        }
    }
}
