$(document).ready(function() {
	$("#creationButton").click(function() {
		const contact = {
			dni: $(`#dni`).val(),
			name: $(`#name`).val(),
			surname: $(`#surname`).val(),
			phone: $(`#phone`).val(),
			email: $(`#email`).val()
		};

		$.post (
			`api/contact`, 
			contact, 
			function() {
				alert("Alta exitosa!");
				$(location).attr(`href`, `index.html`);
			}
		);
	});
});