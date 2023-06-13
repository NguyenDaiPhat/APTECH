using System;
namespace OnlineBookShop
{
    namespace BookShop
    {
        interface IBook
        {
            public string ID { get; set; }
            public string Name { get; set; }
            public string AuthorName { get; set; }
            public string Subject { get; set; }
            public double BuyingPrice { get; set; }
            public double SellingPrice { get; set; }
            public void ShowDetail();
            public void SetDetail(string name, string authorname, string subject, double buyingprice);
            public void SetSellingPrice(double newSellingPrice);
        }
        class Book : IBook
        {
            private static int _count = 0;
            private string _ID;
            private string _Name;
            private string _AuthorName;
            private string _Subject;
            private double _BuyingPrice;
            private double _SellingPrice;
            public void ShowDetail()
            {
                System.Console.WriteLine($"Id: {ID}, Name: {Name}, AuthorName: {AuthorName}, Subject: {Subject}, BuyingPrice: {BuyingPrice}, SellingPrice: {SellingPrice}");
            }
            public void SetDetail(string name, string authorname, string subject, double buyingPrice)
            {
                _Name = name;
                _AuthorName = authorname;
                _Subject = subject;
                _BuyingPrice = buyingPrice;
                _SellingPrice = buyingPrice * 1.3;
            }
            public void SetSellingPrice(double newSellingPrice)
            {
                _SellingPrice = newSellingPrice;
            }
            public Book()
            {
                _count++;
                if (_count < 10)
                    _ID = "B00" + _count;
                else if (_count < 100)
                    _ID = "B0" + _count;
                else if (_count < 1000)
                    _ID = "B" + _count;
            }
            public string ID
            {
                get
                {
                    return _ID;
                }
                set
                {
                    _ID = value;
                }
            }
            public string Name
            {
                get
                {
                    return _Name;
                }
                set
                {
                    _Name = value;
                }
            }
            public string AuthorName
            {
                get
                {
                    return _AuthorName;
                }
                set
                {
                    _AuthorName = value;
                }
            }
            public string Subject
            {
                get
                {
                    return _Subject;
                }
                set
                {
                    _Subject = value;
                }
            }
            public double BuyingPrice
            {
                get
                {
                    return _BuyingPrice;
                }
                set
                {
                    _BuyingPrice = value;
                }
            }
            public double SellingPrice
            {
                get
                {
                    return _SellingPrice;
                }
                set
                {
                    _SellingPrice = value;
                }
            }
        }
    }
}
