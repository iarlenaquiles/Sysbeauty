service.controller('homeCliente', function homeCliente($scope, $http) {
	
	
	$scope.Markers = [];
	
	$scope.profissionalSelecionado;
	$scope.servicos = [];
	$scope.servicosSelecionados = [
		{
			id: '',
			servico: '',
			valor: '',
			promocao: {}
		}
	];
	
	$scope.longitude;
	$scope.latitude;

	$scope.constructor = function() {
		if(navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(function(position) {
				//$scope.latitude = position.coords.latitude;
				//$scope.longitude = position.coords.longitude;
			});
		}
	}
	
	//Setting the Map options.
    $scope.MapOptions = {
        center: new google.maps.LatLng('-16.616418', '-49.226201'),
        zoom: 0,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
	
	//Initializing the InfoWindow, Map and LatLngBounds objects.
    $scope.InfoWindow = new google.maps.InfoWindow();
    $scope.Latlngbounds = new google.maps.LatLngBounds();
    $scope.Map = new google.maps.Map(document.getElementById("dvMap"), $scope.MapOptions);
	
	/*$scope.gerarLocalizacao = function(profissionais) {
		for(let p of profissionais) {
			var geocoder;
			geocoder = new google.maps.Geocoder();
			var lat = '';
			var lng = '';
			var address = p.cep;
			
			geocoder.geocode({ address }, function(results, status) {
				if (status == google.maps.GeocoderStatus.OK) {
					lat = results[0].geometry.location.lat();
					lng = results[0].geometry.location.lng();
					
					var latlng = new google.maps.LatLng(lat, lng);
					
					//Initializing the Marker object.
					var marker = new google.maps.Marker({
						position: latlng,
						map: $scope.Map,
						title: p.nome
					});
			        
			        marker.addListener('click', function() {
      		          $scope.Map.setZoom(17);
      		          $scope.Map.setCenter(marker.getPosition());
      		          // / retorna o perfil do usuario clicado
      		          perfilPro(j);
      		          
      		        });
			        
			        //Plotting the Marker on the Map.
			        $scope.Latlngbounds.extend(marker.position);
				} else {
					alert("Não foi possível obter localização: " + status);
				}
			})
		}
	}*/
    
    $scope.gerarLocalizacao = function(profissionais) {
    	for(let p of profissionais) {
    	   var geocoder;
    	   geocoder = new google.maps.Geocoder();
    	   var lat = '';
    	   var lng = '';
    	   var address = p.cep;
    	   
    	   geocoder.geocode({ address }, function(results, status) {
    		   if (status == google.maps.GeocoderStatus.OK) {
    			   lat = results[0].geometry.location.lat();
    			   lng = results[0].geometry.location.lng();
    	          
    			   var myLatlng = new google.maps.LatLng(lat, lng);
    	        
    			   //Initializing the Marker object.
    			   var marker = new google.maps.Marker({
    				   position: myLatlng,
    				   map: $scope.Map,
    				   title: p.nome
    			   });

    			   //Adding InfoWindow to the Marker.
    			   (function (marker, p) {
    				   google.maps.event.addListener(marker, "click", function (e) {
	    	               $scope.InfoWindow.setContent("<div style = 'width:200px;min-height:40px'>" + p.nome + "</div>");
	    	               $scope.InfoWindow.open($scope.Map, marker);
    				   });
    			   })(marker, p);
    	           
    	           marker.addListener('click', function() {
    	        	   $scope.Map.setZoom(17);
    	        	   $scope.Map.setCenter(marker.getPosition());
    	                  // / retorna o perfil do usuario clicado
    	                  perfilPro(p);
    	                  
    	                });
    	           
    	           //Plotting the Marker on the Map.
    	           $scope.Latlngbounds.extend(marker.position);
    	           //console.log(marker.position);
    	    } else {
    	     alert("Não foi possível obter localização: " + status);
    	    }
    	   });
    	}
    	
		$scope.Map.setCenter($scope.Latlngbounds.getCenter());
		$scope.Map.fitBounds($scope.Latlngbounds);
    }
	
	$scope.listarProfissionais = function() {
    	$http({
			method: 'GET',
			url: '/listPro'
		}).then(function successCallback(response) {
			console.log("Success");
			$scope.gerarLocalizacao(response.data);
		}, function errorCallback(response) {
			console.log("ERROR" + response.data);
		});
	}
	
	function perfilPro(pro){
	    $http({
	    	method: 'GET',
	    	url: '/perfilPro/'+pro.id
	    }).then(function successCallback(response) {
	    	console.log("Success");
	    	
	    	var labe1= document.getElementById('labe1');
	        labe1.innerHTML  = response.data.nome;
	        
	        $scope.profissionalSelecionado = pro;
	        i = $scope.profissionalSelecionado.servico;
	        
	        for (cont = 0; cont < i.length; cont++) {
	        	console.log('Teste ' + cont);
	        	console.log(i[cont].id);
	        	$scope.servicos.push({
	        		id: i[cont].id,
	    			servico: i[cont].servico,
	    			valor: i[cont].valor,
	    			checked: '',
	    			promocao: i[cont].promocao
	        	});
	        }
	        
	        console.log($scope.servicos);
	        
	        
	        console.log($scope.profissionalSelecionado);
	    	
	    }, function errorLog(response) {
	    	console.log("ERROR " + response.data);
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
	}
	
	$scope.constructor();
	$scope.listarProfissionais();
	

    

    //Looping through the Array and adding Markers.
    /*for (var i = 0; i < $scope.Markers.length; i++) {
        var data = $scope.Markers[i];
        var myLatlng = new google.maps.LatLng(data.lat, data.lng);
        

        //Initializing the Marker object.
        var marker = new google.maps.Marker({
            position: myLatlng,
            map: $scope.Map,
            title: data.title
        });

        //Adding InfoWindow to the Marker.
        (function (marker, data) {
            google.maps.event.addListener(marker, "click", function (e) {
                $scope.InfoWindow.setContent("<div style = 'width:200px;min-height:40px'>" + data.description + "</div>");
                $scope.InfoWindow.open($scope.Map, marker);
            });
        })(marker, data);

        //Plotting the Marker on the Map.
        $scope.Latlngbounds.extend(marker.position);
    }*/

    //Adjusting the Map for best display.
    
    /* =============================================== Agendamento =============================================== */
	
	
	$scope.servicosSelecionados = [];
	
	$scope.btnAgendar = function() {
		console.log($scope.servicos);
	}
	
});