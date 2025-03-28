package com.github.rprojetos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

/*

# Autenticação
curl -X POST http://localhost:8080/api/auth/login \
-H "Content-Type: application/json" \
-d '{"username":"admin","password":"123456"}'

curl -X POST http://localhost:8080/api/auth/login \
-H "Content-Type: application/json" \
-d '{"username":"admin","password":"123456"}'


# Resposta esperada (exemplo):
"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNzE2ODM0ODAwLCJleHAiOjE3MTY4Mzg0MDB9.4x9O7sD8vj3kLmZpZ7Xn7Q4X9W7gZvE8dY6X9yT1J4Q"


# Envio da mensagem (usando o token acima)

curl -X POST http://localhost:8080/api/messages \
-H "Authorization: Bearer eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTc0MzE2NTY4MCwiZXhwIjoxNzQzMTY5MjgwfQ.aTFKIDEzXMQB_RxKr6PE5Jpo0BTHZkk-vztGBPOlZ3i0Ktrc2BOxpHJWlGI8GpJX" \
-H "Content-Type: application/json" \
-d '{"message":"Testando Spring Security!"}'

*/
