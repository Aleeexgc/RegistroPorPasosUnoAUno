function verClave(){
	
	 var tipo = document.getElementById("clave");
	 
      if(tipo.type == "password"){
          tipo.type = "text";
      }else{
          tipo.type = "password";
      }
}

function limpiarFormulario(formulario) {

  var elements = formulario.elements;

  formulario.reset();

  for(i=0; i<elements.length; i++) {

    field_type = elements[i].type.toLowerCase();

    switch(field_type) {
      case "text":
      case "email":
      case "password":
      case "textarea":
      case "hidden":
        elements[i].value = "";
        break;

      case "radio":
      case "checkbox":
          if (elements[i].checked) {
            elements[i].checked = false;
        }
        break;

      case "select-one":
      case "select-multiple":
        elements[i].selectedIndex = -1;
        break;

      default:
        break;
    }
  }
}

