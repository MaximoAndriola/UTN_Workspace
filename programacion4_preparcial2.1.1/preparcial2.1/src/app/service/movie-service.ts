import { Injectable } from '@angular/core';
import Movie from '../model/movie';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MovieService {
  readonly URL = "http://localhost:3000/movies"

  movies: Movie[]

  constructor(private http: HttpClient){
    this.movies = []
  }

  getMovies(){
    return this.http.get<Movie[]>(this.URL)
  }

  getMovieById(id : number){
    return this.http.get<Movie>(`${this.URL}/${id}`)
  }

  postMovie(movie : Movie){
    return this.http.post<Movie>(this.URL, movie)
  }

  putMovie(movie : Movie, id : number){
    return this.http.put<Movie>(`${this.URL}/${id}`, movie)
  }

  deleteMovie(id : number){
    return this.http.delete<void>(`${this.URL}/${id}`)
  }
}
