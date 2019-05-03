import { Injectable } from '@angular/core';
import { BehaviorSubject, Subject } from 'rxjs';
import { CartItem } from 'src/models/item';
import { ProductDetail } from 'src/models/productDetail';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  cartItems: CartItem[] = [];
  cartSubject: BehaviorSubject<CartItem[]> = new BehaviorSubject<CartItem[]>(this.cartItems);
  constructor() { }

  addItem(product: ProductDetail, quantity: number): any {
    // calculate
    let item = this.cartItems.find(i => {
      return i.id === product.productId;
    });
    if (item) {
      item.quantity += quantity;
      if (item.quantity > product.maxQuantity) {
        item.quantity = product.maxQuantity;
      }
    } else {
      this.cartItems.push(new CartItem(product.productId, quantity));
    }
    this.cartSubject.next(this.cartItems);
  }

  removeItem(productId: number): any {
    // calculate
    this.cartItems = this.cartItems.filter(i => {
      return i.id === productId;
    });
    this.cartSubject.next(this.cartItems);
  }

  changeItemQuantity(productId: number, quantity: number): any {
    // calculate
    let item = this.cartItems.find(i => {
      return i.id === productId;
    });
    if (item) {
      item.quantity = quantity;
      this.cartSubject.next(this.cartItems);
    }
  }

}
