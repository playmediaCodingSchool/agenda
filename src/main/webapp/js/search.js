$(document).ready(function() {
	$.getJSON( "api/contact", function(contacts) {
		for(let i = 0; i < contacts.length; i++) {
			const contact = contacts[i];

			const newRow = `
				<tr>
					<td>${contact.dni}</td>
					<td>${contact.name}</td>
					<td>${contact.surname}</td>
					<td>${contact.phone}</td>
					<td>${contact.email}</td>
				</tr>
			`;

			$('#result > tbody:last-child').append(newRow);
		}
	});
});