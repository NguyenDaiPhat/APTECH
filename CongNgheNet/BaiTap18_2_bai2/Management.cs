using System;
namespace Bai2_18_2
{
    class Management
    {
        private int  id = 0;
        private bool Check = false;
        List<Student> StudentList;
        public void init()
        {
            StudentList = new List<Student>();
        }
        public void AddStudent()
        {
            Student student = new Student();
            student.AddStudent(++id);
            StudentList.Add(student);
        }

        public void Display()
        {
            for (int i = 0; i < StudentList.Count; i++)
            {
                Student student = StudentList[i];
                student.Display();
            }
        }
        public void Search(){
            System.Console.Write("Please input a name student:");
            string name = System.Console.ReadLine();
            for (int i = 0; i < StudentList.Count;i++){
                if (StudentList[i].FullName == name)
                {
                    StudentList[i].Display();
                    Check = true;
                }
            }
            if(!Check)System.Console.WriteLine($"Khong tim thay hoc sinh nao ten {name}");
        }
    }
}