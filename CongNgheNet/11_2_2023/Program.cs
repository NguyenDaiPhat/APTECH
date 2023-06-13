using System;

namespace Hello
{
    class Program
    {
        static void Main(string[] args)
        {
            // Console.Write("Nhap so may tinh can mua: ");
            // int soMay = Int32.Parse(Console.ReadLine());
            // Console.Write("So tien phai tra la: ");
            // if(soMay <5){
            //     Console.WriteLine("{0}$", soMay*450);
            // }
            // else{
            //     Console.WriteLine("{0}$", soMay * 500);
            // }
            // Console.ReadKey();
            // int n;
            // Console.Write("Nhap so de liet ke bang cuu chuong: ");
            // n = Int32.Parse(Console.ReadLine());
            // for(int i = 1; i<= 10; i++){
            //     Console.WriteLine("{0}*{1}={2}", n, i, n * i);
            // }
            Console.WriteLine("Nhap so phan tu mang: ");
            int n = Int32.Parse(Console.ReadLine());
            int[] A = new int[n];
            for (int i = 0; i < n; i++)
            {
                A[i] = Int32.Parse(Console.ReadLine());
            }
            for (int i = 0; i < n - 1; i++)
                for (int j = i + 1; j < n; j++)
                    if (A[i] > A[j])
                    {
                        int tg = A[i];
                        A[i] = A[j];
                        A[j] = tg;
                    }
            for (int i = 0; i < n; i++)
            {
                Console.Write(A[i] + " ");
            }
        }
    }
}