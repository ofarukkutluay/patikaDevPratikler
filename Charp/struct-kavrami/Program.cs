using System;

namespace struct_kavrami
{
    class Program
    {
        static void Main(string[] args)
        {
            Dikdortgen dikdortgen = new Dikdortgen();
            //dikdortgen.KisaKenar = 3;
            //dikdortgen.UzunKenar = 4;
            Console.WriteLine("CLass Alan hesabı : {0}", dikdortgen.AlanHesapla());

            Dikdortgen_Struct dikdortgen_struct;
            dikdortgen_struct.KisaKenar = 5;
            dikdortgen_struct.UzunKenar = 4;
            Console.WriteLine("CLass Alan hesabı : {0}", dikdortgen_struct.AlanHesapla());

        }
    }

    class Dikdortgen
    {
        public int KisaKenar;
        public int UzunKenar;

        public Dikdortgen(){
            KisaKenar=3;
            UzunKenar=4;
        }

        public long AlanHesapla()
        {
            return this.KisaKenar * this.UzunKenar;
        }
    }

    struct Dikdortgen_Struct
    {
        public int KisaKenar;
        public int UzunKenar;

        public Dikdortgen_Struct(int kisaKenar, int uzunKenar)
        {
            KisaKenar = kisaKenar;
            UzunKenar = uzunKenar;
        }

        public long AlanHesapla()
        {
            return this.KisaKenar * this.UzunKenar;
        }
    }
}
