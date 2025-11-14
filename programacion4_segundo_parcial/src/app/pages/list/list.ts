import { Component, OnInit } from '@angular/core';
import Client from '../../model/client';
import { ClientService } from '../../service/client-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list',
  imports: [],
  templateUrl: './list.html',
  styleUrl: './list.css'
})
export class List implements OnInit{
  clients! : Client[]

  constructor(
    public clientService : ClientService,
    private router : Router
  ){}

  ngOnInit(): void {
    this.clientService.getClients().subscribe({
      next: (data) => {this.clients = data},
      error: (error) => {console.log(error)}
    })
  }

  showDetails(clientId : string){
    this.router.navigate(['/details', clientId])
  }

  updateClient(clientId : string){
    // Ahora usa el mismo formulario pero con el ID del cliente
    this.router.navigate(['/form', clientId])
  }

  deleteClient(clientId : string){
    this.clientService.deleteClient(clientId).subscribe({
      next: () => {
        console.log('eliminado correctamente')
        this.router.navigate(['/home'])
      },
      error: (error) => {console.log(error)}
    })
  }
}
