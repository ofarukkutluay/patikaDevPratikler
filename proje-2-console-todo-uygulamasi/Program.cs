using System;
using System.Collections.Generic;

namespace proje_2_console_todo_uygulamasi
{
    class Program
    {
        static IBoardService _boardService = new BoardManager(new InMemBoardRepository());

        static void Main(string[] args)
        {

            while (true)
            {
                int n = GirisEkrani();
                switch (n)
                {
                    case 1:
                        BoardListele();
                        continue;
                    case 2:
                        TodoKartEkle();
                        continue;
                    case 3:
                        KartSil();
                        continue;
                    case 4:
                        KartTasi();
                        continue;

                    default:
                        n=0;
                        continue;
                }
            }









        }

        static int GirisEkrani()
        {
            Console.WriteLine(@"Lütfen yapmak istediğiniz işlemi seçiniz :) 
  *******************************************
  (1) Board Listelemek
  (2) Board'a Kart Eklemek
  (3) Board'dan Kart Silmek
  (4) Kart Taşımak");
            Console.Write("Seçiminiz : ");
            return IntReadLineTryCatch();
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

        static void BoardListele()
        {
            Console.WriteLine(@"TODO Line
 ************************");
            List<Board> todoList = _boardService.GetirTodos();
            foreach (Board item in todoList)
            {
                Console.WriteLine(@" Başlık      : {0}
 İçerik      : {1}
 Atanan Kişi : {2}
 Büyüklük    : {3}
 ----", item.Todo.Baslik, item.Todo.Icerik, item.Todo.TeamMember.Name, item.Todo.Buyukluk);
            }

            Console.WriteLine(@"IN PROGRESS Line
************************");
            List<Board> inProgressList = _boardService.GetirInProgresses();
            foreach (Board item in inProgressList)
            {
                Console.WriteLine(@" Başlık      : {0}
 İçerik      : {1}
 Atanan Kişi : {2}
 Büyüklük    : {3}
 ----", item.InProgress.Baslik, item.InProgress.Icerik, item.InProgress.TeamMember.Name, item.InProgress.Buyukluk);
            }

            Console.WriteLine(@"DONE Line
************************");
            List<Board> doneList = _boardService.GetirDones();
            foreach (Board item in doneList)
            {
                Console.WriteLine(@" Başlık      : {0}
 İçerik      : {1}
 Atanan Kişi : {2}
 Büyüklük    : {3}
 ----", item.Done.Baslik, item.Done.Icerik, item.Done.TeamMember.Name, item.Done.Buyukluk);
            }
        }

        static void TodoKartEkle()
        {
            Console.Write("Başlık Giriniz                                  : ");
            string baslik = Console.ReadLine();
            Console.Write("İçerik Giriniz                                  : ");
            string icerik = Console.ReadLine();
            Console.Write("Büyüklük Seçiniz -> XS(1),S(2),M(3),L(4),XL(5)  : ");
            int buyukluk = IntReadLineTryCatch();
            Console.Write("Kişi Seçiniz                                    : ");
            int kisi = IntReadLineTryCatch();

            Card card = new Card()
            {
                Baslik = baslik,
                Icerik = icerik,
                Buyukluk = (BuyuklukEnum)buyukluk,
                TeamMember = new TeamRepository().GetTeamMember(kisi)
            };

            _boardService.TodoKartEkle(card);
        }

        static void KartSil()
        {
            while (true)
            {
                Console.Write(@"Öncelikle silmek istediğiniz kartı seçmeniz gerekiyor.
 Lütfen kart başlığını yazınız: ");
                string baslik = Console.ReadLine();
                bool result = _boardService.KartSil(baslik);
                if (result)
                    break;
                else
                {
                    bool aramaSecim = AramaBulunamadi();
                    if (aramaSecim)
                        continue;
                    else
                        break;
                }
            }

        }

        static void KartTasi(){
            while (true)
            {
                Console.Write(@"Öncelikle taşımak istediğiniz kartı seçmeniz gerekiyor.
 Lütfen kart başlığını yazınız: ");
                string baslik = Console.ReadLine();
                Card card = _boardService.GetCard(baslik);
                if (card==null)
                {
                    bool aramaSecim = AramaBulunamadi();
                    if (aramaSecim)
                        continue;
                    else
                        break;
                }
                Console.WriteLine(@"Bulunan Kart Bilgileri:
 **************************************
 Başlık      : {0}
 İçerik      : {1}
 Atanan Kişi : {2}
 Büyüklük    : {3}
 Line        : {4}

 Lütfen taşımak istediğiniz Line'ı seçiniz: 
 (1) TODO
 (2) IN PROGRESS
 (3) DONE",card.Baslik,card.Icerik,card.TeamMember.Name,card.Buyukluk);
                Console.Write("Seçiminiz : ");
                int line = IntReadLineTryCatch();
                bool result = _boardService.BoardLineTasi(baslik,line);
                if (result)
                    break;
                else
                {
                    Console.WriteLine("İşlem Başarısız oldu!");
                    continue;
                }
            }

        }

        static bool AramaBulunamadi()
        {
            Console.WriteLine(@"Aradığınız krtiterlere uygun kart board'da bulunamadı. Lütfen bir seçim yapınız.
 * Silmeyi sonlandırmak için : (1)
 * Yeniden denemek için : (2)");
            Console.Write("Seçiminiz : ");
            int s = IntReadLineTryCatch();
            if (s == 1)
                return false;
            else
                return true;
        }


    }
}
