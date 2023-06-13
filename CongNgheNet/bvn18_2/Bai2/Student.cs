using System;
namespace Bai2_18_2
{
    class Student : IStudent
    {
        public string FullName;
        public int ID;
        public string DateofBirth;
        public string Native;
        public string Class;
        public string PhoneNo;
        public int Mobie;
        public void AddStudent(int id)
        {
            ID = id;
            System.Console.Write("Nhap fullname: ");
            FullName = System.Console.ReadLine();
            System.Console.Write("Nhap dateofbirth: ");
            DateofBirth = System.Console.ReadLine();
            System.Console.Write("Nhap native: ");
            Native = System.Console.ReadLine();
            System.Console.Write("Nhap class: ");
            Class = System.Console.ReadLine();
            System.Console.Write("Nhap phoneno: ");
            PhoneNo = System.Console.ReadLine();
            System.Console.Write("Nhap Mobie: ");
            Mobie = Int32.Parse(System.Console.ReadLine());
        }

        public void Display()
        {
            System.Console.WriteLine($"FullName: {FullName}, ID: {ID}, DateOfBirht: {DateofBirth}, Native: {Native}, Class: {Class}, PhoneNo: {PhoneNo}, Mobie: {Mobie}");
        }
    }
}