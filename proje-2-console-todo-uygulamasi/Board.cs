using System;
using System.Collections.Generic;

namespace proje_2_console_todo_uygulamasi
{
    public class Board : IEntity
    {
        public Board(){
            
        }
        public Card Todo { get; set; }
        public Card InProgress { get; set; }
        public Card Done { get; set; }

    }
}