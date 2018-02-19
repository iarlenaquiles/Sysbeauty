service.controller('agendamentoProfissional', function agendamentoProfissional(
		$scope, $http) {

	$scope.cancelar = false;

	$scope.agendamentos = [ {
		cliente : 'Marilene',
		dia : '19/02/2018',
		local : 'Rua teste'
	}, {
		cliente : 'Ivone',
		dia : '20/02/2018',
		local : 'Rua Teste'
	} ];

	var modal = {
		controller : 'CancelarController',
		templateUrl : '../../templates/prof-pages/cancelamentoProfissional.html'
	};

	function listaAgendamentos($scope) {
		$scope.fetchProductsList = function() {
			$http.get('url').success(function(agendamentos) {
				$scope.agendamentos = agendamentos;
			});
		}
	}

	$scope.cancelar = function(agendamento) {
		
	}

	$scope.chat = function() {
		console.log("chat");
	}

	$scope.agendamentosDia = function(data) {
		console.log(data);
	}
});

function CancelarController($scope){
	  
	  console.log("entrou controller cancelamento");
}


