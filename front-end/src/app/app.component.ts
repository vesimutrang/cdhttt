import { Component, OnInit } from '@angular/core';
import { CartService } from 'src/service/cart.service';
import { CartItem } from 'src/models/item';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'front-end';
  username: string = 'Phi Nguyễn';
  cartItems: CartItem[] = [];
  constructor(private cartService: CartService,
    private route: ActivatedRoute,
    private router: Router){

  }

  ngOnInit(): void {
    this.cartService.cartSubject.subscribe(cartItems => {
      this.cartItems = cartItems;
    });
  }

  goToCart() {
    this.router.navigate(['cart']);
  }
}
