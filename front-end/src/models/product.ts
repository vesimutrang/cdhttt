export class Product {
    productId: number;
    categoryId: number;
    productName: String;
    price: number;
    image: String;
    shortDescription: String;

	constructor($productId: number, $categoryId: number, $productName: String, $price: number, $image: String, $shortDescription: String) {
		this.productId = $productId;
		this.categoryId = $categoryId;
		this.productName = $productName;
		this.price = $price;
		this.image = $image;
		this.shortDescription = $shortDescription;
	}
    
}
