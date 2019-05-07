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
	document.getElementById(productid).style.backgroundColor="#28db16";
	document.getElementById(productid).style.borderColor="#7aef46";
}

function confirmDelete(productid) {
	//Si la confirmation est confirmé par le servlet, alors on supprime le produit dans le HTML
	document.getElementById(productid).remove();
}

function onValidatePassword() {
  var x = document.forms["form-password"]["password"].value;
  var bitArray = sjcl.hash.sha256.hash(x);  
  var digest_sha256 = sjcl.codec.hex.fromBits(bitArray);
  document.forms["form-password"]["password"].value=digest_sha256.toUpperCase();;
  return true;
}


