import { Injectable } from '@angular/core';
import Movie from '../model/moive';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  movies: Movie[] | null = null

  findMovie( id : number){
    return this.movies?.find( (movie) => movie.id == id )
  }
  
}
