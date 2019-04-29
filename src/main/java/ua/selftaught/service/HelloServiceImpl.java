package ua.selftaught.service;

import javax.jws.WebService;

@WebService(endpointInterface = "ua.selftaught.service.HelloService")
public class HelloServiceImpl implements HelloService {

	@Override
	public String getMessage(String messageTo) {
		return String.format("Hello %s !", messageTo);
	}

}
