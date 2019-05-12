import { Component, OnInit, OnDestroy } from '@angular/core';
import { CartItem } from '../../models/item';
import { CartService } from '../../service/cart.service';
import { ProductService } from '../../service/product.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit, OnDestroy {
  cartItems: CartItem[];
  products = [];
  sumOfAmount:number = 0;
  constructor(private cartService: CartService,
    private productService: ProductService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    this.cartService.cartSubject.subscribe(cartItems => {
      // this.cartItems = cartItems;
      // load all items

      //just for development
      this.products = this.productService.getNewProducts();
      this.products.forEach(product => {
        product['buyingQuantity'] = 1;
        product['amount'] = product['buyingQuantity'] * product['price'];
        this.sumOfAmount += product['amount'];
      });
    });
  }

  ngOnDestroy(): void {
    this.cartService.cartSubject.unsubscribe();
  }

  onQuantityChange(item, value){
    item['buyingQuantity'] = value;
    item['amount'] = item['buyingQuantity'] * item['price'];
    this.sumOfAmount += item['amount'];
    console.log(item['buyingQuantity'],item['price'], item.amount);
    console.log(value);
  }

  checkout() {
    this.router.navigate(['checkout']);
  }
}
