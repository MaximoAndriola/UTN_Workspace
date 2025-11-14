import { Injectable } from '@angular/core';
import Client from '../model/client';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClientService{
  private URL : string = "http://localhost:3000/clientes"
  private clients : Client[] | undefined

  constructor(private http : HttpClient){}

  getClients(): Observable<Client[]>{
    return this.http.get<Client[]>(this.URL)
  }

  getClientById(clientId : string): Observable<Client>{
    return this.http.get<Client>(`${this.URL}/${clientId}`)
  }

  postClient(client : Client): Observable<Client>{
    return this.http.post<Client>(this.URL, client)
  }

  putClient(client : Client, clientId : string): Observable<Client>{
    return this.http.put<Client>(`${this.URL}/${clientId}`, client)
  }

  deleteClient(clientId : string): Observable<void>{
    return this.http.delete<void>(`${this.URL}/${clientId}`)
  }

}
