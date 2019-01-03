import { Component, OnInit } from '@angular/core';
import { Response, RequestOptions,
         Headers } from '@angular/http';

import * as _ from 'lodash';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthenticationService } from 'app/security/authentication.service';
import { ComputerPart } from 'app/model/computerPart.model';
import { Brand } from 'app/model/brand.model';

@Component({
  selector: 'app-main-component',
  templateUrl: './main-component.component.html',
  styleUrls: ['./main-component.component.css']
})
export class MainComponentComponent implements OnInit {
  shoppingCart: ComputerPart[] = [];
  computerParts: ComputerPart[] = [];
  brands: Brand[] = [];
  computerPart: ComputerPart ={
    id:null,
    name: "",
    price: 0,
    brand:null
  };


  ngOnInit(): void {
    this.loadData();
    this.loadBrands();
  }

  constructor(private http: HttpClient, private authenticationService: AuthenticationService) {
  }

  loadData() {
    this.http.get('api/computer-parts').subscribe( data => {
      this.computerParts = data as ComputerPart[];
      this.reset();
    });
  }
  loadBrands(){
    this.http.get('api/brands').subscribe((data: Brand[]) =>{
      this.brands = data;
      console.log(data);
    });
  }

  reset() {
    this.computerPart = {
      id:null,
      name: '',
      price: 0,
      brand: null
    };
  }

  hasRole(role: string): boolean {
    return this.authenticationService.hasRole(role);
  }
  save() {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    // if (this.computerPart.id === undefined) {
      if(this.computerPart.id !=null){
        this.http.put(`api/computer-parts/${this.computerPart.id}`, JSON.stringify(this.computerPart), {headers}).subscribe((data: ComputerPart) => {
        this.loadData();
      });
      }else{
        this.http.post('api/computer-parts', JSON.stringify(this.computerPart), {headers}).subscribe((data: ComputerPart) => {
          this.loadData();
        });
      }
    // } else {
    //   this.http.put(`api/computer-parts/${this.computerPart.id}`, JSON.stringify(this.computerPart), {headers}).subscribe((data: ComputerPart) => {
    //     this.loadData();
    //   });
    // }
  }

  // edit(editedComponentPart: ComputerPart) {
  //   this.computerPart = editedComponentPart;
  // }

  editComputerPart(cpart: ComputerPart){
    this.computerPart = cpart;
  }
  delete(id :  number){
    this.http.delete(`/api/computer-parts/${id}`).subscribe(
      (res: Response) => {
        console.log("Obrisao"+`${id}`);
        this.loadData();
      }
    );
  }
  addToShoppingCart(cPartItem: ComputerPart){
    this.shoppingCart.push(cPartItem);
  }
}
