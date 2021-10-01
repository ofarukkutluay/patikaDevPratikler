using System;
using System.Collections.Generic;

namespace proje_2_console_todo_uygulamasi
{
    public class TeamRepository
    {
        private static List<TeamMember> _teamMembers;

        static TeamRepository()
        {
            _teamMembers = new List<TeamMember>(){
                new TeamMember(){Name="Ömer Kutluay"},
                new TeamMember(){Name="Ahmet Yılmaz"},
                new TeamMember(){Name="Ali Koç"},
                new TeamMember(){Name="Ayşe Sipahioğlu"},
                new TeamMember(){Name="Kamile Niyazi"},
            };
        }

        public TeamMember GetTeamMember(int id){
            TeamMember teamMember = _teamMembers.Find(tm => tm.Id == id);
            if (teamMember==null)
            {
                Console.WriteLine("Takım üyesi Bulunamadı!");
            }
            return teamMember;
        }




    }
}