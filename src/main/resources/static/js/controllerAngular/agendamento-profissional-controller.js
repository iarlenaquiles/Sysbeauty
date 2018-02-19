service.controller('agendamentoProfissional', function agendamentoProfissional($scope, $http) {
	
		$scope.cancelar = false;

    	$scope.atendimentos = [
        	{cliente: 'Marilene', dia: '19/02/2018', local: 'Rua teste'},
        	{cliente: 'Ivone', dia: '20/02/2018', local: 'Rua Teste'}
        ];

    	
    	function listaAtendimentos($scope) {
    		$scope.fetchProductsList = function() {
        		$http.get('url').success(function(atendimentos){
            		$scope.atendimentos = atendimentos;
        		});
    		}
    	}
	
    	$scope.cancelar = function() {
    		console.log("Cancelar");
    		$scope.cancelar = true;
    	}
    	
    	$scope.chat = function() {
    		console.log("chat");
    	}
    	
    	$scope.agendamentosDia = function(data) {
    		console.log(data);
    	}
});