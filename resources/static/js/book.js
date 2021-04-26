console.log("test");

function editModalCommentButton(event) {
	console.log(event.target.value);
	console.log(event.target.name);
	/*let innerTextOutput = document.getElementById('innerTextOutput');
	innerTextOutput.innerText = event.target.name;*/
	let modal_rental = document.getElementById('modal_rental');
	modal_rental = event.target.value;
}