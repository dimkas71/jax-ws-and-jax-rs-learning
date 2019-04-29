package ua.selftaught.service.client;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class HelloServiceClient {

	public static void main(String[] args) {
		HelloService client = new HelloServiceImplService().getHelloServiceImplPort();
		
		try {
			List<String> names = Files.readAllLines(
					Paths.get("/home/dimkas71/new-eclipse-workspace/jax-ws-and-jax-rs-learning/src/main/resources/names.txt")
					)
					.stream()
					.map(String::trim)
					.collect(Collectors.toList());
			
			names.stream()
				.forEach(n -> System.out.println(client.getMessage(n)));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
