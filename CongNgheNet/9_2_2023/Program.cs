using System;

namespace bai1
{
    class Program
    {
        static void Main(string[] args)
        {
            string name, date;
            int age;
            name = Console.ReadLine();
            age = Int32.Parse(Console.ReadLine()) ;
            date = Console.ReadLine();
            Console.WriteLine(name + " " + age + " " + date);
            int a = 1, b = 2;
            Console.WriteLine("{0} +{1}",a,b);
        }
    }

}