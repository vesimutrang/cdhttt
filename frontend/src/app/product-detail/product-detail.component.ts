import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/service/product.service';
import { CartService } from 'src/service/cart.service';
import { ProductDetail } from 'src/models/productDetail';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.scss']
})
export class ProductDetailComponent implements OnInit {
  product: ProductDetail;
  quantity: number = 1;
  constructor(private productService: ProductService,
    private cartService: CartService) { }

  ngOnInit() {
    this.product = this.productService.getProduct(1);
  }

  addingItemToCart() {
    this.cartService.addItem(this.product, this.quantity);
  }
}
