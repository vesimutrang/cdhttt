import { Component, OnInit, OnDestroy } from '@angular/core';
import { Item } from '../../models/item';
import { CartService } from '../../service/cart.service';
import { ProductService } from '../../service/product.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductShort } from 'src/models/product';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit, OnDestroy {
  products: ProductShort[] = [];
  sumOfAmount: number = 0;
  constructor(private cartService: CartService,
    private productService: ProductService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    let promises = [];
    this.cartService.getAllItems().forEach(item => {
      let promise = this.productService.getProductShortMock(item.id).then(
        response => {
          const product: ProductShort = response.data;
          product['buyingQuantity'] = item.quantity;
          this.products.push(product);
        },
        error => { }
      )
      promises.push(promise);
    });
    Promise.all(promises).then(data => {
      this.products.forEach(product => {
        product['amount'] = product['buyingQuantity'] * product['price'];
        this.sumOfAmount += product['amount'];
      });
    })
  }

  ngOnDestroy(): void {
    this.cartService.cartSubject.unsubscribe();
  }

  onQuantityChange(item, value) {
    item['buyingQuantity'] = value;
    item['amount'] = item['buyingQuantity'] * item['price'];
    this.sumOfAmount += item['amount'];
    console.log(item['buyingQuantity'], item['price'], item.amount);
    console.log(value);
  }

  checkout() {
    this.router.navigate(['checkout']);
  }
}
