using System;
namespace Delegate
{
    public delegate void SuKienNhapSo(string s);
    class Pubisher
    {
        public event SuKienNhapSo suKienNhapSo;
        public void NhapInfo()
        {
            System.Console.WriteLine("Nhap thong tin: ");
            string s = Console.ReadLine();
            // if(suKienNhapSo != null)
            //     suKienNhapSo.Invoke(i);
            suKienNhapSo?.Invoke(s);
        }
    }
    class Subciber
    {
        public void setInfo(Pubisher inputInfo){
            inputInfo.suKienNhapSo += showInfo;
        }
        public void showInfo(string s){
            System.Console.WriteLine(s);
        }
    }
    class Warning{
        public void setInfo(Pubisher inputInfo)
        {
            inputInfo.suKienNhapSo += showInfo;
        }
        public void showInfo(string s)
        {
            System.Console.WriteLine($"{s} is warning");
        }
    }
    class Info
    {
        public void setInfo(Pubisher inputInfo)
        {
            inputInfo.suKienNhapSo += showInfo;
        }
        public void showInfo(string s)
        {
            System.Console.WriteLine($"{s} is info");
        }
    }
    class Error
    {
        public void setInfo(Pubisher inputInfo)
        {
            inputInfo.suKienNhapSo += showInfo;
        }
        public void showInfo(string s)
        {
            System.Console.WriteLine($"{s} is Error");
        }
    }
    class Program
    {
        static void Main()
        {
            // int a = 10;
            // int b = 10;
            // tinhtoan tinhtoan;
            // tinhtoan = Add;
            // tinhtoan += Sub;
            // tinhtoan -= Sub;
            // tinhtoan(a, b);
            Pubisher inputNumber = new Pubisher();
            Subciber receiveNumber = new Subciber();
            // receiveNumber.setInfo(inputNumber);
            Warning warning = new Warning();
            warning.setInfo(inputNumber);
            inputNumber.NhapInfo();
        }
    }
}