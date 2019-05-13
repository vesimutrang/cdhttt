import { Component, OnInit } from '@angular/core';
import { CartService } from 'src/service/cart.service';
import { ProductService } from 'src/service/product.service';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.scss']
})
export class CheckoutComponent implements OnInit {
  products = [];
  sumOfAmount:number = 0;
  constructor(private productService: ProductService,
    private cartService: CartService) {
    this.products = this.productService.getNewProducts();
      this.products.forEach(product => {
        product['buyingQuantity'] = 1;
        product['amount'] = product['buyingQuantity'] * product['price'];
        this.sumOfAmount += product['amount'];
      });
   }

  ngOnInit() {
  }

}
