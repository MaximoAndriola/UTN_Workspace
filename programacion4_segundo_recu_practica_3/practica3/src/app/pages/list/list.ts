import { Component, OnInit } from '@angular/core';
import { Customer } from '../../model/customer';
import { CustomerService } from '../../service/customer-service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-list',
  imports: [FormsModule],
  templateUrl: './list.html',
  styleUrl: './list.css',
})
export class List implements OnInit{
  customers! : Customer[]
  cant! : number
  filterText: string = '' 

  constructor(
    public customerService : CustomerService,
    private router : Router,
  ){}

  ngOnInit(): void {
    this.loadCustomers()
  }

  showDetails(id : string){
    return this.router.navigate(["/details", id])
  }

  updateCustomer(id : string){
    return this.router.navigate(["/update", id])
  }

  deleteCustomer(id : string){
    return this.customerService.deleteCustomer(id).subscribe({
      next: () => (this.loadCustomers()),
      error: (error) => (console.log(error))
    })
  }

  loadCustomers(){
    this.customerService.getCustomers().subscribe({
      next: (data) => {
        this.customers = data
        this.cont()
      },
      error: (error) => (console.log(error)) 
    })
  }

  cont(){
    this.cant = 0
    for(const customer of this.customers){
      this.cant++
    }
  }

  getFilteredCustomers(): Customer[] {
    if (!this.filterText || !this.customers) {
      this.cant = this.customers?.length || 0
      return this.customers
    }
    const filtered = this.customers.filter(c => 
      c.name.toLowerCase().includes(this.filterText.toLowerCase())      
    )
    this.cant = filtered.length
    return filtered
  }
}
