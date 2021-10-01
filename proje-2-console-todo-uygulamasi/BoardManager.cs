using System;
using System.Collections.Generic;

namespace proje_2_console_todo_uygulamasi
{
    public class BoardManager : IBoardService
    {
        private readonly IBoardRepository _boardRepository;

        public BoardManager(IBoardRepository boardRepository)
        {
            TeamRepository teamRepository = new TeamRepository();
            _boardRepository = boardRepository;
        }

        public List<Board> GetirTodos()
        {
            List<Board> todoList = _boardRepository.GetAll().FindAll(b => b.Todo != null);
            return todoList;
        }

        public List<Board> GetirInProgresses()
        {
            List<Board> inProgressList = _boardRepository.GetAll().FindAll(b => b.InProgress != null);
            return inProgressList;
        }

        public List<Board> GetirDones()
        {
            List<Board> doneList = _boardRepository.GetAll().FindAll(b => b.Done != null);
            return doneList;
        }

        public void TodoKartEkle(Card card)
        {
            if (card.TeamMember == null)
                Console.WriteLine("Kayıt yapılamadı! Geçerli takım üyesini id iletiniz!");
            else if (card.Buyukluk == null || 1 > (int)card.Buyukluk || 5 < (int)card.Buyukluk)
                Console.WriteLine("Büyüklük en az 1, en yüksek 5 olarak belirtilmelidir!");
            else
            {
                Board board = new Board()
                {
                    Todo = card
                };
                _boardRepository.Add(board);
            }

        }

        public bool KartSil(string cardBaslik)
        {
            Board board = _boardRepository.GetCardBaslikBoard(cardBaslik);
            bool result = _boardRepository.Delete(board);
            if (result)
                Console.WriteLine("Kart silindi!");
            else
                Console.WriteLine("Kart bulunamadı!");

            return result;
        }

        public bool BoardLineTasi(string cardBaslik, int line)
        {
            Board board = _boardRepository.GetCardBaslikBoard(cardBaslik);
            Card card = GetCard(cardBaslik);

            _boardRepository.Delete(board);
            switch (line)
            {
                case 1:
                    return _boardRepository.Add(new Board() { Todo = card });
                case 2:
                    return _boardRepository.Add(new Board() { InProgress = card });
                case 3:
                    return _boardRepository.Add(new Board() { Done = card });
                default:
                    return false;
            }

        }

        public Card GetCard(string cardBaslik)
        {
            Board board = _boardRepository.GetCardBaslikBoard(cardBaslik);
            Card card = null;
            if (board != null)
            {
                if (board.Todo != null)
                    card = board.Todo;
                else if (board.InProgress != null)
                    card = board.InProgress;
                else
                    card = board.Done;
            }


            return card;
        }




    }
}