$(document).ready(function() {
	$(`#deleteButton`).click(function() {
		const dni = $(`#dni`).val();

		$.ajax ({
			type: `DELETE`,
			url: `api/contact/${dni}`,
			success: function() {
				window.location.href = `index.html`;
			},
			error: function() {
				alert(`ERROR AL EJECUTAR LA PETICION`);
			}
		 });
	});
});