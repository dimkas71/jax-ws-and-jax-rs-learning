package ua.selftaught.jaxrs.test;

import java.util.stream.Stream;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ua.selftaught.jaxrs.Main;
import ua.selftaught.jaxrs.Result;

class ClassResourceTest {
	
	private HttpServer server;
	private WebTarget target;
	
	@BeforeEach
	void setUp() {
		server = Main.startServer();
		
		Client client = ClientBuilder.newClient();
		
		target = client.target(Main.BASE_URI);
		
	}
	
	@ParameterizedTest
	@MethodSource("provider")
	void test(String op, int op1, int op2, int result) {
		Result res = target.path("calculator").path(op).queryParam("op1", op1).queryParam("op2", op2)
			.request(MediaType.APPLICATION_JSON).get(Result.class);
		
		Assertions.assertEquals(result, res.getResult(), () -> "Should be " + result);
		
	}
	
	static Stream<Arguments> provider() {
		return Stream.of(
				Arguments.arguments("add", 1, 2, 3),
				Arguments.arguments("sub", 4, 2, 2),
				Arguments.arguments("mul", 4, 5, 20),
				Arguments.arguments("div", 10, 2, 5),
				Arguments.arguments("add1", 1, 2, Integer.MIN_VALUE)
				);
	}
	
	@AfterEach
	void tearDown() {
		server.shutdownNow();
	}
	
	
}
