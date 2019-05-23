import { Component, OnInit, OnDestroy } from '@angular/core';
import { CartService } from 'src/service/cart.service';
import { ProductService } from 'src/service/product.service';
import { ProductShort } from 'src/models/product';
import { FormGroup, FormControl, Validators, AbstractControl } from '@angular/forms';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.scss']
})
export class CheckoutComponent implements OnInit, OnDestroy {
  private products: ProductShort[] = [];
  private sumOfAmount: number = 0;
  private myGroup:FormGroup = new FormGroup({
    customerName: new FormControl({value: 'Phi Nguyễn', disabled: true}, Validators.required),
    customerPhoneNumber: new FormControl({value: '', disabled: true}, Validators.required),
    shippingAdress: new FormControl({value: '51A đường Phan Đăng Lưu, Phường 3, quận Phú Nhuận, Tp Hồ Chí Minh', disabled: false}, Validators.required),
    note: new FormControl(),
    paymentMethod: new FormControl(),
    code: new FormControl(),
    isGiftWrapping: new FormControl(),
    receiverPhoneNumber: new FormControl({value: '', disabled: true}, Validators.required),
    issueAnInvoice: new FormControl(),
 });
  constructor(private productService: ProductService,
    private cartService: CartService) {
    this.cartService.getAllItems().forEach(item => {
      productService.getProductShortMock(item.id).then(product => {
        this.products.push(product.data);
        this.products.forEach(product => {
          product['buyingQuantity'] = item.quantity;
          product['amount'] = product['buyingQuantity'] * product['price'];
          this.sumOfAmount += product['amount'];
        });
      });
    });
  }
  checkout() {
    
  }
  
  ngOnInit() {
    this.myGroup.get('isGiftWrapping').valueChanges.subscribe(value => {
      if (value) {
        this.myGroup.get('receiverPhoneNumber').enable();
      } else {
        this.myGroup.get('receiverPhoneNumber').disable();
      }
    });
  }
  
  ngOnDestroy(): void {
  }

}
