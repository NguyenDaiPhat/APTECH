namespace Programs
{
    class Nguoi
    {
        public string Code;
        public string Name;
        public string Sex;
        public string Date;
        public void checkGioiTinh(ref string Sex)
        {
            while (Sex != "nam" && Sex != "nu")
            {
                System.Console.Write("Gioi tinh khong hop le (nam/nu): ");
                Sex = System.Console.ReadLine();
            }
        }
        public void checkDate(ref string Date)
        {
            while (Date.Length != 10)
            {
                System.Console.Write("Do dai ngay sinh khong hop le (=10): ");
                Date = System.Console.ReadLine();
            }
        }
    }
}
