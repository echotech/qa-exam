(function() {
	'use strict';
	
	angular.module("qa",['ngAnimate', 'ngSanitize', 'ngMessages', 'ngMaterial', "spinner"]);
	angular.module("qa").controller("IndexController", IndexController);
	
	function IndexController( $log, SpinnerService, $timeout ) {
		var vm = this;
		
		vm.login=function(  ) {
			SpinnerService.start();
			
			$timeout(function(  ) {
				vm.isSuccess = vm.username==="guest" && vm.password==="password";
				vm.isCalled = true;
				$log.info(vm.isSuccess);
				SpinnerService.stop();
			}, 1000);
			
		}
	}
	
	
})();