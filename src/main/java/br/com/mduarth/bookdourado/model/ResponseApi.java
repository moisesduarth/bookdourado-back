package br.com.mduarth.bookdourado.model;

import java.util.List;
import java.util.Optional;

import lombok.Data;

@Data
public class ResponseApi<T> {

	private T data;
	private String error;
	
}
