$(function() {
	$( "#btn-cad" ).bind( "click", function() {
	  $.get({ datatype: 'json',
	    type:'GET',
	    url: 'http://127.0.0.1:8080/cadastro',
	    success: function(json){
	      //Chegou até aqui, significa que pode dar o parabens...
	      //alert("Realize seu Cadastro");
	      return true;
	    }
	    ,error: function(json){
	      console.log(json);
	    }
	  });
	});
});