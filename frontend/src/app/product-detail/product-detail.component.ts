import { Component, OnInit, OnDestroy } from '@angular/core';
import { ProductService } from 'src/service/product.service';
import { CartService } from 'src/service/cart.service';
import { ProductDetail } from 'src/models/productDetail';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.scss']
})
export class ProductDetailComponent implements OnInit, OnDestroy {
  product: ProductDetail;
  quantity: number = 1;
  constructor(private productService: ProductService,
    private cartService: CartService,
    private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.productService.getProduct(params['id']).then(res => {
        this.product = res.data;
      });
    });
  }

  addingItemToCart() {
    this.cartService.addItem(this.product, this.quantity);
  }

  ngOnDestroy(): void {

  }
}
