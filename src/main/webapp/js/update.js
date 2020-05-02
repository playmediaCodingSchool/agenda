$(document).ready(function() {
	let dni = '';

	$(`#dniButton`).click(function() {
		dni = $(`#dni`).val();

		$.getJSON(`api/contact/${dni}`, function(contact) {
			$(`#name`).val(contact.name);
			$(`#surname`).val(contact.surname);
			$(`#phone`).val(contact.phone);
			$(`#email`).val(contact.email);
		});	
	});


	$(`#nameButton`).click(function() {
		const name = $(`#name`).val();

		$.ajax ({
			type: `PATCH`,
			url: `api/contact/${dni}/name/${name}`,
			success: function() {
				window.location.href = `index.html`;
			},
			error: function() {
				alert(`ERROR AL EJECUTAR LA PETICION`);
			}
		 });
	});


	$(`#surnameButton`).click(function() {
		const surname = $(`#surname`).val();

		$.ajax ({
			type: `PATCH`,
			url: `api/contact/${dni}/surname/${surname}`,
			success: function() {
				window.location.href = `index.html`;
			},
			error: function() {
				alert(`ERROR AL EJECUTAR LA PETICION`);
			}
		 });
	});


	$(`#phoneButton`).click(function() {
		const phone = $(`#phone`).val();

		$.ajax ({
			type: `PATCH`,
			url: `api/contact/${dni}/phone/${phone}`,
			success: function() {
				window.location.href = `index.html`;
			},
			error: function() {
				alert(`ERROR AL EJECUTAR LA PETICION`);
			}
		 });
	});


	$(`#emailButton`).click(function() {
		const email = $(`#email`).val();

		$.ajax ({
			type: `PATCH`,
			url: `api/contact/${dni}/email/${email}`,
			success: function() {
				window.location.href = `index.html`;
			},
			error: function() {
				alert(`ERROR AL EJECUTAR LA PETICION`);
			}
		 });
	});
});