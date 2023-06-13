using System;
using System.Collections.Generic;

namespace _28_3_2023.Models;

public partial class Movie
{
    public int MovieId { get; set; }

    public string Title { get; set; } = null!;

    public DateTime ReleaseDate { get; set; }

    public int RunningTime { get; set; }

    public int GenreId { get; set; }

    public decimal BoxOffice { get; set; }

    public virtual Genre Genre { get; set; } = null!;
}
