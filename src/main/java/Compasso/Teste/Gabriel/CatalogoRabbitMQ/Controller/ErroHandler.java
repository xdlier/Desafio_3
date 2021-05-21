package Compasso.Teste.Gabriel.CatalogoRabbitMQ.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import Compasso.Teste.Gabriel.CatalogoRabbitMQ.Model.Erro;

@RestControllerAdvice
public class ErroHandler {

	@ExceptionHandler(value = { Exception.class })
	public Erro hanlder(Exception e, WebRequest request) {
		if (e.getMessage().equals("No value present")) {
			return new Erro(404);
		} else {
			return new Erro(400);
		}
	}
}

