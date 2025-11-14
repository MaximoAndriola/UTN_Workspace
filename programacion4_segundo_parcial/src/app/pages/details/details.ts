import { Component, OnInit } from '@angular/core';
import Client from '../../model/client';
import { ActivatedRoute, Route, Router, RouterLink } from '@angular/router';
import { ClientService } from '../../service/client-service';

@Component({
  selector: 'app-details',
  imports: [],
  templateUrl: './details.html',
  styleUrl: './details.css'
})
export class Details implements OnInit{
  client! : Client
  clientId! : string

  constructor(
    public clientService : ClientService,
    private route : ActivatedRoute
  ){}

  ngOnInit(): void {
    this.clientId = this.route.snapshot.data['clientId']

    this.clientService.getClientById(this.clientId).subscribe({
      next: (data) => {this.client = data},
      error: (error) => (console.log(error))
    })
  }

}
