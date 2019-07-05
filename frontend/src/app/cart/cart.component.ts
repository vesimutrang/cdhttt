import { Component, OnInit, OnDestroy } from '@angular/core';
import { Item } from '../../models/item';
import { CartService } from '../../service/cart.service';
import { ProductService } from '../../service/product.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductShort } from 'src/models/product';
import { Subscription } from 'rxjs/internal/Subscription';

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
      let promise = this.productService.getProductShort(item.id).then(
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
  }

  onQuantityChange(product: ProductShort, quantity: number) {
    quantity = Number(quantity);
    product['buyingQuantity'] = quantity;
    product['amount'] = product['buyingQuantity'] * product.price;
    this.sumOfAmount += product['amount'];
    this.cartService.changeItemQuantity(product.id, quantity);
  }

  deleteItem(product: ProductShort){
    this.cartService.removeItem(product.id);
    this.products = this.products.filter(pro => {
      return pro.id !== product.id;
    });
  }

  checkout() {
    this.router.navigate(['checkout']);
  }
}
