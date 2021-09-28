using System;
using System.Collections.Generic;

namespace proje_1_console_telefon_rehberi_uygulamasi
{
    public class RehberData : IRehberDto
    {
        private List<Kisi> rehberListesi;

        public RehberData()
        {
            RehberListesi = new List<Kisi>();
            RehberListesi.Add(new Kisi() { Isim = "Ömer", Soyisim = "Kutluay", TelefonNo = 12345678 });
            RehberListesi.Add(new Kisi() { Isim = "Ahmet", Soyisim = "Reis", TelefonNo = 34567223 });
            RehberListesi.Add(new Kisi() { Isim = "Ali", Soyisim = "Kurnaz", TelefonNo = 98765436 });
            RehberListesi.Add(new Kisi() { Isim = "Esin", Soyisim = "Yılmaz", TelefonNo = 76548395 });
            RehberListesi.Add(new Kisi() { Isim = "Selin", Soyisim = "Karakız", TelefonNo = 36408384 });
        }

        public List<Kisi> RehberListesi { get => rehberListesi; set => rehberListesi = value; }
    }
}