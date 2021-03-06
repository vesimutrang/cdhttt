import { Injectable } from '@angular/core';
import { Image } from 'src/models/image';
import { IImage } from 'ng-simple-slideshow/src/app/modules/slideshow/IImage';
import { ProductDetail } from 'src/models/productDetail';
import { HttpClient } from '@angular/common/http';
import { ProductShort } from 'src/models/product';
import { Observable } from 'rxjs/internal/Observable';
import { catchError } from 'rxjs/operators';
import { Item } from 'src/models/item';
import { BaseResponse } from 'src/models/baseResponse';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

    constructor(private http: HttpClient) { }

    public createOrder(customerId: number, receiverPhoneNumber: String,
         shippingAddress: String, note: String, paymentMethod: number,
         code: String, isGiftWrapping: boolean, issueAnInvoice: boolean,
         items: Item[], amount: number): Promise<BaseResponse<Boolean>> {
             const params = {
                "customerId": customerId,
                "receiverPhoneNumber" : receiverPhoneNumber,
                "shippingAddress" : shippingAddress,
                "note": note,
                "paymentMethod": paymentMethod, // 1: COD, 2: ATM
                "code": code,
                "isGiftWrapping": isGiftWrapping,
                "issueAnInvoice": issueAnInvoice,
                "items": items,
                "amount": amount
            }
        return this.http.post<BaseResponse<Boolean>>('/api/order', params).toPromise();
    }
}