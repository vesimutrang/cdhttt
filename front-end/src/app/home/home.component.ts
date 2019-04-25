import { Component, OnInit } from '@angular/core';
import { CategoryService } from 'src/service/category.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  categories = [];

  constructor(private categoryService: CategoryService) { 

  }

  ngOnInit() {
    this.categories = this.categoryService.getAllCategory();
  }

}
