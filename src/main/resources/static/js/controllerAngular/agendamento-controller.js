service.controller('agendamentoProfissional', function agendamentoProfissional($scope, $http) {
	
	$scope.dataAgendamento;
	$scope.horaAgendamento;
	$scope.servicos = [];
	$scope.servicosSelecionados = [
		{
			id: '',
			servico: '',
			valor: '',
			promocao: {}
		}
	];

	$scope.constructor = function() {
		
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
	
	$scope.servicosSelecionados = [];
	
	$scope.btnProximo = function() {
		console.log($scope.dataAgendamento);
	}
	
	$scope.btnAgendar = function() {
		console.log($scope.servicos);
	}
	
});