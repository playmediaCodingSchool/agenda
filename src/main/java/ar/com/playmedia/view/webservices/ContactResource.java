package ar.com.playmedia.view.webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
	public Response search() {
		ArrayList<ar.com.playmedia.model.Contact> contactList;
		handler.connect();
		contactList = handler.search();
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


}
