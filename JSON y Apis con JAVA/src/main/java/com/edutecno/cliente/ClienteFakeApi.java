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

import com.edutecno.modelo.Publicacion;

// PLANTILLA PARA CARGAR UN JSON Y CREAR UNA LISTA Y MAS 
// MISMO FORMATO PARA OTROS JSON. GUARDAR EN LIBRERIA DE USO. 
//PLANTILLA PARA CONSUMIR APIS EN JAVA

public class ClienteFakeApi {

	public static void main(String[] args) { //CONTROLADOR EL CUAL LLAMA A LOS METODOS POR SEPARADO
	
		// obtenerPost();
		crearPost();
		System.out.println("**********************************************");
		
		obtenerPost();
		//actualizarPost();
		//borrarPost();
		
	}
	
	//SIMULANDO UN CRUD (CREATE - READ - UPDATE - DELETE)
	
	// GET   https://jsonplaceholder.typicode.com/posts
	private static void obtenerPost() {
			
		// SE GENERA UN CLIENTE
		Client client = ClientBuilder.newClient();
		
		WebTarget target = client.target("https://jsonplaceholder.typicode.com").path("posts");
		
		//Pasamos el tipo de formato que vamos a trabajar 
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON); //es un ENUM 
		
		Response respuestaPublicaciones = invocationBuilder.get(); //Se hace la peticion de GET al API. // se ejecuta la url
		
		System.out.println(respuestaPublicaciones);
		//InboundJaxrsResponse{context=ClientResponse{method=GET, uri=https://jsonplaceholder.typicode.com/posts, 
		//status=200, reason=OK}}  
		// CUANDO SE RECIBE UN STATUS 200 ES QUE EL CODIGO SE HIZO BIEN
		
		// Lo que queda AHORA es transformar ese JSON en un OBJETOPUBLICACION para LEER SUS DATOS 
		
		
		//GenericType es el tipo de valor que esta trabajando la lista 
		List<Publicacion> listaPublicaciones = 
				respuestaPublicaciones.readEntity(new GenericType<List<Publicacion>>(){});
		
		//FINALMENTE PASAMOS LOS DATOS A LA LISTA Y PODEMOS USAR LOS METODOS DE JAVA EN ELLA. HACER Y DESHACER CON JSON, LO TENEMOS EN NUESTRO POWER. 
		
		for (Publicacion publicacion : listaPublicaciones) {
			// System.out.println(publicacion + "\n");
			System.out.println(publicacion.getId() + "\n");
			//System.out.println(publicacion.getTitle() + "\n");
		}
		
	}
	
	// POST	
	private static void crearPost() {
		
		Publicacion publicacion = new Publicacion(); 
		publicacion.setTitle("Nueva publicacion");
		publicacion.setBody("El body de la pub");
		publicacion.setUserId(1);
		publicacion.setId(101);
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("https://jsonplaceholder.typicode.com").path("posts");
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		
		//Indicar la entidad que vamos a guardar y que recibe un Object (Creado al principio) y un Media Type (uno mas arriba). 
		Response respuestaPublicacion =  invocationBuilder.post(Entity.entity(publicacion, MediaType.APPLICATION_JSON));  
		//El Object seria la Instancia de Publicacion publicacion creado al comienzo. 
		
		if(respuestaPublicacion.getStatus() == 201) {
			System.out.println("Publicacion titulo : "+ publicacion.getTitle() + " guardado correctamente");
			obtenerPost();
		}
		
	}
	
	// PUT	
	private static void actualizarPost() {
		
		Publicacion publicacion = new Publicacion(); 
		publicacion.setTitle("Nueva publicacion");
		publicacion.setBody("SE ACTUALIZO EL BODY ZI");
		publicacion.setUserId(1);
		publicacion.setId(101);
		
		// Se podria crear un metodo para repetir esto. PLANTILLA de crearPost(), actualizarPost() 
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("https://jsonplaceholder.typicode.com").path("posts").path("1");
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		
		// ACA SE CAMBIA EL post POR EL put
		Response respuestaPublicacion =  invocationBuilder.put(Entity.entity(publicacion, MediaType.APPLICATION_JSON));  
		
		System.out.println(respuestaPublicacion);
	} 
	
	//DELETE
	private static void borrarPost() {
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("https://jsonplaceholder.typicode.com").path("posts").path("101"); //Eliminamos el ID 101 y eso va en el target
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		Response respuestaPublicacion =  invocationBuilder.delete();
		
		System.out.println(respuestaPublicacion);
		
	}
	
}
