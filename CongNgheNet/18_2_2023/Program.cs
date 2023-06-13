using System;
namespace Programs
{
    class Program
    {
        static void Menu()
        {
            System.Console.WriteLine("1. Insert new book");
            // System.Console.WriteLine("2. View list of book");
            System.Console.WriteLine("3. Average Price");
            System.Console.WriteLine("4. Exit.");
            System.Console.Write("Choose: ");
        }
        static void Main()
        {
            int Choose;
            Management management = new Management();
            management.init();
            do
            {
                Menu();
                Choose = int.Parse(System.Console.ReadLine());
                switch (Choose)
                {
                    case 1:
                        management.addBook();
                        break;
                    // case 2:
                    //     break;
                    case 3:
                        management.Display();
                        break;
                    case 4:
                        return;
                }
            } while (true);
        }
    }
}