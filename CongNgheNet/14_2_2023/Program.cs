using System;
namespace Programs
{
    class Product
    {
        public string Name;
        public string Description;
        public double Price;
        public int[] rate;
        public void ViewInfo()
        {
            Console.WriteLine($"Name: {Name}, price: {Price}, description: {Description}");
        }
    }
    class Shop
    {
        public void CheckPrice(ref double n)
        {
            while (n <= 0 || n > 100)
            {
                Console.Write("Enter price again: ");
                n = double.Parse(Console.ReadLine());
            }
        }
        List<Product> productList = new List<Product>();
        public void AddProduct(int n)
        {
            for (int i = 0; i < n; i++)
            {
                Product product = new Product();
                Console.Write("Name: ");
                product.Name = Console.ReadLine();
                Console.Write("Description: ");
                product.Description = Console.ReadLine();
                Console.Write("Price: ");
                product.Price = double.Parse(Console.ReadLine());
                CheckPrice(ref product.Price);
                productList.Add(product);
            }
        }
        public void SearchProduct(double n, double m)
        {
            Console.WriteLine("Products with prices from Price1 to Price2: ");
            foreach (Product p in productList)
            {
                if (p.Price > n && p.Price < m) p.ViewInfo();
            }
        }
    }
    class Program
    {
        static void CheckChoose(ref int n)
        {
            while (n < 1 || n > 4)
            {
                Console.Write("Choose again (1->4): ");
                n = Int32.Parse(Console.ReadLine());
            }
        }
        static void Main(string[] agrs)
        {
            Console.WriteLine("PRODUCT MANAGEMENT SYSTEM");
            Console.WriteLine("   1. Add new product");
            Console.WriteLine("   2. Iterate product list");
            Console.WriteLine("   3. Search product");
            Console.WriteLine("   4. Exit");
            Shop shop = new Shop();
            while (true)
            {
                Console.Write("Choose (1->4): ");
                int choose = Int32.Parse(Console.ReadLine());
                CheckChoose(ref choose);
                switch (choose)
                {
                    case 1:
                        Console.Write("Enter the number of products to add: ");
                        int n = Int32.Parse(Console.ReadLine());
                        shop.AddProduct(n);
                        break;
                    case 2:
                        break;
                    case 3:
                        Console.WriteLine("Enter two number price: ");
                        Console.Write("Price1: ");
                        double a = double.Parse(Console.ReadLine());
                        shop.CheckPrice(ref a);
                        Console.Write("Price2: ");
                        double b = double.Parse(Console.ReadLine());
                        shop.CheckPrice(ref a);
                        shop.SearchProduct(a, b);
                        break;
                    case 4:
                        return;
                }
            }

        }
    }
}