using System;
namespace MyDictionary
{
    internal interface IDictionary
    {
        public bool AddWord(string s1, string s2);
        public bool EditWord(string s1, string s2);
        public string Translate(string s1);

    }
}
