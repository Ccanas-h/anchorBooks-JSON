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
import com.edutecno.modelo.BookDetail;



public class ClienteBookDetail {

	
	//Se crea el método para obtener el detalle de todos los libros directamente desde la API detalles.
	
	public static void obtener1erDetail() {
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("https://my-json-server.typicode.com").path("Himuravidal").path("anchorBooks").path("bookDetail");
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON); 
		Response respuestaBookDetail = invocationBuilder.get(); 

		List<BookDetail> listaBookDetail = 
				respuestaBookDetail.readEntity(new GenericType<List<BookDetail>>(){});
				
		for (BookDetail bookDetail : listaBookDetail) {
				
			System.out.println("[BookDetail [id="+bookDetail.getId()+", author="+bookDetail.getAuthor()+
					", country="+bookDetail.getCountry()+",\n imageLink="+bookDetail.getAuthor()+", language="+bookDetail.getLanguage()
					+",\n link="+bookDetail.getLink()+" pages="+bookDetail.getPages()+", title="+bookDetail.getTitle()
					+", year="+bookDetail.getYear()+", price="+bookDetail.getPrice()
					+",\n lastPrice="+bookDetail.getLastPrice()+", delivery="+bookDetail.getDelivery()+"]\n");
			
		}
	}
	
		
		//Crear el método para obtener aquellos libros cuyo delivery sea true, el cual debería arrojar la siguiente información.
		
		public static void obtenerDeliveryTrue() {
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("https://my-json-server.typicode.com").path("Himuravidal").path("anchorBooks").path("bookDetail");
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON); 
		Response respuestaBookDetail = invocationBuilder.get(); 

		List<BookDetail> listaBookDetail = 
				respuestaBookDetail.readEntity(new GenericType<List<BookDetail>>(){});
		
		System.out.println("Libros con delivery disponible\n\n");
		
		for (BookDetail bookDetail : listaBookDetail) {
			
			if (bookDetail.getDelivery() == true){
				
			System.out.println("Libro: "+ bookDetail.getTitle());
			
			}
		}
	}
	
}