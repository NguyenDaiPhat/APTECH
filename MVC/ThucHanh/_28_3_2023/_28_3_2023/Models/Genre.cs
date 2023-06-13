using System;
using System.Collections.Generic;

namespace _28_3_2023.Models;

public partial class Genre
{
    public int GenreId { get; set; }

    public string GenreName { get; set; } = null!;

    public virtual ICollection<Movie> Movies { get; } = new List<Movie>();
}
