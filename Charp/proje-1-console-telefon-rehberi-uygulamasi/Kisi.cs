using System;

namespace proje_1_console_telefon_rehberi_uygulamasi
{
    public class Kisi : IEntity
    {
        public string Isim { get; set; }    
        public string Soyisim { get; set; }
        public int TelefonNo { get; set; }

        public string TamIsim { get=> Isim+" "+Soyisim; }

    }
}