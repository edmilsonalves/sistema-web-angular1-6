angular.module('primeiraApp', [
  'ui.router',
  'ngAnimate',
  'toastr'
])

angular.module('primeiraApp').config([
  '$stateProvider',
  '$urlRouterProvider',
  function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('dashboard', {
      url: "/dashboard",
      templateUrl: "dashboard.html"
    }).state('vendaDelivery', {
        url: "/venda-delivery?page",
        templateUrl: "venda-delivery.html"
    }).state('clientes', {
        url: "/clientes?page",
        templateUrl: "clientes.html"
    })

    $urlRouterProvider.otherwise('/dashboard')
}])

