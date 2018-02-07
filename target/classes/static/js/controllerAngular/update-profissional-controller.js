service.controller('updateProfissional', function updateProfissional($scope, $http) {
	
	$scope.profissionalLogado = {};
	
	
	$scope.perfilProf = function() {
		
		console.log('perfilProf em execução');
		
		$http({
			method: 'POST',
			url: "/prof-pages/perfil-prof"
		}).then(function successCallback(response) {
			console.log('Success ' + response.data);
			$scope.profissionalLogado = response.data;
			console.log('Profissional: ' + $scope.profissionalLogado.email);
		}, function errorCallback(response) {
			console.log('Error ' + response.data);
		});
	}
	
	$scope.perfilProf();
	
	$scope.salvar = function() {
		console.log("Executando a function salvar");
		
		$http({
			method: 'POST',
			url: "/alterarProfissional",
			data: $scope.profissionalLogado	
		}).then(function successCallback(response) {
			console.log('Success: ');
		}, function errorCallback(response) {
			console.log('Error: ');
		});
	}
});