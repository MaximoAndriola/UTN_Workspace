import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { MovieService } from '../../service/movie-service';

@Component({
  selector: 'app-update-form',
  imports: [ReactiveFormsModule],
  templateUrl: './update-form.html',
  styleUrl: './update-form.css'
})
export class UpdateForm implements OnInit{
  movieForm! : FormGroup
  movieId! : number
  
  constructor(
    private formBuilder : FormBuilder,
    private route : ActivatedRoute,
    private router : Router,
    private movieService : MovieService
  ){}

  ngOnInit(): void {
    this.movieId = this.route.snapshot.params['id']

    this.movieForm = this.formBuilder.group({
        name: ['', Validators.required],
        year: ['', [Validators.required, Validators.min(1900)]]
    })

    this.movieService.getMovieById(this.movieId).subscribe({
      next: (data) => (this.movieForm.patchValue(data)),
      error: (error) => (console.log(error))
    })
  }

  get name(){
    return this.movieForm.get('name')!
  }

  get year(){
    return this.movieForm.get('year')!
  }

  updateMovie(){
    const updatedMovie = {
      ...this.movieForm.value,
      id : this.movieId
    }

    this.movieService.putMovie(updatedMovie, updatedMovie.id).subscribe({
      next: () => {
        alert('pelicula editada correctamente')
        this.router.navigate(['/list'])
      },
      error: (error) => {console.log(error)}
    })
  }

}
