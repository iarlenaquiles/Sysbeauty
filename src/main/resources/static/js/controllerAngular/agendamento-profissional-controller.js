service.controller('agendamentoProfissional', function agendamentoProfissional($scope, $http) {
	

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
	
});