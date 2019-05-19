import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { IImage } from 'ng-simple-slideshow/src/app/modules/slideshow/IImage';
import { ProductService } from 'src/service/product.service';
import { ProductShort } from 'src/models/product';

@Component({
  selector: 'app-new-products',
  templateUrl: './new-products.component.html',
  styleUrls: ['./new-products.component.scss']
})
export class NewProductsComponent implements OnInit, OnDestroy {
  newProducts: ProductShort[];
  imageSources: IImage[] = [];

  constructor(private route: ActivatedRoute,
    private router: Router,
    private productService: ProductService) {

  }

  ngOnInit() {
    this.productService.getNewProducts().subscribe(productShorts => {
      this.newProducts = productShorts;
    });
    this.imageSources = this.productService.getSlideshows();
  }

  navigate(productId) {
    this.router.navigate(['home/product/' + productId]);
  }
  
  ngOnDestroy(): void {
    
  }
}
