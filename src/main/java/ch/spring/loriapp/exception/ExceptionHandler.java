package ch.spring.loriapp.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

	// @org.springframework.web.bind.annotation.ExceptionHandler(value =
	// Exception.class)
	// public ModelAndView exception(Exception exception, WebRequest request) {
	// ModelAndView modelAndView = new ModelAndView("error");
	// modelAndView.addObject("errorMessage",
	// Throwables.getRootCause(exception));
	// return modelAndView;
	// }
}
