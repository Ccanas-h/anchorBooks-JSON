package com.edutecno.main;

import com.edutecno.cliente.ClienteBookDetail;
import com.edutecno.cliente.ClienteBookJson;
import com.edutecno.modelo.Book;
import com.edutecno.modelo.BookDetail;

public class Main {
	
	Book book = new Book();
	BookDetail bookDetail1= new BookDetail(); 
	ClienteBookJson bookJson = new ClienteBookJson();
	ClienteBookDetail bookDetail = new ClienteBookDetail();

	public static void main(String[] args) {
	
		ClienteBookJson.obtenerPrimeroListaBook(); //Pregunta 6
		//ClienteBookJson.obtenerAuthorAndTitle(); //Pregunta 7
		//ClienteBookJson.obtenerAuthorTitleCountry(); //Pregunta 8
		//ClienteBookDetail.obtener1erDetail(); //Pregunta 9
		
		//ClienteBookJson.obtenerAuthorUnkown(); //Pregunta 10 Aqui no pude obtener desde getTitle() == "Unknown" ¿Por que sera?
		
		//ClienteBookDetail.obtenerDeliveryTrue(); //Pregunta 11
		
	}

}
