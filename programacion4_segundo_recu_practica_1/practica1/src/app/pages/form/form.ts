import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { PlayerService } from '../../service/player-service';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Player } from '../../model/player';

@Component({
  selector: 'app-form',
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './form.html',
  styleUrl: './form.css',
})
export class Form implements OnInit{
  playerForm! : FormGroup
  isUpdtate : boolean = false
  playerId : string | null = null
  pageTitle : string = "Crear Jugador"

  constructor(
    public playerService : PlayerService,
    private router : Router,
    private route : ActivatedRoute,
    private formBuilder : FormBuilder
  ){}

  ngOnInit(): void {
    this.playerForm = this.formBuilder.group({
      name : ["", [Validators.required, Validators.maxLength(100), Validators.minLength(2)]],
      age: ["", [Validators.required, Validators.max(100), Validators.min(15)]],
      dorsal: ["", [Validators.required, Validators.min(1), Validators.max(99)]],
      team: ["", [Validators.required, Validators.minLength(3), Validators.maxLength(100)]]
    })
  
    this.playerId = this.route.snapshot.paramMap.get('id');

    if (this.playerId) {
      this.pageTitle = "Actualizar Jugador"
      this.isUpdtate = true
      this.loadPlayer(this.playerId)
    }
  }

  loadPlayer(id : string): void{
    this.playerService.getPlayerById(id).subscribe({
      next: (player : Player) => {
        this.playerForm.patchValue(player)
      },
      error: (error) => console.log(error)
    })
  }

  get name(){
    return this.playerForm.get("name")
  }

  get age(){
    return this.playerForm.get("age")
  }

  get dorsal(){
    return this.playerForm.get("dorsal")
  }

  get team(){
    return this.playerForm.get("team")
  }

  onSubmit(){
    if(this.playerForm.invalid){
      return
    }

    if(this.isUpdtate){
      this.updatePlayer()
    }else{
      this.createPlayer()
    }
  }

  updatePlayer(){
    if(!this.playerId) return;

    this.playerService.putPlayer(this.playerId, this.playerForm.value).subscribe({
      next: () => (this.router.navigate(["/list"])),
      error: (error) => (console.log(error))
    })
  }

  createPlayer(){
    this.playerService.postPlayer(this.playerForm.value).subscribe({
      next: () => (this.router.navigate(["/list"])),
      error: (error) => (console.log(error))
    })
  }
}
