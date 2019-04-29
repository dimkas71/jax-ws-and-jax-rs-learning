package ua.selftaught.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("calculator")
public class CalculatorResource {
	
	public enum Operation {
		ADD("add"),
		SUB("sub"),
		MUL("mul"),
		DIV("div"),
		NOP("nop");
		
		@SuppressWarnings("unused")
		private String name;
		
		Operation(String aName) {
			this.name = aName;
		}
	}
	
	
	@GET
	@Path("/{op}")
	@Produces(MediaType.APPLICATION_JSON)
	public Result calculate(@PathParam("op") String operation, @QueryParam("op1") int op1, @QueryParam("op2") int op2) {
		
		int result;
		Operation op = Operation.NOP;
		
		try {
			op = Operation.valueOf(operation.toUpperCase());
		} catch (IllegalArgumentException ex) {
			
		}
		
		switch (op) {
		case ADD:
			result = op1 + op2;
			break;
		case SUB:
			result = op1 - op2;
			break;
		case MUL:
			result = op1 * op2;
			break;
		case DIV:
			result = op1 / op2;
			break;
		default:
			result = Integer.MIN_VALUE;
			break;
		}
		
		
		return new Result(op.toString().toLowerCase(), result);
	}

}
