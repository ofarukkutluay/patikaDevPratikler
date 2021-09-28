using System;
using System.Collections.Generic;

namespace proje_1_console_telefon_rehberi_uygulamasi
{
    public interface IRehberDto
    {
        List<Kisi> RehberListesi { get; set; }
    }
}