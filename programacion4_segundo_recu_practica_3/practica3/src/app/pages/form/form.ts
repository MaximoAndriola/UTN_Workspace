import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { CustomerService } from '../../service/customer-service';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from '../../model/customer';

@Component({
  selector: 'app-form',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './form.html',
  styleUrl: './form.css',
})
export class Form implements OnInit{
  customerForm! : FormGroup
  pageTitle : string = "Create"
  isUpdate : boolean = false
  customerId : string | null = null
  
  constructor(
    private builder : FormBuilder,
    public customerService : CustomerService,
    private route : ActivatedRoute,
    private router : Router
  ){}

  ngOnInit(): void {
    this.customerForm = this.builder.group({
      name : ["", [Validators.required, Validators.minLength(5), Validators.maxLength(20)]],
      age : ["", [Validators.required, Validators.min(18), Validators.max(100)]],
      mail : ["", [Validators.required, Validators.email]],
      phoneNumber : ["", [Validators.required, Validators.minLength(9), Validators.maxLength(12)]]
    })

    this.customerId = this.route.snapshot.paramMap.get("id")

    if(this.customerId){
      this.isUpdate = true
      this.pageTitle = "Update"
      this.loadCustomer(this.customerId)
    }
  }

  loadCustomer(id : string){
    this.customerService.getCustomerById(id).subscribe({
        next: (customer : Customer) => (this.customerForm.patchValue(customer)),
        error: (error) => (console.log(error))
      })
  }

  get name(){
    return this.customerForm.get("name")
  }

  get age(){
    return this.customerForm.get("age")
  }

  get mail(){
    return this.customerForm.get("mail")
  }

  get phoneNumber(){
    return this.customerForm.get("phoneNumber")
  }

  onSubmit(){
    if(this.customerForm.invalid){
      return
    }

    if(this.isUpdate){
      if(this.customerId)
      this.updateCustomer(this.customerId)
    }else{
      this.createCustomer()
    }
  }

  updateCustomer(id : string){
    this.customerService.putCustomer(this.customerForm.value, id).subscribe({
      next: () => (this.router.navigate(["/list"])),
      error: (error) => (console.log(error))
    })
  }

  createCustomer(){
    this.customerService.postCustomer(this.customerForm.value).subscribe({
      next: () => (this.router.navigate(["/list"])),
      error: (error) => (console.log(error))
    })
  }

}
