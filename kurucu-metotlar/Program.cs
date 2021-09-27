using System;

namespace kurucu_metotlar
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

            Calisan calisan3 = new Calisan("Özlem","Kutlu",12345678,"Satış Destek");
            calisan3.CalisanBilgileri();

            Calisan calisan4 = new Calisan("Fatma","Kutlu");
            calisan4.CalisanBilgileri();


        }
    }
    class Calisan
    {
        public string Ad;
        public string Soyad;
        public int No;
        public string Departman;

        public Calisan(){

        }

        public Calisan(string ad,string soyad,int no,string depatman){
            this.Ad = ad;
            this.Soyad = soyad;
            this.No = no;
            this.Departman = depatman;
        }

        public Calisan(string ad,string soyad){
            this.Ad = ad;
            this.Soyad = soyad;
            
        }

        public void CalisanBilgileri()
        {
            Console.WriteLine("Çalışanın adı : {0}", Ad);
            Console.WriteLine("Çalışanın soyadı : {0}", Soyad);
            Console.WriteLine("Çalışanın numarası : {0}", No);
            Console.WriteLine("Çalışanın departmanı : {0}", Departman);
        }
    }
}

