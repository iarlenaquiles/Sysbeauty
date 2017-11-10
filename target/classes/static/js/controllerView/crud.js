var pasta;

function teste() {
console.log(pasta)
}

// LISTA DE CADASTRADOS //
function listUsers() {
  $.post({ datatype: 'json',
    type:'GET',
    url: 'http://127.0.0.1:8080/listUser',
    success: function(json){
      //Chegou até aqui, significa que pode dar o parabens...
      alert("Realize seu Cadastro");
      return true;
    }
    ,error: function(json){
      console.log(json);
    }
  });
}

/////// Cadastrar Cliente /////////
$(function() {
  $('#contactform').submit(function(e) {
    e.preventDefault();
      $.ajax({
        //contentType: "application/json; charset=utf-8",
        datatype: 'json',
        type:'POST',
        url: 'http://127.0.0.1:8080/ViewNewuser',
        data: $('#swipe-1 *').serialize(),
        success: function(json){
        window.pasta = json;
         teste();
          if(!json.id){
            alert("Verifique dados do cadastro");
            return false;
          }
          alert(pasta.nome + ' cadastrado com sucesso');
          location.href = "homecliente.html";

          return true;
        }
        ,error: function(json){
          console.log(json);
        }
      });
    });
});

//////// Cadatro de Cliente (teste) /////////
function cadastroCliente() {
    //$( "#btn-action" ).bind( "click", function() {
      $.ajax({
        //contentType: "application/json; charset=utf-8",
        datatype: 'json',
        type:'POST',
        url: 'http://127.0.0.1:8080/ViewNewuser',
        data: $('#swipe-1 *').serialize(),
        success: function(json){
          console.log(json)
          if(!json.id){
            alert("Verifique dados do cadastro");
            return false;
          }
          alert(json.nome + ' cadastrado com sucesso');
          location.href = "homecliente.html";
          return true;
        }
        ,error: function(json){
          console.log(json);
        }
      }).presentDefault();
}

function perfil(){
	  $.get({ datatype: 'json',
	  type:'GET',
	  url: 'http://127.0.0.1:8080/teste',
	  success: function(json){
	    //Chegou até aqui, significa que pode dar o parabens...
	    alert(json);
	    return true;
	  }
	  ,error: function(json){
	    console.log(json);
	  }
	});
}
