using System;

namespace sinif_kavrami
{
    class Program
    {
        static void Main(string[] args)
        {
            Calisan calisan1 = new Calisan();
            calisan1.Ad = "Ömer";
            calisan1.Soyad = "Kutluay";
            calisan1.No = 23415634;
            calisan1.Departman = "İnsan Kaynakları";

            calisan1.CalisanBilgileri();

            Calisan calisan2 = new Calisan();
            calisan2.Ad = "Arda";
            calisan2.Soyad = "Deniz";
            calisan2.No = 23415634;
            calisan2.Departman = "Satın Alma";

            calisan2.CalisanBilgileri();


        }
    }
    class Calisan
    {
        public string Ad;
        public string Soyad;
        public int No;
        public string Departman;

        public void CalisanBilgileri()
        {
            Console.WriteLine("Çalışanın adı : {0}", Ad);
            Console.WriteLine("Çalışanın soyadı : {0}", Soyad);
            Console.WriteLine("Çalışanın numarası : {0}", No);
            Console.WriteLine("Çalışanın departmanı : {0}", Departman);
        }
    }
}
