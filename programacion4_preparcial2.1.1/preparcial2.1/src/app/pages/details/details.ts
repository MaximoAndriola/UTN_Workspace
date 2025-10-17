import { Component, OnInit } from '@angular/core';
import Movie from '../../model/movie';
import { ActivatedRoute } from '@angular/router';
import { MovieService } from '../../service/movie-service';

@Component({
  selector: 'app-details',
  imports: [],
  templateUrl: './details.html',
  styleUrl: './details.css'
})
export class Details implements OnInit{
  selectedMovie: Movie | undefined

  constructor(private route : ActivatedRoute, public movieService : MovieService){}

  ngOnInit(): void {
    const movieId = this.route.snapshot.params['movieId']
    this.getMovie(movieId)
  }

  getMovie(id : number){
    this.movieService.getMovieById(id).subscribe({
      next: (data) => {this.selectedMovie = data},
      error: (error) => {console.log(error)}
    })
  }

}
