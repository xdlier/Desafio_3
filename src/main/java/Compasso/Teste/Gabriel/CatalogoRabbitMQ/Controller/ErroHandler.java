package Compasso.Teste.Gabriel.CatalogoRabbitMQ.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import Compasso.Teste.Gabriel.CatalogoRabbitMQ.Model.Erro;

@RestControllerAdvice
public class ErroHandler {

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Erro> hanlder(Exception e, WebRequest request) {
		if (e.getMessage().equals("No value present")) {
			return ResponseEntity.status(404).body(new Erro(404));
		} else {
			return ResponseEntity.badRequest().body(new Erro(400));
		}
	}
}

