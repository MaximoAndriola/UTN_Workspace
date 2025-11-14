import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ClientService } from '../../service/client-service';
import { ActivatedRoute, Route, Router } from '@angular/router';
import Client from '../../model/client';

@Component({
  selector: 'app-update-form',
  imports: [ReactiveFormsModule],
  templateUrl: './update-form.html',
  styleUrl: './update-form.css'
})
export class UpdateForm implements OnInit{
  activeClient! : Client
  clientId! : string
  updateForm! : FormGroup

  constructor(
    private formBuilder : FormBuilder, 
    public clientService : ClientService, 
    private router : Router,
    private route : ActivatedRoute
  ){}

  ngOnInit(): void {
    this.clientId = this.route.snapshot.data['clientId']

    this.clientService.getClientById(this.clientId).subscribe({
      next: (data) => {this.activeClient = data},
      error: (error) => {console.log(error)}
    })

    this.updateForm = this.formBuilder.group({
      nombre : ["", [Validators.required, Validators.min(3)]],
      empresa : ["", Validators.required],
      email : ["", [Validators.required, Validators.max(300), Validators.email]],
      telefono : ["", [Validators.required, Validators.min(8), Validators.pattern('^[0-9]+$')]],
      comentarios : ["", Validators.max(200)]
    })
    
  }

  get nombre(){
    return this.updateForm.get('nombre')
  }

  get empresa(){
    return this.updateForm.get('empresa')
  }

  get email(){
    return this.updateForm.get('email')
  }

  get telefono(){
    return this.updateForm.get('telefono')
  }

  get comentarios(){
    return this.updateForm.get('comentarios')
  }

  updateClient(){
    this.clientService.postClient(this.updateForm.value)
  }
}
