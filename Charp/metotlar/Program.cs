using System;

namespace metotlar
{
    class Program
    {
        static void Main(string[] args)
        {
            int a = 2;
            int b=3;

            Console.WriteLine(a+b);

            int sonuc = Topla(a,b);
            
            Metotlar ornek = new Metotlar();
            ornek.EkranaYazdir(sonuc.ToString());

            int sonuc2 = ornek.ArttırVeTopla(ref a,ref b);
            ornek.EkranaYazdir(sonuc2.ToString());
        }

        static int Topla(ref int deger1,ref int  deger2){
            return (deger1+deger2);
        }

        


    }

    class Metotlar{

        public void EkranaYazdir(string veri){
            Console.WriteLine(veri);
        }

        public int ArttırVeTopla(int deger1,int deger2){
            deger1+=1;
            deger2+=1;
            return deger1+deger2;
        }
    }
}
