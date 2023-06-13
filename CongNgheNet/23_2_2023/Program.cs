using System;
namespace Delegate
{
    public delegate void SuKienNhapSo(int i);
    class InputNumber
    {
        public event SuKienNhapSo suKienNhapSo;
        public void NhapSo()
        {
            System.Console.WriteLine("Nhap so nguyen: ");
            int i = int.Parse(Console.ReadLine());
            // if(suKienNhapSo != null)
            //     suKienNhapSo.Invoke(i);
            suKienNhapSo?.Invoke(i);
        }
    }
    class ReceiveNumber
    {
        public ReceiveNumber(InputNumber inputNumber)
        {
            inputNumber.suKienNhapSo += TinhBinhPhuong;
        }
        // public void Sub(InputNumber inputNumber)
        // {
        //     inputNumber.suKienNhapSo += TinhBinhPhuong;
        // }
        public void TinhBinhPhuong(int i)
        {
            System.Console.WriteLine("Binh phuong cua {0} la: {1}", i, i * i);
        }
    }
    class Program
    {
        // public delegate void tinhtoan(int a, int b);
        // static void Add(int a, int b)
        // {
        //     System.Console.WriteLine($"Tong la: {a + b}");
        // }
        // static void Sub(int a, int b)
        // {
        //     System.Console.WriteLine($"Hieu la: {a - b}");
        // }
        static void Main()
        {
            // int a = 10;
            // int b = 10;
            // tinhtoan tinhtoan;
            // tinhtoan = Add;
            // tinhtoan += Sub;
            // tinhtoan -= Sub;
            // tinhtoan(a, b);
            InputNumber inputNumber = new InputNumber();
            ReceiveNumber receiveNumber = new ReceiveNumber(inputNumber);
            inputNumber.NhapSo();
        }
    }
}