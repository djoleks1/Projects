import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { City } from '../cities/city';

@Component({
  selector: 'app-city-details',
  templateUrl: './city-details.component.html',
  styleUrls: ['./city-details.component.css']
})
export class CityDetailsComponent implements OnInit {
  city : City;
  threeDays = [];

  constructor(
    private route: ActivatedRoute,
    private location: Location
  ) { }

  ngOnInit() {
    this.getHero();
  }

  getHero(): void {
    const id = this.route.snapshot.paramMap.get('id');
    fetch("https://cors-anywhere.herokuapp.com/https://www.metaweather.com/api/location/search/?query="+id)
				.then(response => response.json())
				.then(json => {
          this.city = json[0];
          console.log(json);
          fetch("https://cors-anywhere.herokuapp.com/https://www.metaweather.com/api/location/"+json[0].woeid)
            .then(response => response.json())
            .then(json => {
              this.threeDays= json.consolidated_weather;
            })
				})
  }

  test = () => {
    console.log(this.threeDays)
  }

  goBack(): void {
    this.location.back();
  }

}
