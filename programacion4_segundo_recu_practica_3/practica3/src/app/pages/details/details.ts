import { Component, OnInit } from '@angular/core';
import { Customer } from '../../model/customer';
import { CustomerService } from '../../service/customer-service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-details',
  imports: [],
  templateUrl: './details.html',
  styleUrl: './details.css',
})
export class Details implements OnInit{
  customer! : Customer
  customerID : string | null = null
  
  constructor(
    public customerService : CustomerService,
    private route : ActivatedRoute
  ){}

  ngOnInit(): void {
    this.customerID = this.route.snapshot.paramMap.get("id")
    if(this.customerID){
      this.customerService.getCustomerById(this.customerID).subscribe({
        next: (data) => (this.customer = data),
        error: (error) => (console.log(error))
      })
    }
  }
}
