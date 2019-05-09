import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { IImage } from 'ng-simple-slideshow/src/app/modules/slideshow/IImage';
import { ProductService } from 'src/service/product.service';

@Component({
  selector: 'app-new-products',
  templateUrl: './new-products.component.html',
  styleUrls: ['./new-products.component.scss']
})
export class NewProductsComponent implements OnInit {
  newProducts = [];
  imageSources: IImage[] = [];
  
  constructor(private route: ActivatedRoute,
    private router: Router,
    private productService: ProductService) {
      
  }

  ngOnInit() {
    this.newProducts = this.productService.getNewProducts();
    this.imageSources = this.productService.getSlideshows();
  }

  navigate(productId) {
    this.router.navigate(['home/product/'+ productId]);
  }
}
