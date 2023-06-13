﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyDictionary
{
    class Program
    {
        static void Menu()
        {
            Console.WriteLine("Ban hay chon 1 trong cac lua chon sau:");
            Console.WriteLine("1. Add a word");
            Console.WriteLine("2. Exit a word");
            Console.WriteLine("3. Search a meaning");
            Console.WriteLine("4. Quit");
        }
        static void Main(string[] args)
        {
            while (true)
            {
                Menu();
                Console.WriteLine("Your Choose: ");
                string choose = Console.ReadLine();
                switch (choose)
                {
                    case "1":
                        break;
                    case "2":
                        break;
                    case "3":
                        break;
                    case "4":
                        return;
                }
            }  
        }
    }
}