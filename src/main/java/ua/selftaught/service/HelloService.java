package ua.selftaught.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface HelloService {
	
	@WebMethod
	String getMessage(String messageTo);

}
