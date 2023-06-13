using Microsoft.Data.SqlClient;

namespace ConsoleADO.NET
{
    internal class Program{
        static void Main(string[] args){
            SqlConnection conn = new SqlConnectionConnection("Sever=localhost;Database=classicmodels;Uid=sa;Pwd=1q2w3e4r");
            SqlCommand command = new SqlCommand("Select * from Customers", conn);
            conn.Open();
            SqlDataReader reader = command.ExecuteReader();
            while(){
                
            }
        }
    }
}