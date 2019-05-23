import { Component, OnInit, OnDestroy } from '@angular/core';
import { ProductService } from 'src/service/product.service';
import { CartService } from 'src/service/cart.service';
import { ProductDetail } from 'src/models/productDetail';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.scss']
})
export class ProductDetailComponent implements OnInit, OnDestroy {
  product: ProductDetail = null;
  quantity: number = 1;
  constructor(private productService: ProductService,
    private cartService: CartService) { 
      this.productService.getProductMock(1).then(product => {
        this.product = product.data;
      });
    }

  ngOnInit() {
  }

  addingItemToCart() {
    this.cartService.addItem(this.product, this.quantity);
  }
  
  ngOnDestroy(): void {
    
  }
}
