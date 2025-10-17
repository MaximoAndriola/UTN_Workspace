import { Component, OnInit } from '@angular/core';
import { MovieService } from '../../service/movie-service';
import { Route, Router, RouterLink } from '@angular/router';
import Movie from '../../model/movie';

@Component({
  selector: 'app-list',
  imports: [RouterLink],
  templateUrl: './list.html',
  styleUrl: './list.css'
})
export class List implements OnInit{

  constructor(public movieService : MovieService, private router : Router){}

  ngOnInit(): void {
    this.getMovies();
  }

  getMovies(){
    this.movieService.getMovies().subscribe({
      next: (data) => {this.movieService.movies = data},
      error: (error) => {console.log(error)}
    })
  }

  showDetails(movie : Movie){
    this.router.navigate(['/details', movie.id])
  }

  updateMovie(movie : Movie){
    this.router.navigate(['/update', movie.id])
  }

  deleteMovie(id : number){
    this.movieService.deleteMovie(id).subscribe({
      next: (data) => {
        console.log(data)
        this.getMovies()
      },
      error: (error) => {console.log(error)}
    })
  }
}
