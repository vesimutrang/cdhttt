export class OrderResponse {
    errorMessage: String;
	data: boolean;

	constructor($errorMessage: String, $data: boolean) {
		this.errorMessage = $errorMessage;
		this.data = $data;
	}
    
}