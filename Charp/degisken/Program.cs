﻿using System;

namespace degisken
{
    class Program
    {
        static void Main(string[] args)
        {

            int deger = 2;
            string degisken = null;

            byte b = 5;
            sbyte c = 5;

            short s = 5;
            ushort us = 5;

            Int16 i16 = 2;
            int i = 2;
            Int32 i32 = 2;
            Int64 i64 = 2;

            uint ui = 2;
            long l = 4;
            ulong ul = 4;

            float f = 5;
            double d = 5;
            decimal de = 5;

            char ch = '2';
            string str = "Ömer";

            bool b1 = true;
            bool b2 = false;

            DateTime dt = DateTime.Now;

            Console.WriteLine(dt);

            object o1 = "x";
            object o2 = 'y';
            object o3 = 4;
            object o4 = 4.3;

            string str1 = string.Empty;
            str1 = "Ömer Kutluay";
            string ad = "Ömer";
            string soyad = "Kutluay";
            string tamisim = ad + " " + soyad;

            int integer1 = 5;
            int integer2 = 3;
            int integer3 = integer1 * integer2;

            bool bool1 = 10 < 2;


            string str20 = "20";
            int int20 = 20;

            string yeniDeger = str20 + int20.ToString();

            int int21 = int20+ Convert.ToInt32(str20);

            int int22 = int20 + int.Parse(str20);

            string datetime = DateTime.Now.ToString("dd.MM.yyyy");

            string datetime2 = DateTime.Now.ToString("dd/MM/yyyy");

            string datetime3 = DateTime.Now.ToString("HH:mm");





            Console.WriteLine(datetime);


        }
    }
}
