import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  categories = [
    {
        "categoryId": 1,
        "categoryName" : "Màn hình, bàn phím, chuột",
        "shortDescription": "Màn hình, bàn phím, chuột các loại Dell, LG, Sony, Samsung..",
        "image": "base64/.."
    },
    {
        "categoryId": 2,
        "categoryName" : "Bộ nhớ RAM, HHD, SSD, USB",
        "shortDescription": "Bộ nhớ RAM, HHD, SSD, USB",
        "image": "base64/.."
    },
    {
        "categoryId": 3,
        "categoryName" : "Bộ vi xử lý Intel, ADM..",
        "shortDescription": "Bộ vi xử lý Intel, ADM..",
        "image": "base64/.."
    },
    {
        "categoryId": 4,
        "categoryName" : "Bộ Pc gamming, office, graphic",
        "shortDescription": "Bộ Pc gamming, office, graphic",
        "image": "base64/.."
    },
    {
        "categoryId": 5,
        "categoryName" : "Tự build máy",
        "shortDescription": "Tự chọn linh kiện và build pc phù hợp với bạn",
        "image": "base64/.."
    },
    {
        "categoryId": 6,
        "categoryName" : "Sản phẩm khác",
        "shortDescription": "Tản nhiệt, bộ nguồn, case..",
        "image": "base64/.."
    }
  ]
  constructor() { }

  public getAllCategory() {
    return this.categories;
  }
}
