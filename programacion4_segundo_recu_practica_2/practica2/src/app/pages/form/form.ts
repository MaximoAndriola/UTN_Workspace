import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { EmployeeService } from '../../service/employee-service';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../../model/employee';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-form',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './form.html',
  styleUrl: './form.css',
})
export class Form implements OnInit{
  form! : FormGroup
  isUpdate : boolean = false
  employeeId : string | null = null
  pageTitle : string = "Crear"

  constructor(
    private builder : FormBuilder,
    public employeeService : EmployeeService,
    private route : ActivatedRoute,
    private router : Router
  ){}

  ngOnInit(): void {
    this.form = this.builder.group({
      name : ["", [Validators.required, Validators.minLength(3), Validators.maxLength(50)]],
      age : ["", [Validators.required, Validators.min(18), Validators.max(100)]],
      mail : ["", [Validators.required, Validators.email, Validators.minLength(10), Validators.maxLength(100)]],
      phoneNumber : ["", [Validators.required, Validators.minLength(9), Validators.maxLength(15)]]
    })

    this.employeeId = this.route.snapshot.paramMap.get("id")

    if(this.employeeId){
      this.isUpdate = true
      this.pageTitle = "Actualizar"
      this.loadEmployee(this.employeeId)
    }
  }

  loadEmployee(id : string){
    this.employeeService.getEmployeeById(id).subscribe({
      next: (employee : Employee) => (this.form.patchValue(employee)),
      error: (error) => (console.log(error))
    })
  }

  get name(){
    return this.form.get("name")
  }

  get age(){
    return this.form.get("age")
  }

  get mail(){
    return this.form.get("mail")
  }

  get phoneNumber(){
    return this.form.get("phoneNumber")
  }

  onSubmit(){
    if(this.form.invalid){
      return
    }

    if(this.isUpdate){
      this.updateEmployee()
    }else{
      this.createEmployee()
    }
  }

  updateEmployee(){
    if(this.employeeId){
      this.employeeService.putEmployee(this.form.value, this.employeeId).subscribe({
        next: () => (this.router.navigate(["/list"])),
        error: (error) => (console.log(error))
      })
    }    
  }

  createEmployee(){
    this.employeeService.postEmployee(this.form.value).subscribe({
      next: () => (this.router.navigate(["/list"])),
      error: (error) => (console.log(error))
    })
  }
}
