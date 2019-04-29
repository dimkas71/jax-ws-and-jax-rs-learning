package ua.selftaught.jaxrs.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.selftaught.jaxrs.Main;

class HelloResourceTest {
	
	private HttpServer server;
	private WebTarget target;
	
	@BeforeEach
	void setUp() {
		server = Main.startServer();
		Client client = ClientBuilder.newClient();
		
		target = client.target(Main.BASE_URI);
		
	}
	
	@Test
	void test() {
		String request = target.path("rs").request().get(String.class);
		
		Assertions.assertEquals("Hello world", request, () -> "Should be Hello world");
	}
	
	@AfterEach
	void tearDown() {
		server.shutdownNow();
	}

}
