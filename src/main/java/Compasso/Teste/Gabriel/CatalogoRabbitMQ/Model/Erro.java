package Compasso.Teste.Gabriel.CatalogoRabbitMQ.Model;

public class Erro {

	private Integer status_code;
	private String message;

	public Erro(Integer status) {
		this.status_code = status;
		if (status.equals(400)) {
			this.message = "Requisição inválida, tente novamente!";
		} else if (status.equals(404)) {
			this.message = "Item não encontrado, tente novamente!";
		}
	}

	public Integer getStatus_code() {
		return status_code;
	}

	public String getMessage() {
		return message;
	}

}
