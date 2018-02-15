

  var map;
  var api = 'http://127.0.0.1:8080/';
  var pro = [];
  
  profissionalSelecionado = {};
  
function myMapCliente() {
	var longitude;
	var latitude;

	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(function(position) {
			// ajusta a posição do marker para a localização do usuário
			longitude = position.coords.longitude;
			latitude = position.coords.latitude;

			var mapProp = {
				center : new google.maps.LatLng(latitude, longitude),
				zoom : 15,
			};
			map = new google.maps.Map(document.getElementById("googleMap"),
					mapProp);
			
			// / Marker Profissionais ///
			markerPro();
		}, function(error) { // callback de erro
			alert('Erro ao obter localização!');
			console.log('Erro ao obter localização.', error);
		});
	} else {
		console.log('Navegador não suporta Geolocalização!');
	}
}

function markerPro() {
	// //Lista de profissionais /////
	  $.post({ datatype: 'json',
	    type:'GET',
	    url: api+'listPro',
	    success: function(json){
	      // Vai transformar o cep em cordenadas
	    	pro = json;
	        for(let j of json) {
	        	var geocoder;
	        	geocoder = new google.maps.Geocoder();
	        	var lat = '';
	        	var lng = '';
	        	var address = j.cep;
	        	geocoder.geocode({ address }, function(results, status) {
	        		if (status == google.maps.GeocoderStatus.OK) {
	        			lat = results[0].geometry.location.lat();
	        			lng = results[0].geometry.location.lng();
	        			var latlng = new google.maps.LatLng(lat, lng);
	        			var marker = new google.maps.Marker({
	        				position : latlng,
	        				map : map,
	        				title : j.nome
	        			});
	        			// / vai adicionar uma função ao clicar
	        			marker.addListener('click', function() {
	        		          map.setZoom(17);
	        		          map.setCenter(marker.getPosition());
	        		          // / retorna o perfil do usuario clicado
	        		          perfilPro(j);
	        		          
	        		        });
	        		} else {
	        			alert("Não foi possivel obter localização: " + status);
	        		}
	        	});
	        }
	      return true;
	    }
	    ,error: function(json){
	      console.log(json);
	    }
	  });
	}

function perfilPro(pro){
    $.post({ datatype: 'json',
	    type:'GET',
	    url: api+'perfilPro/'+pro.id,
	    success: function(json){
	    	var labe1= document.getElementById('labe1');
	        labe1.innerHTML  = json.nome;
	        profissionalSelecionado = pro;
	        console.log(json);
	        // /Serviços prestado pelo profissional
	        servicos(pro);        
	      return true;
	    }
	    ,error: function(json){
	      console.log(json);
	    }
	  });
}

function servicos(pro){
	var txt = "";
	var txt2 = "";
	
	json = pro.servico;
	console.log(json);
	txt += "<table>";
	txt2 += "<table>";
	
    for(let servicos of json) {
    	txt +=  "<tr><td><input type='checkbox' id='"+servicos.servico+"' name='"+servicos.servico+"' class='filled-in'/><label for='"+servicos.servico+"'>"+servicos.servico+"</label></td><td>"+servicos.valor+",00</td></tr>";
    	txt2 +=  "<tr><td><input type='checkbox' id='"+servicos.servico+"1' name='"+servicos.servico+"' class='filled-in'/><label for='"+servicos.servico+"1'>"+servicos.servico+"</label></td><td><img src='img/cesta.png' alt='cesta de comprar'/></td><td>"+servicos.valor+",00</td></tr>";
    }
    
	txt += "</table>";
    txt2 += "</table>";
    console.log(txt2);
    document.getElementById("table").innerHTML = txt;
	document.getElementById("table2").innerHTML = txt2;
	
	return true;
}

function myMapProf() {
	var longitude = -48.2622;
	var latitude = -18.9113;

	var mapProp = {
		center : new google.maps.LatLng(latitude, longitude),
		zoom : 14,
	};
	var map1 = new google.maps.Map(document.getElementById("googleMap3"),
			mapProp);
	var map2 = new google.maps.Map(document.getElementById("googleMap2"),
			mapProp);

}

// function markerPro() {
// var geocoder;
// geocoder = new google.maps.Geocoder();
// var lat = '';
// var lng = '';
// var address = 'Goiania';
// geocoder.geocode({ address }, function(results, status) {
// if (status == google.maps.GeocoderStatus.OK) {
// lat = results[0].geometry.location.lat();
// lng = results[0].geometry.location.lng();
// var latlng = new google.maps.LatLng(lat, lng);
// var marker = new google.maps.Marker({
// position : latlng,
// map : map,
// title : "Goiania"
// });
// } else {
// alert("Não foi possivel obter localização: " + status);
// }
// });
// }

function btnAgendarAtendimento() {
	servicos = [];
	for (let servico of profissionalSelecionado.servico) {
		if(!document.getElementById(servico.servico+"1").setAttribute(value, "")) { 
			servicos.add(servico);
			console.log(servico);
		}
	}
	
	console.log(servicos.toString());
}
