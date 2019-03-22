import { Component, OnInit } from '@angular/core';
import {City} from './city';

@Component({
	selector: 'app-cities',
	templateUrl: './cities.component.html',
	styleUrls: ['./cities.component.css']
})
 
export class CitiesComponent implements OnInit {
	query = '';
	cities = [];

	handleChange(): void {
		if(this.query) {
			fetch("https://cors-anywhere.herokuapp.com/"+'https://www.metaweather.com/api/location/search/?query='+this.query)
				.then(response => response.json())
				.then(json => {
					this.cities = json;
					console.log(json)
				})
		}	
	}

	constructor() { }

	ngOnInit() {
	}

}
