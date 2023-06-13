namespace Programs
{
    class KhachHang : Nguoi
    {
        public string Classify;
        public void checkClassify(ref string Classify)
        {
            while (Classify != "moi" && Classify != "thanh vien" && Classify != "vip")
            {
                System.Console.Write("Phan loai khong hop le(moi|thanh vien|vip): ");
                Classify = System.Console.ReadLine();
            }
        }
        List<KhachHang> khachHangList = new List<KhachHang>();
        int j = 0;
        public void addKhachHang(int n)
        {
            for (int i = 0; i < n; i++)
            {
                KhachHang khachHang = new KhachHang();
                khachHang.Code = "c" + (j++);
                System.Console.WriteLine($"Nhap thong tin khach hang thu {j}:");
                System.Console.Write($"Ten: ");
                khachHang.Name = System.Console.ReadLine();
                System.Console.Write($"Gioi tinh: ");
                khachHang.Sex = System.Console.ReadLine();
                checkGioiTinh(ref khachHang.Sex);
                System.Console.Write($"Ngay sinh: ");
                khachHang.Date = System.Console.ReadLine();
                checkDate(ref khachHang.Date);
                System.Console.Write($"Loai: ");
                khachHang.Classify = System.Console.ReadLine();
                checkClassify(ref Classify);
                khachHangList.Add(khachHang);
            }
        }
        public void hienThiKh()
        {
            System.Console.WriteLine("Danh sach cac khach hang la: ");
            foreach (KhachHang p in khachHangList)
            {
                System.Console.WriteLine($"Ma: {p.Code}, Ten: {p.Name}, Gioi tinh: {p.Sex}, Ngay sinh: {p.Date}, Loai: {p.Classify}");
            }
        }
    }
}
