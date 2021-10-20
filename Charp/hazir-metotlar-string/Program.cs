using System;

namespace hazir_metotlar_string
{
    class Program
    {
        static void Main(string[] args)
        {
            string degisken = "Dersimiz Csharp, Hoşgeldiniz!";
            string degisken2 = "Dersimiz Csharp";

            Console.WriteLine(degisken.Length);

            Console.WriteLine(degisken.ToUpper());
            Console.WriteLine(degisken.ToLower());

            //Concat - ekleme yapıyoor;
            Console.WriteLine(String.Concat(degisken,"Merhaba!"));

            //Compare CompareTo- Karşılaştırma
            Console.WriteLine(degisken.CompareTo(degisken2));
            Console.WriteLine(String.Compare(degisken,degisken2,true));
            Console.WriteLine(String.Compare(degisken,degisken2,false));

            //Contains - varmı?
            Console.WriteLine(degisken.Contains(degisken2));
            Console.WriteLine(degisken.EndsWith("Hoşgeldiniz!"));
            Console.WriteLine(degisken.StartsWith("Merhaba"));

            //IndexOf - kaçıncı indexte
            Console.WriteLine(degisken.IndexOf("Csharp"));

            //Insert
            Console.WriteLine(degisken.Insert(0,degisken2));
            
            //Padleft padRight
            Console.WriteLine(degisken + degisken2.PadLeft(30));
            Console.WriteLine(degisken + degisken2.PadLeft(30,'*'));
            Console.WriteLine(degisken.PadRight(30) + degisken2);
            Console.WriteLine(degisken.PadRight(30,'-') + degisken2);

            //Remove
            Console.WriteLine(degisken.Remove(5,3));
            Console.WriteLine(degisken.Remove(10));
            Console.WriteLine(degisken.Remove(0,1));

            //Replace 
            Console.WriteLine(degisken.Replace(",","-"));

            //Split 
            Console.WriteLine(degisken.Split(' ')[1]);

            //Substring
            Console.WriteLine(degisken.Substring(4));
            Console.WriteLine(degisken.Substring(4,6));
            


        }
    }
}
