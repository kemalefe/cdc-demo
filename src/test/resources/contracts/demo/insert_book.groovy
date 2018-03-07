import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description "should insert book and return id"

	request {
		url "/book-service/books"
		headers {
			contentType applicationJson()
		}
		method POST()
		body (
			id: 2,
			name: "Fi",
			author: "Azra Kohen",
			price: 18.00
		)
	}

	response {
		status 201
		headers {
			contentType applicationJson()
		}
		body (
			id: 2
		)
	}
}