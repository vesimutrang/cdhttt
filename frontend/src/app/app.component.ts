import { Component, OnInit, OnDestroy } from '@angular/core';
import { CartService } from 'src/service/cart.service';
import { Item } from 'src/models/item';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs/internal/Subscription';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit, OnDestroy {
  title = 'front-end';
  username: string = 'Phi Nguyễn';
  items: Item[] = [];
  cartSubject: Subscription;
  constructor(private cartService: CartService,
    private route: ActivatedRoute,
    private router: Router) {

  }

  ngOnInit(): void {
    this.cartSubject = this.cartService.cartSubject.subscribe(items => {
        this.items = items;
    });
  }

  goToCart() {
    this.router.navigate(['cart']);
  }

  ngOnDestroy(): void {
    if (this.cartSubject) {
      this.cartSubject.unsubscribe();
    }
  }
}
