using System;

namespace proje_2_console_todo_uygulamasi
{
    public class TeamMember : IEntity
    {
        private static int idSayac = 0;
        public int Id { get; set; }
        public string Name { get; set; }

        public TeamMember(){
            Id=idSayac+1;
            idSayac++;
        }
    }
}