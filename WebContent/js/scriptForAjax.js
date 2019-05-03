function main() {
	//initializeAjax();
}

function addToCart(productid) {
	//alert(productid);
	var xhr = new XMLHttpRequest();
	xhr.overrideMimeType("application/json");

	xhr.open('POST', 'AddToCartServlet', true);

	xhr.onload = function(e) {
		if(xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
			json=JSON.parse(xhr.response);
			confirm();
		}
	};
	xhr.send("id=" + productid);
}

function confirm() {
	//json. ...
	//Fait apparaitre une confirmation (popup)
	//document.getElementById(id)
}
