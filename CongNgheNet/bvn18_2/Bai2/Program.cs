using System;
namespace Bai2_18_2
{
    class Program
    {
        static void Menu()
        {
            System.Console.WriteLine("1. Insert new student");
            System.Console.WriteLine("2. View list of students");
            System.Console.WriteLine("3. Search students");
            System.Console.WriteLine("4. Exit.");
            System.Console.Write("Choose: ");
        }
        static void Main()
        {
            Management management = new Management();
            management.init();
            // Management management = new Management();
            while (true)
            {
                Menu();
                var Choose = System.Console.ReadLine();
                switch (Choose)
                {
                    case "1":
                        management.AddStudent();
                        break;
                    case "2":
                        management.Display();
                        break;
                    case "3":
                        management.Search();
                        break;
                    case "4":
                        return;
                }
            }
        }
    }
}