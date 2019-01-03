import { Component, OnInit } from '@angular/core';
import { Response, RequestOptions,
         Headers } from '@angular/http';

import * as _ from 'lodash';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { AuthenticationService } from 'app/security/authentication.service';
import { Article } from 'app/model/article.model';
import { Category } from 'app/model/category.model';

@Component({
  selector: 'app-main-component',
  templateUrl: './main-component.component.html',
  styleUrls: ['./main-component.component.css']
})
export class MainComponentComponent implements OnInit {

  articles: Article [];

  article: Article = {
    id: null,
    title: '',
    text: '',
    category: null
  }

categories:Category[];


currentPage = 0;
numberOfPages: number;

  ngOnInit(): void {
    this.loadData();
    this.loadCategories();

  }

  constructor(private http: HttpClient, private authenticationService: AuthenticationService) {
  }

  hasRole(role: string): boolean {
    return this.authenticationService.hasRole(role);
  }

  loadData() {
    const params = new HttpParams()
      .set('page', this.currentPage.toString())
      .set('size', '5');
    this.http.get('api/articles', { params }).subscribe( data => {
    // this.http.get(`api/articles?page=${this.currentPage}&size=${5}`).subscribe( data => {
      this.articles = data['content'] as any[];
      this.numberOfPages = data['totalPages'];
      this.reset();
    });
  }

  loadCategories(){
    this.http.get('api/categories').subscribe(
      (data:Category[])=>{
      this.categories = data;
      console.log(data);
    });
  }

  reset(){
    this.article = {
      id:null,
      title:'',
      text:'',
      category:null
    };
  }

delete(article:Article){
this.http.delete(`api/articles/${article.id}`).subscribe(data =>{
      console.log(data);
      this.loadData();
    });
  }

  // save() {
  //   const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  //   if (this.article.id === undefined) {
  //     this.http.post('api/articles', JSON.stringify(this.article), {headers}).subscribe((data: any) => {
  //       this.loadData();
  //     });
  //   } else {
  //     this.http.put(`api/articles/${this.article.id}`, JSON.stringify(this.article), {headers}).subscribe((data: any) => {
  //       this.loadData();
  //     });
  //   }
  // }

  editArticle(newArticle: Article){
    this.article = newArticle;
  }


  save() {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
      if(this.article.id !=null){
        this.http.put(`api/articles/${this.article.id}`, JSON.stringify(this.article), {headers}).subscribe((data: Article) => {
        this.loadData();
      });
      }else{
        this.http.post('api/articles', JSON.stringify(this.article), {headers}).subscribe((data: Article) => {
          this.loadData();
        });
      }
 
  }



}
