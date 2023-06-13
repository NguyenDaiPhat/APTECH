using System;
using System.Collections;

namespace MyDictionary
{
    class MyDictionary : IDictionary
    {
        Hashtable hashtable = new Hashtable();
        
        public bool AddWord(string s1, string s2)
        {
            hashtable[s1] = s2;
        }

        public bool EditWord(string s1, string s2)
        {
            throw new NotImplementedException();
        }

        public string Translate(string s1)
        {
            throw new NotImplementedException();
        }
    }
}