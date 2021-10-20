using System;
using System.Collections.Generic;

namespace proje_2_console_todo_uygulamasi
{
    public class InMemBoardRepository : IBoardRepository
    {
        private static List<Board> _boards;

        static InMemBoardRepository()
        {
            TeamRepository teamRepository = new TeamRepository();
            _boards = new List<Board>(){
                new Board() { Todo = new Card() { Baslik = "İlk İş", Buyukluk = BuyuklukEnum.XS, Icerik = "İlk İş içeriği",TeamMember=teamRepository.GetTeamMember(1) } },
                new Board() { Todo = new Card() { Baslik = "İkinci İş", Buyukluk = BuyuklukEnum.L, Icerik = "İkinci İş içeriği",TeamMember=teamRepository.GetTeamMember(3) } },
                new Board() { InProgress = new Card() { Baslik = "Üçünçü İş", Buyukluk = BuyuklukEnum.M, Icerik = "Üçüncü İş içeriği",TeamMember=teamRepository.GetTeamMember(4) } }
            };
        }
        public List<Board> GetAll()
        {
            return _boards;
        }

        public bool Add(Board board)
        {
            _boards.Add(board);
            return true;
        }

        public bool Delete(Board board)
        {
            int result = _boards.RemoveAll(b => b == board);
            if (result < 0)
                return false;
            else
                return true;
        }

        public bool Update(Board board)
        {
            int index = _boards.IndexOf(board);

            if (index < 0)
                return false;

            _boards[index] = board;
            return true;
        }

        public Board GetCardBaslikBoard(string cardBaslik){
            Board board = _boards.Find(b => b.Todo.Baslik.ToLower() == cardBaslik.ToLower() || b.InProgress.Baslik.ToLower() == cardBaslik.ToLower() || b.Done.Baslik.ToLower() == cardBaslik.ToLower());
            return board;
        }

        public List<Board> GetCardBaslikBoards(string cardBaslik){
            List<Board> boards = _boards.FindAll(b => b.Todo.Baslik.ToLower() == cardBaslik.ToLower() || b.InProgress.Baslik.ToLower() == cardBaslik.ToLower() || b.Done.Baslik.ToLower() == cardBaslik.ToLower());
            return boards;
        }




    }
}