import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CitiesComponent } from './app/cities/cities.component';
import { CityDetailsComponent } from './app/city-details/city-details.component';


const routes: Routes = [
  { path: '', redirectTo: '/cities', pathMatch: 'full' },
  { path: 'cities', component: CitiesComponent },
  { path: 'city/:id', component: CityDetailsComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}