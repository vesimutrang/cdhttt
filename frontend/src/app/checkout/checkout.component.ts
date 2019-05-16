import { Component, OnInit, OnDestroy } from '@angular/core';
import { CartService } from 'src/service/cart.service';
import { ProductService } from 'src/service/product.service';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.scss']
})
export class CheckoutComponent implements OnInit, OnDestroy {
  products = [];
  sumOfAmount: number = 0;
  constructor(private productService: ProductService,
    private cartService: CartService) {
    this.products = this.productService.getNewProductsMock();
    this.products.forEach(product => {
      product['buyingQuantity'] = 1;
      product['amount'] = product['buyingQuantity'] * product['price'];
      this.sumOfAmount += product['amount'];
    });
  }
  checkout() {
    
  }
  ngOnInit() {
  }
  
  ngOnDestroy(): void {
  }

}
