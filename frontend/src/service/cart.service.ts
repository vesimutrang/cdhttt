import { Injectable } from '@angular/core';
import { BehaviorSubject, Subject } from 'rxjs';
import { Item } from 'src/models/item';
import { ProductDetail } from 'src/models/productDetail';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  items: Item[] = JSON.parse(localStorage.getItem('items')) || [];
  cartSubject: BehaviorSubject<Item[]> = new BehaviorSubject<Item[]>(this.items);
  constructor() { }

  addItem(product: ProductDetail, quantity: number): any {
    // calculate
    this.items = JSON.parse(localStorage.getItem('items')) || [];
    if (this.items) {
      let item = this.items.find(i => {
        return i.id === product.id;
      });
      if (item) {
        item.quantity += quantity;
        if (item.quantity > product.maxQuantity) {
          item.quantity = product.maxQuantity;
        }
      } else {
        this.items.push(new Item(product.id, quantity));
      }
    } else {
      this.items.push(new Item(product.id, quantity));
    }
    localStorage.setItem('items',JSON.stringify(this.items));
    this.cartSubject.next(this.items);
  }

  removeItem(productId: number): any {
    // calculate
    this.items = this.items.filter(i => {
      return i.id !== productId;
    });
    localStorage.setItem('items',JSON.stringify(this.items));
    this.cartSubject.next(this.items);
  }

  changeItemQuantity(productId: number, quantity: number): any {
    let item = this.items.find(i => {
      return i.id === productId;
    });
    if (item) {
      item.quantity = quantity;
      localStorage.setItem('items',JSON.stringify(this.items));
      this.cartSubject.next(this.items);
    }
  }

  getAllItems() {
    return this.items;
  }

  cleanAll() {
    localStorage.removeItem("items");
    this.items = [];
    this.cartSubject.next(this.items);
  }
}
