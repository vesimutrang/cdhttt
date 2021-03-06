import { Component, OnInit, OnDestroy, Inject } from '@angular/core';
import { CartService } from 'src/service/cart.service';
import { ProductService } from 'src/service/product.service';
import { ProductShort } from 'src/models/product';
import { FormGroup, FormControl, Validators, AbstractControl } from '@angular/forms';
import { OrderService } from 'src/service/order.service';
import { Item } from 'src/models/item';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.scss']
})
export class CheckoutComponent implements OnInit, OnDestroy {
  products: ProductShort[] = [];
  sumOfAmount: number = 0;
  disableCheckoutButton: Boolean;
  disablereceiverPhoneNumberInput: Boolean;
  private items: Item[];
  myGroup: FormGroup = new FormGroup({
    customerName: new FormControl({ value: 'Phi Nguyễn', disabled: true }, Validators.required),
    customerPhoneNumber: new FormControl({ value: '', disabled: true }, Validators.required),
    shippingAdress: new FormControl({ value: '51A đường Phan Đăng Lưu, Phường 3, quận Phú Nhuận, Tp Hồ Chí Minh', disabled: false }, Validators.required),
    note: new FormControl(),
    paymentMethod: new FormControl(1),
    code: new FormControl(),
    isGiftWrapping: new FormControl(false),
    receiverPhoneNumber: new FormControl(),
    issueAnInvoice: new FormControl(false),
  });
  constructor(private productService: ProductService,
    private cartService: CartService,
    private orderService: OrderService,
    private route: ActivatedRoute,
    private router: Router,
    public dialog: MatDialog) {
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
        this.openDialog(true);
      },
        error => {
          this.openDialog(false);
        });
  }

  ngOnInit() {
    let promises = [];
    this.items =this.cartService.getAllItems();
    this.items.forEach(item => {
      let promise = this.productService.getProductShort(item.id).then(
        response => {
          const product: ProductShort = response.data;
          product['buyingQuantity'] = item.quantity;
          this.products.push(product);
        },
        error => { }
      )
      promises.push(promise);
    });
    Promise.all(promises).then(data => {
      this.products.forEach(product => {
        product['amount'] = product['buyingQuantity'] * product['price'];
        this.sumOfAmount += product['amount'];
      });
    })
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

    this.disablereceiverPhoneNumberInput = this.myGroup.get('isGiftWrapping').value;
    this.myGroup.get('isGiftWrapping').valueChanges.subscribe((changedObj: any) => {
      this.disablereceiverPhoneNumberInput = !changedObj;
    });
  }

  ngOnDestroy(): void {
  }

  openDialog(isSuccess: boolean): void {
    const message = isSuccess ? "Quý khách đã đặt hàng thành công, nhấn Ok để trở về trang chủ." : "Thông tin chưa chính xác hoặc đơn hàng quá số lượng còn lại, hãy chỉnh sửa thông tin và thử lại!";
    const dialogRef = this.dialog.open(DialogConfirmation, {
      width: '400px',
      data: message
    });

    dialogRef.afterClosed().subscribe(result => {
      if (isSuccess) {
        this.cartService.cleanAll();
        this.router.navigate(['home']);
      }
    });
  }
}


@Component({
  selector: 'dialog-confirmation',
  templateUrl: 'dialog-confirmation.html',
})
export class DialogConfirmation {

  constructor(
    public dialogRef: MatDialogRef<DialogConfirmation>,
    @Inject(MAT_DIALOG_DATA) public message: String) { }

  onNoClick(): void {
    this.dialogRef.close();
  }

  clickOk(): void {
    this.dialogRef.close();
  }
}