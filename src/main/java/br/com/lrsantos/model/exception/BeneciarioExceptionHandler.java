package br.com.lrsantos.model.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BeneciarioExceptionHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return super.handleHttpMessageNotReadable(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<Erro> erros = this.criaLista(ex.getBindingResult());
		return this.handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	private List<Erro> criaLista(BindingResult res) {
		List<Erro> erros = new ArrayList<>();
		
		for(FieldError error : res.getFieldErrors()) {
			erros.add(new Erro(error.toString()));
		}
		return erros;
	}
	
	static class Erro {
		private String mensagem ;
		
		public Erro(String mensagem) {
			super();
			this.mensagem = mensagem;
		}

		public String getMensagem() {
			return mensagem;
		}
		
		
	}

	

}
