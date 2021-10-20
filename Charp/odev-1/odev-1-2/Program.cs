using System;

namespace odev_1_2
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("Kaç sayı girceksiniz? : ");
            int n = Convert.ToInt32(Console.ReadLine());
            Console.Write("Eşit yada tam bölünen aranacak sayıyı giriniz : ");
            int m = Convert.ToInt32(Console.ReadLine());

            int[] numbers = new int[n];

            for (int i = 0; i < n; i++)
            {
                Console.Write("{0}. pozitif sayıyı giriniz : ", i + 1);
                int number = int.Parse(Console.ReadLine());
                numbers[i] = number;
            }

            string result = "";

            foreach (int number in numbers)
            {
                if (number%m==0 || number==m)
                {
                    result +=" "+number;
                }
            }

            Console.WriteLine($"Girdiğiniz sayılara göre {m}'ye tam bölünen yada eşit sayılar : {result}");
        }
    }
}
