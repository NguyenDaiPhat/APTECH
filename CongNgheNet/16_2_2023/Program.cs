using System;

namespace Programs
{
    class Program
    {
        static void Menu()
        {
            System.Console.WriteLine();
            System.Console.WriteLine("-----------------------------------------");
            Console.WriteLine("Them nhan vien (nhap: ae) ");
            Console.WriteLine("Them khach hang (nhap: ac)");
            Console.WriteLine("Hien thi thong tin nhan vien (nhap: dae)");
            Console.WriteLine("Hien thi thong tin khach hang (nhap: dac)");
            Console.WriteLine("Thoat chuong trinh (nhap: ea)");
            System.Console.WriteLine("-----------------------------------------");
            System.Console.WriteLine();
        }
        static void Main(string[] args)
        {
            Menu(); 
            NhanVien nhanVien = new NhanVien();
            KhachHang khachHang = new KhachHang();
            while (true)
            {
                System.Console.Write("Nhap: ");
                string choose = Console.ReadLine();
                switch (choose)
                {
                    case "ae":
                        System.Console.Write("Nhap so luong nhan vien can them: ");
                        int n = Int32.Parse(System.Console.ReadLine());
                        nhanVien.addNhanVien(n);
                        break;
                    case "ac":
                        System.Console.Write("Nhap so luong khach hang can them: ");
                        int m = Int32.Parse(System.Console.ReadLine());
                        khachHang.addKhachHang(m);
                        break;
                    case "dae":
                        nhanVien.hienThiNv();
                        break;
                    case "dac":
                        khachHang.hienThiKh();
                        break;
                    case "ea":
                        System.Console.Write("Ban co muon thoat chuong trinh khong(c/k)? ");
                        string ck = System.Console.ReadLine();
                        if (ck == "c") return;
                        else break;
                    default:
                        System.Console.WriteLine("Ki tu khong hop le.");
                        break;
                }
            }
            System.Console.ReadKey();
        }
    }
}