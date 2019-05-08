import { Injectable } from '@angular/core';
import { BehaviorSubject, Subject } from 'rxjs';
import { CartItem } from 'src/models/item';
import { ProductDetail } from 'src/models/productDetail';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  cartItems: CartItem[] = JSON.parse(localStorage.getItem('carItems')) || [];
  cartSubject: BehaviorSubject<CartItem[]> = new BehaviorSubject<CartItem[]>(this.cartItems);
  constructor() { }

  addItem(product: ProductDetail, quantity: number): any {
    // calculate
    this.cartItems = JSON.parse(localStorage.getItem('carItems')) || [];
    if (this.cartItems) {
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
    } else {
      this.cartItems.push(new CartItem(product.productId, quantity));
    }
    localStorage.setItem('carItems',JSON.stringify(this.cartItems));
    this.cartSubject.next(this.cartItems);
  }

  removeItem(productId: number): any {
    // calculate
    this.cartItems = this.cartItems.filter(i => {
      return i.id === productId;
    });
    localStorage.setItem('carItems',JSON.stringify(this.cartItems));
    this.cartSubject.next(this.cartItems);
  }

  changeItemQuantity(productId: number, quantity: number): any {
    let item = this.cartItems.find(i => {
      return i.id === productId;
    });
    if (item) {
      item.quantity = quantity;
      localStorage.setItem('carItems',JSON.stringify(this.cartItems));
      this.cartSubject.next(this.cartItems);
    }
  }

  getAllItems() {
    return this.cartItems;
  }

}
