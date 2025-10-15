import { Component } from '@angular/core';
import Movie from '../../model/moive';
import { ActivatedRoute } from '@angular/router';
import { MovieService } from '../../service/movie-service';

@Component({
  selector: 'app-detail',
  imports: [],
  templateUrl: './detail.html',
  styleUrl: './detail.css'
})
export class Detail {

  selectedMovie : Movie | undefined

  constructor(private route: ActivatedRoute, private movieService : MovieService){

    const movieId = route.snapshot.params['movieid']
    movieService.findMovie(movieId)
  }
}
