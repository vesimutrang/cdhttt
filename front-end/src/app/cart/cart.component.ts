import { Component, OnInit, OnDestroy } from '@angular/core';
import { CartItem } from '../../models/item';
import { CartService } from '../../service/cart.service';
import { ProductService } from '../../service/product.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit, OnDestroy {
  cartItems: CartItem[];
  products = [];
  constructor(private cartService: CartService,
    private productService: ProductService) { }

  ngOnInit() {
    this.cartService.cartSubject.subscribe(cartItems => {
      // this.cartItems = cartItems;
      // load all items

      //just for development
      this.products = this.productService.getNewProducts();
      this.products.forEach(product => {
        product['buyingQuantity'] = 1;
        product['amount'] = product['buyingQuantity'] * product['price'];
      });
    });
  }

  ngOnDestroy(): void {
    this.cartService.cartSubject.unsubscribe();
  }

  onQuantityChange(item, value){
    item['buyingQuantity'] = value;
    item['amount'] = item['buyingQuantity'] * item['price'];
    console.log(item['buyingQuantity'],item['price'], item.amount);
    console.log(value);
  }
}
