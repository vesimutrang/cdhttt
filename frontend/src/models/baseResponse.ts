export class BaseResponse<T> {
    data: T;
    errorMessage: String;

    constructor($data: T, $errorMessage: String) {
		this.data = $data;
		this.errorMessage = $errorMessage;
	}
}