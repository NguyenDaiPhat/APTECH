using System;
namespace OnlineBookShop
{
    namespace BookShop
    {
        class Program
        {
            static void Cach()
            {
                System.Console.WriteLine("-----------------------------------");
            }
            static void Menu()
            {
                Cach();
                System.Console.WriteLine("1.Admin");
                System.Console.WriteLine("2.Custom");
                System.Console.WriteLine("3.Exit");
            }
            static void Menu_Admin()
            {
                Cach();
                System.Console.WriteLine("1.Import book to the store");
                System.Console.WriteLine("2.Show the store in detail");
                System.Console.WriteLine("3.Change a book selling price");
                System.Console.WriteLine("4.Show profits");
                System.Console.WriteLine("5.Back");
            }
            static void Menu_Custom()
            {
                Cach();
                System.Console.WriteLine("1.Show all books of store");
                System.Console.WriteLine("2.Buy a book");
                System.Console.WriteLine("3.Back");
            }
            static void Choice()
            {
                System.Console.Write("Your choose: ");
            }
            static void Main(string[] agrs)
            {
                // Book theBook = new Book();///cau1
                // theBook.SetDetail("i", "ii", "triet", 10);///cau1

                // theBook.ShowDetail();   /// cau1
                                        ///cau234
                OnlineShopBook BookShop = new OnlineShopBook();
                while (true)
                {
                    Menu();
                    Choice();
                    int n = Int32.Parse(Console.ReadLine());
                    switch (n)
                    {
                        case 1:
                            while (true)
                            {
                                Menu_Admin();
                                Choice();
                                int m = Int32.Parse(Console.ReadLine());
                                switch (m)
                                {
                                    case 1:
                                        BookShop.ImportBook();
                                        break;
                                    case 2:
                                        BookShop.ShowDetail();
                                        break;
                                    case 3:
                                        BookShop.ChangeSellingPrice();
                                        break;
                                    case 4:
                                        System.Console.WriteLine($"Profits: {BookShop.profits}");
                                        break;
                                    case 5:
                                        break;
                                }
                                if (m == 5) break;
                            }
                            break;
                        case 2:
                            while (true)
                            {
                                Menu_Custom();
                                Choice();
                                int m = Int32.Parse(Console.ReadLine());
                                switch (m)
                                {
                                    case 1:
                                        BookShop.Show();
                                        break;
                                    case 2:
                                        BookShop.SellABook();
                                        break;
                                    case 3:
                                        break;
                                }
                                if (m == 3) break;
                            }
                            break;
                        case 3:
                            return;
                    }
                }
            }
        }
    }
}
