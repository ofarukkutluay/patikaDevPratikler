using System;

namespace proje_1_console_telefon_rehberi_uygulamasi
{
    public interface IRehberService
    {
        void Ekle(Kisi kisi);
        void Sil(Kisi kisi);
        void Guncelle(Kisi kisi);
        void TumunuGetir(bool siralamaAZ);
        Kisi KisiAdiIleGetir(string adSoyad);
        Kisi TelNoIleGetir(int number);
        
    }
}