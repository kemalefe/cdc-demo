import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description "should update book and return"

	request {
		url "/book-service/books/3"
		headers {
			contentType applicationJson()
		}
		method PUT()
		body (
			id: 3,
			name: "1984",
			author: "George Orwell",
			price: 40.00
		)
	}

	response {
		status 200
		headers {
			contentType applicationJson()
		}
		body (
			id: 3,
			name: "1984",
			author: "George Orwell",
			price: 40.00
		)
	}
}