import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { AuthenticationService } from 'app/security/authentication.service';
import { Meal } from 'app/model/meal.model';
import { Category } from 'app/model/category.model';


@Component({
  selector: 'app-main-component',
  templateUrl: './main-component.component.html',
  styleUrls: ['./main-component.component.css']
})
export class MainComponentComponent implements OnInit {
  mealName: string = '';
  categoryName: string = '';
  meals: Meal[] = [];
  categories: Category[] = [];
  meal: Meal = {
    id:null,
    name: '',
    category:null,
    price: 0
  };

  currentPage = 0;
  numberOfPages: number;

  ngOnInit(): void {
    this.loadData();
    this.loadCategories();

  }

  constructor(private http: HttpClient, private authenticationService: AuthenticationService) {
  }

  changePage(x: number) {
    if (this.currentPage + x >= 0 && this.currentPage + x < this.numberOfPages) {
      this.currentPage += x;
      this.loadData();
    }
  }

  loadData() {
    const params = new HttpParams()
      .set('page', this.currentPage.toString())
      .set('size', '5');
    this.http.get('api/meals', { params }).subscribe( data => {
    // this.http.get(`api/computer-parts?page=${this.currentPage}&size=${5}`).subscribe( data => {
      this.meals = data['content'] as Meal[];
      this.numberOfPages = data['totalPages'];
      this.reset();
    });
  }

  loadCategories(){
    this.http.get('api/categories').subscribe((data: Category[]) =>{
      this.categories = data;
      console.log(data);
    });
  }

  reset(){
    this.meal = {
    id:null,
    name: '',
    category:null,
    price: 0
    };
  }

  hasRole(role: string): boolean {
    return this.authenticationService.hasRole(role);
  }

  save() {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
      if(this.meal.id !=null){
        this.http.put(`api/meals/${this.meal.id}`, JSON.stringify(this.meal), {headers}).subscribe((data: Meal) => {
        this.loadData();
      });
      }else{
        this.http.post('api/meals', JSON.stringify(this.meal), {headers}).subscribe((data: Meal) => {
          this.loadData();
        });
      }
   
  }

  delete(id :  number){
     this.http.delete(`/api/meals/${id}`).subscribe(
      (res: Response) => {
        console.log("Obrisao"+`${id}`);
        this.loadData();
      }
    );
  }

  editMeal(m: Meal){
    this.meal= m;
  }

  filterName(){
    const params = new HttpParams()
    .set('mealName', this.mealName)
    //.set('categoryId', this.meal.category.id.toString());
    this.http.get('api/meals', {params}).subscribe( data => {
      this.meals = data as Meal[];
    });
  }

  filterCategory(){
    const params = new HttpParams()
    .set('categoryName', this.categoryName);
    this.http.get('api/meals', {params}).subscribe( data => {
      this.meals = data as Meal[];
    });
  }


}
