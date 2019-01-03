import { Component, OnInit } from '@angular/core';
import { Response, RequestOptions,
         Headers } from '@angular/http';

import * as _ from 'lodash';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { AuthenticationService } from 'app/security/authentication.service';





@Component({
  selector: 'app-main-component',
  templateUrl: './main-component.component.html',
  styleUrls: ['./main-component.component.css']
})
export class MainComponentComponent implements OnInit {
  vreme: string ='';
  tipoviKarata: any[];
  karte: any[];
  letovi: any[];
  avion: any = {
    brojLeta: null,
    vremeLeta: '',
    karta: null,
    prevoznik:null
  }
  karta: any = {
    ime: '',
    prezime: '',
    brojSedista: '',
    tipKarte: null
  }
  tipKarte: any = {
    naziv: ''
  }
  
  currentPage = 0;

  numberOfPages: number;

  ngOnInit(): void {
    this.loadData();
    this.loadTipoveKarata();

  }

  constructor(private http:HttpClient , private authenticationService: AuthenticationService) {
  }

  hasRole(role: string): boolean {
    return this.authenticationService.hasRole(role);
  }

  loadData() {
    const params = new HttpParams()
      .set('page', this.currentPage.toString())
      .set('size', '5');
    this.http.get('api/letovi', { params }).subscribe( data => {
    // this.http.get(`api/computer-parts?page=${this.currentPage}&size=${5}`).subscribe( data => {
      this.letovi = data['content'] as any[];
      this.numberOfPages = data['totalPages'];
      this.resetLet();
    });
  }

  


  loadTipoveKarata(){
    this.http.get('api/tipovikarata').subscribe(data => {this.tipoviKarata
    = data as any[];
  });
  }

    resetLet() {
    this.avion = {
    brojLeta: null,
    vremeLeta: '',
    karta: null,
    prevoznik:null
      };
    }
  
  
    changePage(x: number) {
      if (this.currentPage + x >= 0 && this.currentPage + x < this.numberOfPages) {
        this.currentPage += x;
        this.loadData();
      }
    }


    filter(){
      const params = new HttpParams()
      .set('vreme', this.vreme);
      this.http.get('api/letovi', {params}).subscribe( data => {
        this.letovi = data as any[];
      });
    }

  
}
  
