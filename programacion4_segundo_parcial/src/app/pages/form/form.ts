import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ClientService } from '../../service/client-service';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import Client from '../../model/client';

@Component({
  selector: 'app-form',
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './form.html',
  styleUrl: './form.css'
})
export class Form implements OnInit {
  clientForm! : FormGroup;
  isEditMode : boolean = false;
  clientId : string | null = null;
  pageTitle : string = 'Crear Cliente';

  constructor(
    private formBuilder : FormBuilder, 
    public clientService : ClientService, 
    private router : Router,
    private route : ActivatedRoute
  ){}

  ngOnInit(): void {
    // Inicializar el formulario
    this.clientForm = this.formBuilder.group({
      nombre : ["", [Validators.required, Validators.minLength(3)]],
      empresa : ["", Validators.required],
      email : ["", [Validators.required, Validators.maxLength(300), Validators.email]],
      telefono : ["", [Validators.required, Validators.minLength(8), Validators.pattern('^[0-9]+$')]],
      comentarios : ["", Validators.maxLength(200)]
    });

    // Detectar si estamos en modo edición
    this.clientId = this.route.snapshot.paramMap.get('clientId');
    
    if (this.clientId) {
      // MODO EDICIÓN: Cargar datos del cliente existente
      this.isEditMode = true;
      this.pageTitle = 'Editar Cliente';
      this.loadClient(this.clientId);
    }
    // Si no hay clientId, el formulario queda vacío (modo creación)
  }

  // Cargar datos del cliente en el formulario
  loadClient(id: string): void {
    this.clientService.getClientById(id).subscribe({
      next: (client: Client) => {
        // Rellenar el formulario con los datos del cliente
        this.clientForm.patchValue({
          nombre: client.nombre,
          empresa: client.empresa,
          email: client.email,
          telefono: client.telefono,
          comentarios: client.comentarios
        });
      },
      error: (error) => {
        console.error('Error al cargar el cliente:', error);
        alert('No se pudo cargar el cliente');
        this.router.navigate(['/list']);
      }
    });
  }

  get nombre(){
    return this.clientForm.get('nombre')
  }

  get empresa(){
    return this.clientForm.get('empresa')
  }

  get email(){
    return this.clientForm.get('email')
  }

  get telefono(){
    return this.clientForm.get('telefono')
  }

  get comentarios(){
    return this.clientForm.get('comentarios')
  }

  // Método único que maneja tanto creación como actualización
  onSubmit(): void {
    if (this.clientForm.invalid) {
      return;
    }

    if (this.isEditMode && this.clientId) {
      // ACTUALIZAR cliente existente
      this.updateClient();
    } else {
      // CREAR nuevo cliente
      this.createClient();
    }
  }

  // Crear nuevo cliente
  createClient(): void {
    this.clientService.postClient(this.clientForm.value).subscribe({
      next: () => {
        console.log('Cliente creado exitosamente');
        this.router.navigate(['/list']);
      },
      error: (error) => {
        console.error('Error al crear el cliente:', error);
        alert('Error al crear el cliente');
      }
    });
  }

  // Actualizar cliente existente
  updateClient(): void {
    if (!this.clientId) return;

    this.clientService.putClient(this.clientForm.value, this.clientId).subscribe({
      next: () => {
        console.log('Cliente actualizado exitosamente');
        this.router.navigate(['/list']);
      },
      error: (error) => {
        console.error('Error al actualizar el cliente:', error);
        alert('Error al actualizar el cliente');
      }
    });
  }

}
