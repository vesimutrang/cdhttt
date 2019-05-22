export class ProductShort {
    id: number;
    name: String;
	price: number;
	maxQuantity: number;
    producer: String;
    shortDescription: String;
    image: String;

	constructor($id: number, $name: String, $price: number, $maxQuantity: number, $producer: String, $image: String, $shortDescription: String) {
		this.id = $id;
		this.name = $name;
		this.price = $price;
		this.maxQuantity = $maxQuantity;
		this.producer = $producer;
		this.image = $image;
		this.shortDescription = $shortDescription;
	}
    
}