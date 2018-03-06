import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description "should return book by id=1"

	request {
		url "/book-service/books/1"
		method GET()
	}

	response {
		status 200
		headers {
			contentType applicationJson()
		}
		body (
			id: 1,
			name: "Nutuk",
			author: "Gazi M.Kemal Atatürk",
			price: 20.00
		)
	}
}