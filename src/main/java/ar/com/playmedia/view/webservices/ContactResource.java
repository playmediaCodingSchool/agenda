package ar.com.playmedia.view.webservices;

import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import java.util.ArrayList;

import org.json.*;


@Path("/contact")
public class ContactResource {
	private ar.com.playmedia.controller.Contact handler = new ar.com.playmedia.controller.Contact();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response search (
		@QueryParam("surname") @DefaultValue("%") String surname
	) {
		ArrayList<ar.com.playmedia.model.Contact> contactList;

		handler.connect();
		contactList = handler.search(surname);
		handler.disconnect();
		
		JSONArray contacts = new JSONArray();

		for(ar.com.playmedia.model.Contact contactIterator : contactList) {
			JSONObject contact = new JSONObject();

			contact.put("dni", contactIterator.getDni());
			contact.put("name", contactIterator.getName());
			contact.put("surname", contactIterator.getSurname());
			contact.put("phone", contactIterator.getPhone());
			contact.put("email", contactIterator.getEmail());

			contacts.put(contact);
		}

		return Response.status(Status.OK).entity(contacts.toString()).build();
	}


	@GET
	@Path("{dni}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response identify (
		@PathParam("dni") Integer dni
	) {
		handler.connect();
		ar.com.playmedia.model.Contact response = handler.identify(dni);
		handler.disconnect();
		
		JSONObject contact = new JSONObject();

		contact.put("dni", response.getDni());
		contact.put("name", response.getName());
		contact.put("surname", response.getSurname());
		contact.put("phone", response.getPhone());
		contact.put("email", response.getEmail());

		return Response.status(Status.OK).entity(contact.toString()).build();
	}


	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response create (
		@FormParam("dni") Integer dni,
		@FormParam("name") String name,
		@FormParam("surname") String surname,
		@FormParam("phone") String phone,
		@FormParam("email") String email
	) {
		ar.com.playmedia.model.Contact contact = new ar.com.playmedia.model.Contact (
			dni,
			name,
			surname,
			phone,
			email
		);

		handler.connect();
		handler.insert(contact);
		handler.disconnect();

		return Response.status(Status.OK).build();
	}


	@PATCH
	@Path("{dni}/name/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setName (
		@PathParam("dni") Integer dni,
		@PathParam("name") String name
	) {
		try {
			handler.connect();
			ar.com.playmedia.model.Contact contact = handler.identify(dni);
			handler.setName(contact, name);
			handler.disconnect();

			return Response.status(Status.OK).build();
		} catch(Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}


	@PATCH
	@Path("{dni}/surname/{surname}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setSurnamee (
		@PathParam("dni") Integer dni,
		@PathParam("surname") String surname
	) {
		try {
			handler.connect();
			ar.com.playmedia.model.Contact contact = handler.identify(dni);
			handler.setSurname(contact, surname);
			handler.disconnect();

			return Response.status(Status.OK).build();
		} catch(Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}


	@PATCH
	@Path("{dni}/phone/{phone}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setPhone (
		@PathParam("dni") Integer dni,
		@PathParam("phone") String phone
	) {
		try {
			handler.connect();
			ar.com.playmedia.model.Contact contact = handler.identify(dni);
			handler.setPhone(contact, phone);
			handler.disconnect();

			return Response.status(Status.OK).build();
		} catch(Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}


	@PATCH
	@Path("{dni}/email/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setEmail (
		@PathParam("dni") Integer dni,
		@PathParam("email") String email
	) {
		try {
			handler.connect();
			ar.com.playmedia.model.Contact contact = handler.identify(dni);
			handler.setEmail(contact, email);
			handler.disconnect();

			return Response.status(Status.OK).build();
		} catch(Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}


	@DELETE
	@Path("{dni}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete (
		@PathParam("dni") Integer dni
	) {
		try {
			handler.connect();
			handler.delete(dni);
			handler.disconnect();

			return Response.status(Status.OK).build();
		} catch(Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}
