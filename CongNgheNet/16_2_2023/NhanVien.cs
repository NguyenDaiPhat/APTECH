namespace Programs
{
    class NhanVien : Nguoi
    {
        public string Degree;
        public void checkDegree(ref string Degree)
        {
            while (Degree != "trung cap" && Degree != "cao dang" && Degree != "dai hoc")
            {
                System.Console.Write("Bang cap khong hop le(trung cap|cao dang|dai hoc): ");
                Degree = System.Console.ReadLine();
            }
        }
        List<NhanVien> nhanVienList = new List<NhanVien>();
        int j = 0;
        public void addNhanVien(int n)
        {
            for (int i = 0; i < n; i++)
            {
                NhanVien nhanvien = new NhanVien();
                nhanvien.Code = "e" + j++;
                System.Console.WriteLine($"Nhap thong tin nhan vien thu {j}:");
                System.Console.Write("Ten: ");
                nhanvien.Name = System.Console.ReadLine();
                System.Console.Write("Gioi tinh: ");
                nhanvien.Sex = System.Console.ReadLine();
                checkGioiTinh(ref nhanvien.Sex);
                System.Console.Write("Bang cap: ");
                nhanvien.Degree = System.Console.ReadLine();
                checkDegree(ref nhanvien.Degree);
                System.Console.Write("Ngay sinh: ");
                nhanvien.Date = System.Console.ReadLine();
                checkDate(ref nhanvien.Date);
                nhanVienList.Add(nhanvien);
            }
        }
        public void hienThiNv()
        {
            System.Console.WriteLine("Danh sach cac nhan vien la: ");
            foreach (NhanVien p in nhanVienList)
            {
                System.Console.WriteLine($"Ma: {p.Code}, Ten: {p.Name}, Gioi tinh: {p.Sex}, Bang cap: {p.Degree}, Ngay sinh: {p.Date}");
            }
        }
    }
}
