import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/service/product.service';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.scss']
})
export class ProductDetailComponent implements OnInit {
  product = {};
  constructor(private productService: ProductService) { }

  ngOnInit() {
    this.product = this.productService.getProduct(1);
  }

}
