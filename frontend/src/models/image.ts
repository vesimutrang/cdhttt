export class Image {
    id: number;
    name: String;
	description: String;
	source: String;

    constructor($id: number, $name: String, $description: String, $source: String) {
		this.id = $id;
		this.name = $name;
		this.description = $description;
		this.source = $source;
	}
}