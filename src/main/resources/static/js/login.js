//jQuery(document).ready(function ($) {
//	$('#modalLogin').submit(function (event) {
//		event.preventDefault();
//
//		showMeYourCookies('At loginform submission');
//
//		var cookie = JSON.parse($.cookie('helloween'));
//		var data = 'usuario_email=' + $('#username').val() + '&usuario_senha=' + $('#password').val();
//		$.ajax({
//			data: data,
//			headers: {'X-CSRF-TOKEN': cookie.csrf},
//			timeout: 1000,
//			type: 'POST',
//			url: '/login'
//
//		}).done(function(data, textStatus, jqXHR) {
//			showMeYourJqXHR('When loginform is done', jqXHR);
//			showMeYourCookies('When loginform is done');
//			console.log(data)
//			//window.location = cookie.url;
//
//		}).fail(function(jqXHR, textStatus, errorThrown) {
//			showMeYourJqXHR('When loginform fails', jqXHR);
//			showMeYourCookies('When loginform fails');
//
//			console.error('Booh! Wrong credentials, try again!');
//		});
//	});
//});

var direcao = document.getElementsByClassName("ativo-login");
var login = document.getElementById("logar");
var email = $("#email");
var passwd = $("#passwd");

login.addEventListener("click", function(){
    if($('a.ativo-login').text() == 'Cliente'){
    	
    	 $.get({ datatype: 'json',
    		  type:'GET',
    		  url: 'http://127.0.0.1:8080/loginView/' + email.val() + "/" + passwd.val(),
    		  success: function(json){
    		    console.log(json);
    	        //location.href = "homecliente.html";
    		    return true;
    		  }
    		  ,error: function(json){
    		    console.log(json);
    		  }
    		});
    }else if($('a.ativo-login').text() == 'Profissional'){
    	$.post({ datatype: 'json',
    	    type:'GET',
    	    url: 'http://127.0.0.1:8080/listUserView',
    	    success: function(json){
    	      //Chegou até aqui, significa que pode dar o parabens...
    	      alert("Realize seu Cadastro");
    	      return true;
    	    }
    	    ,error: function(json){
    	      console.log(json);
    	    }
    	  });
        //location.href = "prof-pages/home-prof.html";
    }else if($('a.ativo-login').text() == 'Moderador'){
        location.href = "Adm-pages/homeadm.html";
    }

})