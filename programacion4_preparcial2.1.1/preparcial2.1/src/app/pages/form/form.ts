import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { MovieService } from '../../service/movie-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-form',
  imports: [ReactiveFormsModule],
  templateUrl: './form.html',
  styleUrl: './form.css'
})
export class Form {

  movieForm : FormGroup

  constructor(private formBuilder : FormBuilder, public movieService : MovieService, private router : Router) {
    this.movieForm = this.formBuilder.group({
      name: ['', Validators.required],
      year: ['', [Validators.required, Validators.min(1900)]]
    })
  }

  get name(){
    return this.movieForm.get('name')!
  }

  get year(){
    return this.movieForm.get('year')!
  }

  postMovie(){
    this.movieService.postMovie(this.movieForm.value).subscribe({
      next: (data) => {console.log(data)},
      error: (error) => {console.log(error)}
    })

    this.router.navigate(['/list']);
  }
  

}
