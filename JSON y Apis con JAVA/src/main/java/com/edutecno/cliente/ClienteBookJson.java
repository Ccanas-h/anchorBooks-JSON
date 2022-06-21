package com.edutecno.cliente;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.edutecno.modelo.Book;



public class ClienteBookJson {

		// Se crea el método para obtener la lista de todos los libros desde la primera API e imprimirlos en pantalla.		

		public static void obtenerPrimeroListaBook() {
			
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("https://my-json-server.typicode.com").path("Himuravidal").path("anchorBooks").path("books");
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON); 
		Response respuestaBook = invocationBuilder.get();
		
		List<Book> listaBook = 
				respuestaBook.readEntity(new GenericType<List<Book>>(){});
		
		for (Book book : listaBook) {
			
			System.out.println("Book [id="+book.getId() + ", author="+book.getAuthor() + ", country="+book.getCountry() + ",\n"+
					"imageLink="+book.getImageLink() + ",\n language="+book.getLanguage() + ", title="+book.getTitle() + "]\n");

		}
	}
		
		//Se crea el método para obtener la lista de libros desde la API e 
		//imprimirlos en pantalla con el siguiente formato (Autor + Título).

		public static void obtenerAuthorAndTitle() {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("https://my-json-server.typicode.com").path("Himuravidal").path("anchorBooks").path("books");
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON); 
		Response respuestaBook = invocationBuilder.get(); //Se hace la peticion de GET al API. // se ejecuta la url


		List<Book> listaBook = 
				respuestaBook.readEntity(new GenericType<List<Book>>(){});
		
		
		for (Book book : listaBook) {

			System.out.println(book.getAuthor() + " : "+book.getTitle() + "\n");
	
		}
		
	}
		
		//Se crea el método para obtener la lista de los libros ubicados en la posición 3 y 8 
		//e imprimirlos en pantalla con el siguiente formato.
		
		public static void obtenerAuthorTitleCountry() {
		
		Client client = ClientBuilder.newClient();
		
		WebTarget target = client.target("https://my-json-server.typicode.com").path("Himuravidal").path("anchorBooks").path("books");
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON); 
		Response respuestaBook = invocationBuilder.get(); 


		List<Book> listaBook = 
				respuestaBook.readEntity(new GenericType<List<Book>>(){});
				
		for (Book book : listaBook) {
			
			if (book.getId() == 4) {
		
			System.out.println("Libro numero 3: "+book.getAuthor() + ", "+book.getTitle()+ ", "+book.getCountry());}
			
			if (book.getId() == 9) {
			System.out.println("Libro numero 8: "+book.getAuthor() + ", "+book.getTitle()+ ", "+book.getCountry());}
			}

		}
	

	
	
}
