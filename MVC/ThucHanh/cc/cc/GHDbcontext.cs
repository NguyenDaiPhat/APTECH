using cc;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Text;

namespace DEF.Model
{
    internal class GHDbcontext : DbContext
    {
        private const string sConnect = "Server=(localdb)\\MSSQLLocalDB;Database=ProductDB;Integrated Security=True";
        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            base.OnConfiguring(optionsBuilder);
            optionsBuilder.UseSqlServer(sConnect);
        }
        public DbSet<Product> Products { get; set; }
    }
}