import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  categories = [
    {
        "categoryId": 1,
        "categoryName" : "Màn hình máy tính",
        "shortDescription": "Màn hình máy tính các loại Dell, LG, Sony, Samsung..",
        "image": "base64/.."
    },
    {
        "categoryId": 2,
        "categoryName" : "Chuột máy tính",
        "shortDescription": "Chuột máy tính các loại..",
        "image": "base64/.."
    },
    {
        "categoryId": 3,
        "categoryName" : "Bàn phím máy tính",
        "shortDescription": "Bàn phím cơ, bàn phím giả cơ..",
        "image": "base64/.."
    }
  ]
  constructor() { }

  public getAllCategory() {
    return this.categories;
  }
}
