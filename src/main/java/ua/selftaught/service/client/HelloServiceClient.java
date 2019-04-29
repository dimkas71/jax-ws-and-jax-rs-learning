package ua.selftaught.service.client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import ua.selftaught.service.HelloService;
public class HelloServiceClient {

	public static void main(String[] args) throws MalformedURLException {
		
		final String NAMESPACE = "http://service.selftaught.ua/";
		URL url = new URL("http://localhost:1986/wss/hello?wsdl");
		
		QName qName = new QName(NAMESPACE, "HelloServiceImplService");
		
		Service service = Service.create(url, qName);
		
		HelloService client = service.getPort(HelloService.class);
		
		
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
