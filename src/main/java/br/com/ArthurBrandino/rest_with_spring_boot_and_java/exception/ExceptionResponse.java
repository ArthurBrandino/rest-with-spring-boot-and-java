package br.com.ArthurBrandino.rest_with_spring_boot_and_java.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String menssage, String details) {}
