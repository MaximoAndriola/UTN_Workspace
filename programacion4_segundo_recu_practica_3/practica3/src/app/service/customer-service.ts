import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../model/customer';

@Injectable({
  providedIn: 'root',
})
export class CustomerService {
  URL :  string = "http://localhost:3000/customers"

  constructor(private http : HttpClient){}
  
  getCustomers() : Observable<Customer[]>{
    return this.http.get<Customer[]>(this.URL)
  }

  getCustomerById(id : string) : Observable<Customer>{
    return this.http.get<Customer>(`${this.URL}/${id}`)
  }

  postCustomer(customer : Customer) : Observable<Customer>{
    return this.http.post<Customer>(this.URL, customer)
  }

  putCustomer(customer : Customer, id : string) : Observable<Customer>{
    return this.http.put<Customer>(`${this.URL}/${id}`, customer)
  }

  deleteCustomer(id : string) : Observable<void>{
    return this.http.delete<void>(`${this.URL}/${id}`)
  }
}
