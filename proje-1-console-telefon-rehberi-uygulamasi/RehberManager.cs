using System;

namespace proje_1_console_telefon_rehberi_uygulamasi
{
    public class RehberManager : IRehberService
    {
        IRehberDto _rehberDto;
        public RehberManager(IRehberDto rehberDto)
        {
            _rehberDto = rehberDto;
        }

        public void Ekle(Kisi kisi)
        {
            _rehberDto.RehberListesi.Add(kisi);
            Console.WriteLine("{0} rehbere eklendi!", kisi.TamIsim);
        }
        public void Sil(Kisi kisi)
        {
            _rehberDto.RehberListesi.Remove(kisi);
            Console.WriteLine("{0} rehberden silindi!", kisi.TamIsim);
        }
        public void Guncelle(Kisi kisi)
        {
            Kisi kisi1 = KisiAdiIleGetir(kisi.TamIsim);
            int index = _rehberDto.RehberListesi.IndexOf(kisi1);
            _rehberDto.RehberListesi.Insert(index, kisi);
            Console.WriteLine("{0} rehberden güncellendi!", kisi.TamIsim);
        }
        public void TumunuGetir(bool siralamaAZ = true)
        {
            if (siralamaAZ)
            {
                _rehberDto.RehberListesi.Sort(delegate (Kisi x, Kisi y)
                {
                    if (x.TamIsim == null && y.TamIsim == null) return 0;
                    else if (x.TamIsim == null) return -1;
                    else if (y.TamIsim == null) return 1;
                    else return x.TamIsim.CompareTo(y.TamIsim);
                });
            }
            else
                _rehberDto.RehberListesi.Reverse();

            Console.WriteLine("Telefon Rehberi");
            Console.WriteLine("**********************************************");

            foreach (Kisi item in _rehberDto.RehberListesi)
            {
                Console.WriteLine("İsim : " + item.Isim);
                Console.WriteLine("Soyisim : " + item.Soyisim);
                Console.WriteLine("Telefon Numarası : " + item.TelefonNo);
                Console.WriteLine("---------------");
            }
        }
        public Kisi KisiAdiIleGetir(string adSoyad)
        {
            Kisi kisi = _rehberDto.RehberListesi.Find(k => k.TamIsim.ToLower() == adSoyad.ToLower() || k.Soyisim.ToLower() == adSoyad.ToLower() || k.Isim.ToLower() == adSoyad.ToLower());
            return kisi;
        }

        public Kisi TelNoIleGetir(int number)
        {
            Kisi kisi = _rehberDto.RehberListesi.Find(k => k.TelefonNo == number);
            return kisi;
        }


    }
}