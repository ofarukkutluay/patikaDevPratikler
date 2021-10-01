using System;
using System.Collections.Generic;

namespace proje_2_console_todo_uygulamasi
{
    public interface IBoardRepository
    {
        List<Board> GetAll();
        bool Add(Board board);
        bool Delete(Board board);
        bool Update(Board board);
        Board GetCardBaslikBoard(string cardBaslik);
        List<Board> GetCardBaslikBoards(string cardBaslik);
        
    }
}