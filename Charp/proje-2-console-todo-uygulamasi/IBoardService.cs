using System;
using System.Collections.Generic;

namespace proje_2_console_todo_uygulamasi
{
    public interface IBoardService
    {
        List<Board> GetirTodos();
        List<Board> GetirInProgresses();
        List<Board> GetirDones();
        void TodoKartEkle(Card card);
        bool KartSil(string cardBaslik);
        bool BoardLineTasi(string cardBaslik,int line);

        Card GetCard(string cardBaslik);

    }
}