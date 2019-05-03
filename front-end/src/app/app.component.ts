import { Component, OnInit } from '@angular/core';
import { CartService } from 'src/service/cart.service';
import { CartItem } from 'src/models/item';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'front-end';
  username: string = 'Phi Nguyễn';
  cartItems: CartItem[] = [];
  constructor(private cartService: CartService){

  }

  ngOnInit(): void {
    this.cartService.cartSubject.subscribe(cartItems => {
      this.cartItems = cartItems;
    });
  }
}
