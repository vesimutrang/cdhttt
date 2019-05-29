import { Injectable } from '@angular/core';
import { Image } from 'src/models/image';
import { IImage } from 'ng-simple-slideshow/src/app/modules/slideshow/IImage';
import { ProductDetail } from 'src/models/productDetail';
import { HttpClient } from '@angular/common/http';
import { ProductShort } from 'src/models/product';
import { Observable } from 'rxjs/internal/Observable';
import { catchError } from 'rxjs/operators';
import { BaseResponse } from 'src/models/baseResponse';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }

  public getNewProducts(): Observable<BaseResponse<ProductShort[]>> {
    return this.http.get<BaseResponse<ProductShort[]>>('/api/newProducts').pipe(
      catchError((error, reason) => {
        this.handleError("cannot get new products", reason);
        return reason;
      })
    );
  }

  public getProduct(id: number): Promise<BaseResponse<ProductDetail>> {
    return this.http.get<BaseResponse<ProductDetail>>('/api/productDetail?productId=' + id).toPromise();
  }

  public getProductShort(id: number): Promise<BaseResponse<ProductShort>> {
    return this.http.get<BaseResponse<ProductShort>>('/api/productShort?productId=' + id).toPromise();
  }

  handleError(message: string, input: any): any {
    console.error(message, input);
  }

  // public getProductMock(id: number): Promise<BaseResponse<ProductDetail>> {
  //   const product = new ProductDetail(Math.floor(Math.random() * Math.floor(10)),
  //     'DELL SE2419H',
  //     4294000,
  //     20,
  //     'dell',
  //     "Màn Hình Máy Tính Dell (DELL) SE2419H (23.8 inch)",
  //     "<h3>Thiết kế đơn giản gọn nhẹ </h3> <br> Màn Hình Dell S2216H 23.8 inch IPS - Full HD được thiết kế phù hợp với không gian văn phòng với thiết kế, nhỏ họn nhưng chắc chắn được đặt trên đế chắc chắn, giúp giải phóng không gian làm việc, tạo sự thoải mái khi làm việc cho người dùng.Điều chỉnh theo sự thoải mái của bạn: nghiêng và điều chỉnh chiều cao của màn hình cho một thiết lập thoải mái suốt cả ngày.<h3>Thiết kế màn hình mỏng tạo không giản làm việc thoải mái</h3> <br> Thiết kế bezel siêu mỏng ba mặt cho phép bạn tận hưởng chế độ xem không bị gián đoạn nội dung của bạn trên nhiều màn hình. Và với màn hình kép, bạn có thể tăng năng suất lên đến 18%.",
  //     [new Image(1, "dell.jpg", "thiết kế sang trọng", "base64/.."),
  //     new Image(2, "dell.jpg", "thiết kế sang trọng", "base64/..")]);
  //     return new Promise(resolve => {
  //       resolve(new BaseResponse(product, null));
  //     });
  // }

  // public getProductShortMock(id: number): Promise<BaseResponse<ProductShort>> {
  //   let product:ProductShort = new ProductShort(1, "DELL 12312Bsd", 7000000, 24, "Dell", "base64/..", "Màn Hình Máy Tính Dell (DELL) SE2419H (23.8 inch)");
  //   return new Promise(resolve => {
  //     resolve(new BaseResponse(product,null));
  //   });
  // }

  public getSlideshows() {
    return this.slideshows;
  }

  slideshows: IImage[] = [
    {
      'url': 'assets/images/slideshow/slideshow_1.jpg',
      'href': '/home/product/1',
      'caption': 'Giảm giá cực hot: VGA 1060, VAG 1050Ti',
      'title': 'Giảm giá cực hot: VGA 1060, VAG 1050Ti',
      'backgroundSize': 'string',
      'backgroundPosition': 'string',
      'backgroundRepeat': 'string'
    },
    {
      'url': 'assets/images/slideshow/slideshow_2.jpg',
      'href': '/home/product/1',
      'caption': 'Tản nhiệt Infinity',
      'title': 'Tản nhiệt Infinity',
      'backgroundSize': 'string',
      'backgroundPosition': 'string',
      'backgroundRepeat': 'string'
    },
    {
      'url': 'assets/images/slideshow/slideshow_3.jpg',
      'href': '/home/product/1',
      'caption': 'Infinity Rampage',
      'title': 'Infinity Rampage',
      'backgroundSize': 'string',
      'backgroundPosition': 'string',
      'backgroundRepeat': 'string'
    },
    {
      'url': 'assets/images/slideshow/slideshow_4.jpg',
      'href': '/home/product/1',
      'caption': 'Siêu khuyến mãi save up to 50%',
      'title': 'Siêu khuyến mãi save up to 50%',
      'backgroundSize': 'string',
      'backgroundPosition': 'string',
      'backgroundRepeat': 'string'
    }
  ]


}
