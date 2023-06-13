using System;

namespace Hello
{
    class Program
    {
        static bool SoChinhPhuong(int n){
            if(Math.Sqrt(n) == Math.Round(Math.Sqrt(n)))
                return true;
            return false;
        }
        static void Main(string[] args)
        {
            // bai1
            Console.Write("Nhap nam: ");
            int namNhuan = Int32.Parse(Console.ReadLine());
            if (namNhuan % 400 == 0 || (namNhuan % 4 == 0 && namNhuan % 100 != 0))
            {
                Console.WriteLine("Nam {0} la nam nhuan", namNhuan);
            }
            else Console.WriteLine("Nam {0} khong phai la nam nhuan", namNhuan);
            //bai2
            Console.Write("Nhap so nguyen duong: ");
            string number = Console.ReadLine();
            if(number.Length == 3){
                for (int i = 0; i < number.Length; i++)
                {
                    switch (number[i])
                    {
                        case '0':
                            Console.Write("Khong ");
                            break;
                        case '1':
                            Console.Write("Mot ");
                            break;
                        case '2':
                            Console.Write("Hai ");
                            break;
                        case '3':
                            Console.Write("Ba ");
                            break;
                        case '4':
                            Console.Write("Bon ");
                            break;
                        case '5':
                            Console.Write("Nam ");
                            break;
                        case '6':
                            Console.Write("Sau ");
                            break;
                        case '7':
                            Console.Write("Bay ");
                            break;
                        case '8':
                            Console.Write("Tam ");
                            break;
                        case '9':
                            Console.Write("Chin ");
                            break;
                    }
                }
            }    
            Console.WriteLine();

            //bai3
            int n;
            do
            {
                Console.Write("Nhap so phan tu mang: ");
                n = Int32.Parse(Console.ReadLine());
            } while (n < 0);
            int[] A = new int[n];
            Console.Write("Nhap cac phan tu mang: ");
            for (int i = 0; i < n; i++)
            {
                A[i] = Int32.Parse(Console.ReadLine());
            }
            Console.WriteLine("Cac so trong mang la: ");
            for (int i = 0; i < n; i++)
            {
                Console.Write(A[i] + " ");
            }
            Console.WriteLine();
            for (int i = 0; i < n - 1; i++)
                for (int j = i + 1; j < n; j++)
                    if (A[i] > A[j])
                    {
                        int tg = A[i];
                        A[i] = A[j];
                        A[j] = tg;
                    }
            Console.Write("Mang sau khi sap xep: ");
            for (int i = 0; i < n; i++)
            {
                Console.Write(A[i] + " ");
            }
            Console.WriteLine();
            Console.Write("Cac so chinh phuong trong mang la: ");
            for (int i = 0; i < n; i++){
                if(SoChinhPhuong(A[i]))Console.Write(A[i] + " ");
            }
            Console.ReadKey();
        }
    }
}