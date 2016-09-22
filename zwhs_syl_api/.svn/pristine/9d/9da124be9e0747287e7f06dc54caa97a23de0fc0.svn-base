package cn.org.citycloud.zwhs.syl.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import cn.org.citycloud.zwhs.syl.bean.ErrorResponse;
import cn.org.citycloud.zwhs.syl.constants.ErrorCodes;
import cn.org.citycloud.zwhs.syl.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.syl.exception.TokenValidationException;


/**
 * 全局异常处理
 * @author Lanbo
 *
 */
@ControllerAdvice
public class ApiExceptionHandler {
	
	private Logger logger = LoggerFactory.getLogger(ApiExceptionHandler.class);  
	/**
	 * Token验证异常处理
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(TokenValidationException.class)
	@ResponseStatus(value = HttpStatus.FORBIDDEN)
	@ResponseBody
	public ErrorResponse handleTokenValidationException(TokenValidationException ex) {
		
		return new ErrorResponse("002", ex.getMessage());
	}
	
	/**
	 * 业务异常处理
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(BusinessErrorException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorResponse handleBusinessErrorException(BusinessErrorException ex) {
		
		return new ErrorResponse(ex.getCode(), ex.getMessage());
	}

	@ExceptionHandler(TypeMismatchException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public String handleTypeMismatchException(TypeMismatchException ex) {
		return "Request id must be an integer";
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorResponse handleMethodArgumentNotValidException(
			MethodArgumentNotValidException ex) {
		BindingResult bindingResult = ex.getBindingResult();
		StringBuilder sb = new StringBuilder();
		sb.append("参数错误: ");

		for (FieldError fieldError : bindingResult.getFieldErrors()) {
			sb.append(fieldError.getField());
			sb.append(fieldError.getDefaultMessage());
			sb.append(";");
		}
		return new ErrorResponse(ErrorCodes.INVALID_PARAMETER, sb.toString());
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorResponse handleHttpMessageNotReadableException(
			HttpMessageNotReadableException ex) {
		return new ErrorResponse("008", ex.getMessage());
	}

	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ErrorResponse handleUnexpectedServerError(RuntimeException ex) {
		logger.error(ex.toString());
		return new ErrorResponse("012", ex.getMessage());
	}
}
