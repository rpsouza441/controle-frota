package br.dev.rodrigopinheiro.FleetControl;

import br.dev.rodrigopinheiro.controleFrota.controller.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@SpringBootTest
class FleetControlApplicationTests {

	private final WebTestClient webTestClient;

	public FleetControlApplicationTests(WebTestClient webTestClient) {
		this.webTestClient = webTestClient;
	}

	@Test
	public void testRegisterUser() {
		UserDto userDTO = new UserDto("test@xyz.com", "password",true);

		webTestClient.post().uri("/users/register")
				.contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromValue(userDTO))
				.exchange()
				.expectStatus().isOk();
	}

}
