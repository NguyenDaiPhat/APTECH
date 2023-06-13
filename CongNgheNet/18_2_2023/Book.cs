using System;
namespace Programs
{
    class Book : IBook
    {
        public int Id;
        public string Name;
        public string PublishDate;
        public string Author;
        public string Language;
        public float AveragePrice;

        public void Display()
        {
            System.Console.WriteLine($"Name: {Name}, PublishDate: {PublishDate}, Author: {Author}, Language: {Language}, AveragePrice: {AveragePrice}");
        }
        public int[] PriceList = new int[5];
        public void Calculate()
        {
            AveragePrice = 0;
            for (int i = 0; i < 5; i++)
            {
                AveragePrice += PriceList[i];
            }
            AveragePrice /= 5;
        }

        public void addBook(int Id)
        {
            // Book book = new Book();
            this.Id = Id;
            System.Console.Write("Nhap name: ");
            Name = System.Console.ReadLine();
            System.Console.Write("Nhap publishdate: ");
            PublishDate = System.Console.ReadLine();
            System.Console.Write("Nhap author: ");
            Author = System.Console.ReadLine();
            System.Console.Write("Nhap language: ");
            Language = System.Console.ReadLine();
            System.Console.WriteLine("Nhap five price: ");
            for (int i = 0; i < 5; i++)
            {
                PriceList[i] = int.Parse(System.Console.ReadLine());
            }
            // return book;
        }
    }
}