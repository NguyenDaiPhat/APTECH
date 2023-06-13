using System;
namespace Programs
{
    class Management
    {
        private int id = 0;

        List<Book> bookLists;
        public void init()
        {
            bookLists = new List<Book>();
        }
        public void addBook()
        {
            Book book = new Book();
            book.addBook(++id);
            bookLists.Add(book);
        }
        public void Display()
        {
            for (int i = 0; i < bookLists.Count(); i++)
            {
                bookLists[i].Calculate();
                bookLists[i].Display();
            }
        }

    }
}