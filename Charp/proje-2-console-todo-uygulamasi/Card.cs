using System;

namespace proje_2_console_todo_uygulamasi
{
    public class Card : IEntity
    {
        private static int idSayac = 0;
        public int Id { get; set; }
        public string Baslik { get; set; }
        public string Icerik { get; set; }
        public TeamMember TeamMember { get; set; }
        public BuyuklukEnum Buyukluk { get; set; }


        public Card()
        {
            Id=idSayac+1;
            idSayac++;
        }
    }

}