function search(surname) {
	$('#result').find('tbody').detach();
	$('#result').append($('<tbody>')); 

	$.getJSON(`api/contact?surname=${surname}`, function(contacts) {
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

			$(`#result > tbody:last-child`).append(newRow);
		}
	});
}

$(document).ready(function() {
	$(`#surnameCleanButton`).click(function() {
		$(`#surname`).val(``);

		search(``);
	});

	$(`#surnameButton`).click(function() {
		let surname = $(`#surname`).val();

		search(surname);
	});

	search(``);
});