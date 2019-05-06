var xhr;

function main() {
	xhr = new XMLHttpRequest();

	xhr.overrideMimeType("application/json");
	xhr.onload = function(e) {
		if(xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
			json=JSON.parse(xhr.response);
			if (json["action"] == "delete") {
				confirmDelete(json["id"]);
			} else if (json["action"] == "add") {
				confirmAdd(json["id"]);
			}

		}
	};
}

function addToCart(productid) {
	xhr.open('GET', 'AddToCartServlet?id='+productid, true);
	xhr.send();
}

function removeFromCart(productid) {
	xhr.open('GET', 'DeleteFromCartServlet?id='+productid, true);
	xhr.send();
}

function confirmAdd(productid) {
	//json. ...
	//Fait apparaitre une confirmation (popup)
	//document.getElementById(id)
}

function confirmDelete(productid) {
	//Si la confirmation est confirmé par le servlet, alors on supprime le produit dans le HTML
	document.getElementById(productid).remove();
}
