package com.walterpaulo.geradorVersiculo.exeption.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.walterpaulo.geradorVersiculo.dto.ErrorDTO;

@ControllerAdvice
public class VersiculoControllerAdvice extends ResponseEntityExceptionHandler {

	@ResponseBody
	@ExceptionHandler(VersiculoNotFoundExcpetion.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorDTO versiculoNotFoundExcpetion(VersiculoNotFoundExcpetion versiculoNotFoundExcpetion) {
		ErrorDTO erro = new ErrorDTO();
		erro.setStatus(HttpStatus.NOT_FOUND.value());
		erro.setMessage("Versículo não encontrado");
		erro.setTimestamp(LocalDateTime.now());

		return erro;
	}

	@ResponseBody
	@ExceptionHandler(NullPointerException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorDTO versiculoNotFoundExcpetionhandleException(Exception ex, WebRequest request) {
//		List<String> urls = Arrays.asList(request.getDescription(false).replace("uri=", "").split("/"));

		ErrorDTO erro = new ErrorDTO();
		erro.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		erro.setMessage("Versículo não encontrado");
		erro.setTimestamp(LocalDateTime.now());

		return erro;
	}

}
