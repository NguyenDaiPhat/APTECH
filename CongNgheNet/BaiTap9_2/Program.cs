using System;
namespace Program
{
    class Program
    {
        static void Main(string[] agrs)
        {
            float bankinh = float.Parse(Console.ReadLine());
            Console.WriteLine("Chu vi hinh tron la {0}", 3.14 * 2 * bankinh);
            Console.WriteLine("Dien tich hinh tron la {0}", 3.14 * bankinh * bankinh);
            Console.WriteLine("Nhap 3 canh tam giac: ");
            float a = float.Parse(Console.ReadLine());
            float b = float.Parse(Console.ReadLine());
            float c = float.Parse(Console.ReadLine());
            if((a+b>c) && (a+c>b) && (b+c>a)) {
                float chuvi = (a + b + c) / 2;
                Console.WriteLine("Dien tich tam giac la: {0}", Math.Sqrt(chuvi*(chuvi-a)*(chuvi-b)*(chuvi-c)));
            }
            else Console.WriteLine("3 canh a, b, c khong thoa man canh tam giac");
            Console.ReadKey();
        }
    }
}