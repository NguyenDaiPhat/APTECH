using System;
namespace OnlineBookShop
{
    namespace BookShop
    {
        interface IStorage
        {
            public int Count { get; set; }
            public Book this[int index] { get; set; }
            public void AddANewBook();
            public void RemoveABook(string id);
            public int IsABook(string id);
        }
        class Storage : IStorage
        {
            private int _Count = 0;
            private Book[] BookStore = new Book[100];
            public Book this[int index]
            {
                get { return BookStore[index]; }
                set { BookStore[index] = value; }
            }
            public int Count
            {
                get { return _Count; }
                set { _Count = value; }
            }
            public void AddANewBook()
            {
                // System.Console.WriteLine("Please input a new book: ");
                Book book = new Book();
                System.Console.Write("Name: ");
                book.Name = Console.ReadLine();
                System.Console.Write("AuthorName: ");
                book.AuthorName = Console.ReadLine();
                System.Console.Write("Subject: ");
                book.Subject = Console.ReadLine();
                System.Console.Write("BuyingPrice: ");
                book.BuyingPrice = double.Parse(Console.ReadLine());
                // System.Console.Write("SellingPrice: ");
                // book.SellingPrice = double.Parse(Console.ReadLine());
                book.SetDetail(book.Name, book.AuthorName, book.Subject, book.BuyingPrice);
                BookStore[Count] = book;
                Count++;
            }
            public void RemoveABook(string id)
            {
                for (int i = 0; i < Count; i++)
                {
                    if (id == BookStore[i].ID)
                    {
                        for (int j = i; j < Count - 1; j++)
                        {
                            BookStore[j] = BookStore[j + 1];
                        }
                        Count--;
                    }
                }
            }
            public int IsABook(string id)
            {
                for (int i = 0; i < Count; i++)
                {
                    if (id == BookStore[i].ID) return i;
                }
                return -1;
            }
            public Storage()
            {
                Count = 0;
                Book[] BookStore = new Book[100];
            }
        }
        class OnlineShopBook
        {
            Storage BookStorage = new Storage();
            public double profits = 0;
            public void ImportBook()
            {
                System.Console.Write("Nhap so sach can them: ");
                int n = Int32.Parse(Console.ReadLine());
                int m = BookStorage.Count + 1;
                for (int i = 0; i < n; i++)
                {
                    System.Console.WriteLine($"Nhap thong tin sach thu {i+m}: ");
                    BookStorage.AddANewBook();
                    // BookStorage[i].SetDetail();
                }
            }
            public void ShowDetail()
            {
                for (int i = 0; i < BookStorage.Count; i++)
                {
                    BookStorage[i].ShowDetail();
                }
            }
            public void Show()
            {
                for (int i = 0; i < BookStorage.Count; i++)
                {
                    Book book = BookStorage[i];
                    System.Console.WriteLine($"Id: {book.ID}, Name: {book.Name}, AuthorName: {book.AuthorName}, Subject: {book.Subject}, SellingPrice: {book.SellingPrice}");
                }
            }
            public void SellABook()
            {
                Show();
                System.Console.Write("Please input id book for buy: ");
                string id = Console.ReadLine();
                int index = BookStorage.IsABook(id);
                if (index != -1)
                {
                    // System.Console.WriteLine(index);
                    System.Console.WriteLine("Book Instance, buy now!!!");
                    profits += BookStorage[index].SellingPrice - BookStorage[index].BuyingPrice;
                    BookStorage.RemoveABook(id);
                }
                else System.Console.WriteLine("Out of Books");
            }
            public void ChangeSellingPrice()
            {
                ShowDetail();
                System.Console.Write("Please input id book for change price: ");
                string id = Console.ReadLine();
                int indexx = BookStorage.IsABook(id);
                if (indexx != -1)
                {
                    System.Console.WriteLine("Book Instance, Change price book now!!!");
                    System.Console.Write("Please input price book for change: ");
                    double newSellingPrice = double.Parse(Console.ReadLine());
                    BookStorage[indexx].SetSellingPrice(newSellingPrice);
                }
                else System.Console.WriteLine("There is no book with this name.");
            }
        }
    }
}
