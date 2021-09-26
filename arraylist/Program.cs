using System;
using System.Collections;
using System.Collections.Generic;

namespace arraylist
{
    class Program
    {
        static void Main(string[] args)
        {
            ArrayList liste = new ArrayList();
            //liste.Add("Ayşe");
            //liste.Add(4);
            //liste.Add(true);
            //liste.Add('A');

            //Console.WriteLine(liste[1]);

            foreach (var item in liste)
                Console.WriteLine(item);

            Console.WriteLine("*******AddRange*********");
            //string[] renkler = { "kırmızı", "mavi", "sarı", "yeşil" };
            List<int> sayilar = new List<int>() { 1, 2, 3, 4, 5, 67, 99 };
            //liste.AddRange(renkler);
            liste.AddRange(sayilar);

            foreach (var item in liste)
                Console.WriteLine(item);

            Console.WriteLine("******* sort *********");
            liste.Sort();

            foreach (var item in liste)
                Console.WriteLine(item);

            Console.WriteLine("******** binary search *********");
            Console.WriteLine(liste.BinarySearch(5));

            Console.WriteLine("******** reverse ***********");
            liste.Reverse();

            foreach (var item in liste)
                Console.WriteLine(item);

            Console.WriteLine("******** clear ***********");
            liste.Clear();

            foreach (var item in liste)
                Console.WriteLine(item);



        }
    }
}
