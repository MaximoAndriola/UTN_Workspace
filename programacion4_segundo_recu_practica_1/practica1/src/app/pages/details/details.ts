import { Component, OnInit } from '@angular/core';
import { Player } from '../../model/player';
import { PlayerService } from '../../service/player-service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-details',
  imports: [],
  templateUrl: './details.html',
  styleUrl: './details.css',
})
export class Details implements OnInit{
  player! : Player
  playerId : string | null = null

  constructor(
    public playerService : PlayerService,
    private route : ActivatedRoute
  ){}

  ngOnInit(): void {
    this.playerId = this.route.snapshot.paramMap.get('id')

    if(this.playerId){
      this.loadPlayer(this.playerId)
    }
  }

  loadPlayer(id : string){
    this.playerService.getPlayerById(id).subscribe({
      next: (player : Player) => {this.player = player},
      error: (error) => {console.log(error)}
    })
  }
}
