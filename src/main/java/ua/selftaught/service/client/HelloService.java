
package ua.selftaught.service.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Action;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HelloService", targetNamespace = "http://service.selftaught.ua/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface HelloService {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://service.selftaught.ua/HelloService/getMessageRequest", output = "http://service.selftaught.ua/HelloService/getMessageResponse")
    public String getMessage(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

}
