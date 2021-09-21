using System;

namespace hata_yonetimi
{
    class Program
    {
        static void Main(string[] args)
        {
            try
            {
                Console.WriteLine("Bir sayı Giriniz: ");
                int sayi = Convert.ToInt32(Console.ReadLine());
                Console.WriteLine("Girmiş oldunuğuz sayi: " + sayi);
            }
            catch (Exception ex)
            {
                Console.WriteLine("Hata: "+ ex.Message.ToString());
            }
            finally
            {
                Console.WriteLine("İşlem Tamamdır!");
            }

            try
            {
                 //int a = int.Parse(null);
                 //int a = int.Parse("test");
                 int a = int.Parse("-2000000000000000000000000000");
            }
            catch (ArgumentNullException ex)
            {
                Console.WriteLine("Boş Değer girdiniz!");
                Console.WriteLine(ex);
            }catch(FormatException ex){
                Console.WriteLine("Veri tipi uygun değil!");
                Console.WriteLine(ex);
            }catch(OverflowException ex){
                Console.WriteLine("Çok büüyük yada çok küçük bir değer grdiniz!");
                Console.WriteLine(ex);
            }

        }
    }
}
