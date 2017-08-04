(function() {
	'use strict';
	angular.module( 'spinner', [] );
	
	angular.module( 'spinner' ).component( 'spinner', {
		template: '' +
		          '<div class="spinner-wrapper" ng-if="vm.isSpinning()" ng-click="$event.stopPropagation()">' +
		          ' <div class="spinner-loader" layout="column" layout-align="center center">' +
		          '     <md-progress-circular class="md-primary" md-diameter="20"></md-progress-circular>' +
		          ' </div>' +
		          '</div>',
		controller: SpinnerController,
		controllerAs: 'vm',
		bindings: {
			name: '='
		}
	} );
	
	function SpinnerController( SpinnerService ) {
		var vm = this;
		
		vm.isSpinning = isSpinning;
		
		/////////////////////////////
		
		function isSpinning() {
			return SpinnerService.isSpinning();
		}
	}
	
	angular.module( 'spinner' ).factory( 'SpinnerService', SpinnerService );
	
	function SpinnerService() {
		var service = {
			_isSpinning: false,
			isSpinning: isSpinning,
			start: start,
			stop: stop
		};
		
		return service;
		
		/////////////////////////////
		
		function isSpinning() {
			return service._isSpinning;
		}
		
		function start() {
			service._isSpinning = true;
		}
		
		function stop() {
			service._isSpinning = false;
		}
	}
})();