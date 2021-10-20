using System;

namespace proje_1_console_telefon_rehberi_uygulamasi
{
    class Program
    {

        static void Main(string[] args)
        {
            IRehberService rehberService = new RehberManager(new RehberData());
            int n;
            while (true)
            {

                n = GirisEkrani();
                switch (n)
                {
                    case 1:
                        Kisi kisi = KayıtEkrani();
                        rehberService.Ekle(kisi);
                        continue;
                    case 2:
                        Kisi silKisi = null;
                        while (silKisi == null)
                        {
                            string sorguCumlesi = SilmeEkrani();
                            silKisi = rehberService.KisiAdiIleGetir(sorguCumlesi);
                            if (silKisi == null)
                            {
                                bool resu = AramaBulunamadi();
                                if (resu)
                                    continue;
                                else
                                    break;
                            }
                            else
                            {
                                Console.WriteLine("{0} isimli kişi rehberden silinmek üzere, onaylıyor musunuz ?(y/n)", silKisi.TamIsim);
                                string yn = Console.ReadLine();
                                if (yn == "y")
                                {
                                    rehberService.Sil(silKisi);
                                }
                                continue;
                            }
                        }
                        continue;


                    case 3:
                        Kisi gunKisi = null;
                        while (gunKisi == null)
                        {
                            string sorgu = GuncellemeEkrani();
                            gunKisi = rehberService.KisiAdiIleGetir(sorgu);
                            if (gunKisi == null)
                            {
                                bool resul = AramaBulunamadi();
                                if (resul)
                                    continue;
                                else
                                    break;
                            }
                            else
                            {
                                Console.Write("{0} kişinin numarası {1}, değiştirmek için yeni numarayı giriniz : ", gunKisi.TamIsim, gunKisi.TelefonNo);
                                int newNumber = IntReadLineTryCatch();
                                gunKisi.TelefonNo = newNumber;
                                rehberService.Guncelle(gunKisi);
                                continue;
                            }

                        }
                        continue;

                    case 4:
                        rehberService.TumunuGetir(true);
                        continue;
                    case 5:
                        Console.WriteLine(@"Arama yapmak istediğiniz tipi seçiniz.
 **********************************************
 
 İsim veya soyisime göre arama yapmak için: (1)
 Telefon numarasına göre arama yapmak için: (2)");
                        Console.Write("Seçiminiz : ");
                        int secim = IntReadLineTryCatch();
                        Kisi araKisi = null;
                        if (secim == 1)
                        {

                            while (araKisi == null)
                            {
                                Console.Write("Lütfen aramak istediğiniz ad veya soyad bilgisi giriniz : ");
                                string adSoyad = Console.ReadLine();
                                araKisi = rehberService.KisiAdiIleGetir(adSoyad);
                                if (araKisi == null)
                                {
                                    bool result = AramaBulunamadi();
                                    if (result)
                                        continue;
                                    else
                                        break;
                                }
                                else
                                {
                                    Console.WriteLine("İsim : " + araKisi.Isim);
                                    Console.WriteLine("Soyisim : " + araKisi.Soyisim);
                                    Console.WriteLine("Telefon Numarası : " + araKisi.TelefonNo);
                                    Console.WriteLine("---------------");
                                }
                            }

                        }
                        else
                        {
                            while (araKisi == null)
                            {
                                Console.Write("Lütfen aramak istediğiniz telefon no bilgisi giriniz : ");
                                int telNo = IntReadLineTryCatch();

                                araKisi = rehberService.TelNoIleGetir(telNo);
                                if (araKisi == null)
                                {
                                    bool res = AramaBulunamadi();
                                    if (res)
                                        continue;
                                    else
                                        break;
                                }
                                else
                                {
                                    Console.WriteLine("İsim : " + araKisi.Isim);
                                    Console.WriteLine("Soyisim : " + araKisi.Soyisim);
                                    Console.WriteLine("Telefon Numarası : " + araKisi.TelefonNo);
                                    Console.WriteLine("---------------");
                                }

                            }
                        }
                        continue;
                    default:
                        n = 0;
                        Console.ReadLine();
                        continue;
                }
            }



        }

        static int GirisEkrani()
        {
            Console.WriteLine(@"-------------------------------------------------
Lütfen yapmak istediğiniz işlemi seçiniz :) 
*******************************************
(1) Yeni Numara Kaydetmek
(2) Varolan Numarayı Silmek
(3) Varolan Numarayı Güncelleme
(4) Rehberi Listelemek
(5) Rehberde Arama Yapmak");
            Console.Write("Seçiminiz : ");
            return IntReadLineTryCatch();
        }

        static Kisi KayıtEkrani()
        {
            Console.WriteLine("------Yeni Numara Kaydetmek--------");
            Kisi kisi = new Kisi();
            Console.Write("Lütfen isim giriniz             :");
            kisi.Isim = Console.ReadLine().Trim();
            Console.Write("Lütfen soyisim giriniz          :");
            kisi.Soyisim = Console.ReadLine().Trim();
            Console.Write("Lütfen telefon numarası giriniz :");
            kisi.TelefonNo = IntReadLineTryCatch();
            return kisi;
        }

        static string SilmeEkrani()
        {
            Console.WriteLine("------ Rehber Silme ---------");
            Console.Write("Lütfen numarasını silmek istediğiniz kişinin adını ya da soyadını giriniz :");
            string sorguCumlesi = Console.ReadLine();
            return sorguCumlesi;
        }

        static string GuncellemeEkrani()
        {
            Console.WriteLine("------ Rehber Güncelleme ---------");
            Console.Write("Lütfen numarasını güncellemek istediğiniz kişinin adını ya da soyadını giriniz :");
            string sorguCumlesi = Console.ReadLine();
            return sorguCumlesi;
        }

        static int IntReadLineTryCatch()
        {
            int sayi;
            try
            {
                sayi = Convert.ToInt32(Console.ReadLine());

            }
            catch (System.Exception)
            {
                sayi = 0;
                Console.WriteLine("Lütfen sayı giriniz!");
            }
            return sayi;
        }

        static bool AramaBulunamadi()
        {

            Console.WriteLine(@"Aradığınız krtiterlere uygun veri rehberde bulunamadı. Lütfen bir seçim yapınız.
  * Sonlandırmak için         : (1)
  * Yeniden denemek için      : (2)");
            Console.Write("Seçiminiz : ");
            int s = IntReadLineTryCatch();
            if (s == 1)
                return false;
            else
                return true;
        }

    }
}
