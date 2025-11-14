import { Component, OnInit } from '@angular/core';
import { PlayerService } from '../../service/player-service';
import { Router } from '@angular/router';
import { Player } from '../../model/player';

@Component({
  selector: 'app-list',
  imports: [],
  templateUrl: './list.html',
  styleUrl: './list.css',
})
export class List implements OnInit {
  players! : Player[]

  constructor(
    public playerService : PlayerService,
    private router : Router
  ){}

  ngOnInit(): void {
    this.getPlayers();
  }

  getPlayers(){
    this.playerService.getPlayers().subscribe({
      next: (data) => (this.players = data),
      error: (error) => (console.log(error))
    })
  }

  showDetails(id : string){
    return this.router.navigate(["/details", id])
  }

  deletePlayer(id : string){
    return this.playerService.deletePlayer(id).subscribe({
      next: () => {this.getPlayers()},
      error: (error) => (console.log(error))
    })
  }

  updatePlayer(id : string){
    return this.router.navigate(["/update", id])
  }
}
