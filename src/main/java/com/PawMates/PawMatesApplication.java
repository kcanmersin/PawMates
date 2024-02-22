package com.PawMates;

import com.PawMates.core.utilities.exceptions.BusinessException;
import com.PawMates.core.utilities.exceptions.ProblemDetails;
import com.PawMates.core.utilities.exceptions.ValidationProblemsDetails;
//import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tech.ailef.snapadmin.external.SnapAdminAutoConfiguration;

import java.util.HashMap;
@SpringBootApplication

@RestControllerAdvice
//@EnableAdminServer
@ImportAutoConfiguration(SnapAdminAutoConfiguration.class)

public class PawMatesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PawMatesApplication.class, args);
	}
	//AOP
	@ExceptionHandler
	@ResponseStatus(code= HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException) {
		ProblemDetails problemDetails=new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());

		return problemDetails;
	}
	@ExceptionHandler
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
		ValidationProblemsDetails validationProblemDetails=new ValidationProblemsDetails();
		validationProblemDetails.setMessage("VALIDATION.EXCEPTION");
		validationProblemDetails.setValidationErrors(new HashMap<String,String>());

		for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			validationProblemDetails.getValidationErrors().put(fieldError.getField(),fieldError.getDefaultMessage());

		}


		return validationProblemDetails;


	}


	@Bean
	public ModelMapper getModelMapper()
	{
		return new ModelMapper();
	}
}
