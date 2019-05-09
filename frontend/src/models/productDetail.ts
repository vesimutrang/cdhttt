export class ProductDetail {
    productId: number;
    categoryId: number;
    productName: String;
	price: number;
	maxQuantity: number;
	by: String;
	image: any[];
	description: String;
    shortDescription: String;

	constructor($productId: number, $categoryId: number, $productName: String, $price: number, $maxQuantity: number, $by: String, $image: any[], $description: String, $shortDescription: String) {
		this.productId = $productId;
		this.categoryId = $categoryId;
		this.productName = $productName;
		this.price = $price;
		this.maxQuantity = $maxQuantity;
		this.by = $by;
		this.image = $image;
		this.description = $description;
		this.shortDescription = $shortDescription;
	}
	
    
}
