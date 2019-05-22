import { Image } from 'src/models/image';
export class ProductDetail {
	id: number;
	name: String;
	price: number;
	maxQuantity: number;
	producer: String;
	shortDescription: String;
	description: String;
	image: Image[];

	constructor($id: number, $name: String, $price: number, $maxQuantity: number,
		$producer: String, $shortDescription: String, $description: String, $image: Image[]) {
		this.id = $id;
		this.name = $name;
		this.price = $price;
		this.maxQuantity = $maxQuantity;
		this.producer = $producer;
		this.description = $description;
		this.shortDescription = $shortDescription;
		this.image = $image;
	}


}
