import { Injectable } from '@angular/core';
import { IImage } from 'ng-simple-slideshow/src/app/modules/slideshow/IImage';
import { ProductDetail } from 'src/models/productDetail';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  newProducts = [
    {
        "productId": 1,
        "categoryId": 1,
        "productName" : "DELL SE2419H",
        "price": 4294000,
        "shortDescription": "Màn Hình Máy Tính Dell (DELL) SE2419H (23.8 inch)",
        "image": "base64/.."
    },
    {
        "productId": 2,
        "categoryId": 1,
        "productName" : "Dell P2418D",
        "price": 7795000,
        "shortDescription": "Màn Hình Dell P2418D 23.8 Inch 2K",
        "image": "base64/.."
    },
    {
        "productId": 3,
        "categoryId": 1,
        "productName" : "Dell P2418D",
        "price": 7346000,
        "shortDescription": "Màn Hình Dell U2412M 24 Inch 16:10",
        "image": "base64/.."
    },
    {
      "productId": 1,
      "categoryId": 1,
      "productName" : "DELL SE2419H",
      "price": 4294000,
      "shortDescription": "Màn Hình Máy Tính Dell (DELL) SE2419H (23.8 inch)",
      "image": "base64/.."
    },
    {
        "productId": 2,
        "categoryId": 1,
        "productName" : "Dell P2418D",
        "price": 7795000,
        "shortDescription": "Màn Hình Dell P2418D 23.8 Inch 2K",
        "image": "base64/.."
    },
    {
        "productId": 3,
        "categoryId": 1,
        "productName" : "Dell P2418D",
        "price": 7346000,
        "shortDescription": "Màn Hình Dell U2412M 24 Inch 16:10",
        "image": "base64/.."
    },
    {
      "productId": 1,
      "categoryId": 1,
      "productName" : "DELL SE2419H",
      "price": 4294000,
      "shortDescription": "Màn Hình Máy Tính Dell (DELL) SE2419H (23.8 inch)",
      "image": "base64/.."
    },
    {
        "productId": 2,
        "categoryId": 1,
        "productName" : "Dell P2418D",
        "price": 7795000,
        "shortDescription": "Màn Hình Dell P2418D 23.8 Inch 2K",
        "image": "base64/.."
    },
    {
        "productId": 3,
        "categoryId": 1,
        "productName" : "Dell P2418D",
        "price": 7346000,
        "shortDescription": "Màn Hình Dell U2412M 24 Inch 16:10",
        "image": "base64/.."
    }
  ]

  slideshows: IImage[] = [
    {
      'url': 'assets/images/slideshow/slideshow_1.jpg',
      'href': 'string',
      'caption': 'string',
      'title': 'string',
      'backgroundSize': 'string',
      'backgroundPosition': 'string',
      'backgroundRepeat': 'string'
    },
    {
      'url': 'assets/images/slideshow/slideshow_2.jpg',
      'href': 'string',
      'caption': 'string',
      'title': 'string',
      'backgroundSize': 'string',
      'backgroundPosition': 'string',
      'backgroundRepeat': 'string'
    },
    {
      'url': 'assets/images/slideshow/slideshow_3.jpg',
      'href': 'string',
      'caption': 'string',
      'title': 'string',
      'backgroundSize': 'string',
      'backgroundPosition': 'string',
      'backgroundRepeat': 'string'
    },
    {
      'url': 'assets/images/slideshow/slideshow_4.jpg',
      'href': 'string',
      'caption': 'string',
      'title': 'string',
      'backgroundSize': 'string',
      'backgroundPosition': 'string',
      'backgroundRepeat': 'string'
    }
  ]
  
  product = {
      "productId": 1,
      "productName" : "DELL SE2419H",
      "price": 4294000,
      "quantity": 20,
      "by": "dell",
      "shortDescription": "Màn Hình Máy Tính Dell (DELL) SE2419H (23.8 inch)",
      "description" : "<h3>Thiết kế đơn giản gọn nhẹ </h3> <br> Màn Hình Dell S2216H 23.8 inch IPS - Full HD được thiết kế phù hợp với không gian văn phòng với thiết kế, nhỏ họn nhưng chắc chắn được đặt trên đế chắc chắn, giúp giải phóng không gian làm việc, tạo sự thoải mái khi làm việc cho người dùng.Điều chỉnh theo sự thoải mái của bạn: nghiêng và điều chỉnh chiều cao của màn hình cho một thiết lập thoải mái suốt cả ngày.<h3>Thiết kế màn hình mỏng tạo không giản làm việc thoải mái</h3> <br> Thiết kế bezel siêu mỏng ba mặt cho phép bạn tận hưởng chế độ xem không bị gián đoạn nội dung của bạn trên nhiều màn hình. Và với màn hình kép, bạn có thể tăng năng suất lên đến 18%.",
      "image": [
          {
              "imageId": 1,
              "tooltip": "thiết kế sang trọng",
              "source": "base64/.."
          },
          {
              "imageId": 2,
              "tooltip": "bla bla bla bla",
              "source": "base64/.."
          }
      ]
  }

  constructor() { }

  public getNewProducts() {
    return this.newProducts;
  }

  public getSlideshows() {
    return this.slideshows;
  }

  public getProduct(id): ProductDetail {
    const product = new ProductDetail(1,1,'DELL SE2419H',4294000,20,'dell',[{"imageId": 1,"tooltip": "thiết kế sang trọng","source": "base64/.."},
  {"imageId": 2,"tooltip": "bla bla bla bla","source": "base64/.."}],
  "<h3>Thiết kế đơn giản gọn nhẹ </h3> <br> Màn Hình Dell S2216H 23.8 inch IPS - Full HD được thiết kế phù hợp với không gian văn phòng với thiết kế, nhỏ họn nhưng chắc chắn được đặt trên đế chắc chắn, giúp giải phóng không gian làm việc, tạo sự thoải mái khi làm việc cho người dùng.Điều chỉnh theo sự thoải mái của bạn: nghiêng và điều chỉnh chiều cao của màn hình cho một thiết lập thoải mái suốt cả ngày.<h3>Thiết kế màn hình mỏng tạo không giản làm việc thoải mái</h3> <br> Thiết kế bezel siêu mỏng ba mặt cho phép bạn tận hưởng chế độ xem không bị gián đoạn nội dung của bạn trên nhiều màn hình. Và với màn hình kép, bạn có thể tăng năng suất lên đến 18%.",
  "Màn Hình Máy Tính Dell (DELL) SE2419H (23.8 inch)");
    return product;
  }
}
