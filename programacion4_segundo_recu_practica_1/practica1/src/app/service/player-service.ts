import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Player } from '../model/player';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PlayerService {
  private URL : string = "http://localhost:3000/players"

  constructor(private http : HttpClient){}

  getPlayers() : Observable<Player[]>{
    return this.http.get<Player[]>(this.URL)
  }

  getPlayerById(id : string) : Observable<Player>{
    return this.http.get<Player>(`${this.URL}/${id}`)
  }

  postPlayer(player : Player) : Observable<Player>{
    return this.http.post<Player>(this.URL, player)
  }

  putPlayer(id : string, player : Player) : Observable<Player>{
    return this.http.put<Player>(`${this.URL}/${id}`, player)
  }

  deletePlayer(id : string) : Observable<void>{
    return this.http.delete<void>(`${this.URL}/${id}`)
  }
}
