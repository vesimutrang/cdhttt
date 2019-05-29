import { Component, OnInit, OnDestroy } from '@angular/core';
import { CartService } from 'src/service/cart.service';
import { ProductService } from 'src/service/product.service';
import { ProductShort } from 'src/models/product';
import { FormGroup, FormControl, Validators, AbstractControl } from '@angular/forms';
import { OrderService } from 'src/service/order.service';
import { Item } from 'src/models/item';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.scss']
})
export class CheckoutComponent implements OnInit, OnDestroy {
  private products: ProductShort[] = [];
  private sumOfAmount: number = 0;
  private disableCheckoutButton:Boolean;
  private items: Item[];
  private myGroup: FormGroup = new FormGroup({
    customerName: new FormControl({ value: 'Phi Nguyễn', disabled: true }, Validators.required),
    customerPhoneNumber: new FormControl({ value: '', disabled: true }, Validators.required),
    shippingAdress: new FormControl({ value: '51A đường Phan Đăng Lưu, Phường 3, quận Phú Nhuận, Tp Hồ Chí Minh', disabled: false }, Validators.required),
    note: new FormControl(),
    paymentMethod: new FormControl(),
    code: new FormControl(),
    isGiftWrapping: new FormControl(),
    receiverPhoneNumber: new FormControl({ value: '', disabled: true }, Validators.required),
    issueAnInvoice: new FormControl(),
  });
  constructor(private productService: ProductService,
    private cartService: CartService,
    private orderService: OrderService) {
    this.items = this.cartService.getAllItems();
    this.items.forEach(item => {
      productService.getProductShort(item.id).then(product => {
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
    const receiverPhoneNumber = this.myGroup.get("receiverPhoneNumber").value;
    const shippingAddress = this.myGroup.get("shippingAdress").value;
    const note = this.myGroup.get("note").value;
    const paymentMethod = this.myGroup.get("paymentMethod").value;
    const code = this.myGroup.get("code").value;
    const isGiftWrapping = this.myGroup.get("isGiftWrapping").value;
    const issueAnInvoice = this.myGroup.get("issueAnInvoice").value;
    this.orderService.createOrder(1, receiverPhoneNumber,
      shippingAddress, note, paymentMethod,
      code, isGiftWrapping, issueAnInvoice,
      this.items, this.sumOfAmount).then(response => {
        console.log("create order successfully");
      },
      error => {
        console.log("FAILED cmnr!");
      });
  }

  ngOnInit() {
    this.myGroup.get('isGiftWrapping').valueChanges.subscribe(value => {
      if (value) {
        this.myGroup.get('receiverPhoneNumber').enable();
      } else {
        this.myGroup.get('receiverPhoneNumber').disable();
      }
    });
    this.disableCheckoutButton = this.myGroup.valid;
    this.myGroup.valueChanges.subscribe((changedObj: any) => {
      this.disableCheckoutButton = this.myGroup.valid;
    });
  }

  ngOnDestroy(): void {
  }

}
