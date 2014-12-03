var app=angular.module('UkCitiesApp', []);

	app.directive("googleMap", function(){
		
		return{
			restrict:'E',
			template:'<div></div>',
			replace:true,
			scope:{
			ggOptions: '='	
			},
			link:function(scope, element, attrs){
				
				var map=new google.maps.Map(document.getElementById(attrs.id));
				scope.gMap=map;
				
				var marker=new google.maps.Marker();//markers
				scope.gMarker=marker;
				scope.gMarker.setMap(scope.gMap);
				
				var weatherLayer = new google.maps.weather.WeatherLayer({
				    temperatureUnits: google.maps.weather.TemperatureUnit.CELSIUS,
				    windSpeedUnits:google.maps.weather.WindSpeedUnit.KILOMETERS_PER_HOUR
				  });
				  weatherLayer.setMap(scope.gMap);

				  var cloudLayer = new google.maps.weather.CloudLayer();
				  cloudLayer.setMap(scope.gMap);
				
				var clearMap=function(){
				 scope.gMap.setOptions(null);
				 scope.gMarker.setOptions(null);
				 };
				 
				 var setTownMap=function(town){
					 
					 var lat=parseFloat(town.latitude);
					 var lng=parseFloat(town.longitude);
					 var myLatLng=new google.maps.LatLng(lat, lng);
						var mapOptions={
								center: myLatLng,
								zoom: 10,
								mapTypeId: google.maps.MapTypeId.HYBRID
							};
						 scope.gMap.setOptions(mapOptions);
						
						var makersJson={
								position: myLatLng,
								map: scope.gMap,
								title: town.title
						};
						scope.gMarker.setOptions(makersJson);
						town.refresh=false;

				 };
				
				scope.$watch('ggOptions', function(newValue, oldValue){
					if((newValue) && (newValue.visibility)){
						element.css('visibility', 'visible');
					}else{
						element.css('visibility', 'collapse');
					}
					clearMap();
					 if ((newValue) && (newValue.refresh))
						 setTownMap(newValue);
				}, true);
				
				
				
			}//end link
			
				
			
			
		}//args
	});//end directive
	

app.directive("csDisabled", function(){
	return {
	restrict:'A',
	scope:{
		csDisabled: '@'	
		},
		link:function(scope, element, attrs){
			attrs.$observe("csDisabled", function(value){
				if(value=='true'){
					element.attr("disabled", "disabled");
				}else if(value=='false'){
					element.removeAttr('disabled');
					
				} 
			});
		}//end link
	}
	
}); //end directive	
	
app.directive("csVisible", function(){
		
		return{
			restrict:'A',
			scope:{
				csVisible: '='	
			},
			link:function(scope, element, attrs){
				
				scope.$watch('csVisible', function(newValue, oldValue){
					if(newValue){
							element.show();
						}else{
							element.hide();
						}
						
	
				});
				
				
				
			}//end link
			
				
			
			
		}//args
	});//end directive
	
	
	
	

	app.factory('countryService',function($http)  {
		var countries=[];
		
		return {
			countries:countries,
			loadCountries:function(){
				$http.get("../rest/country/all")
				.success(function(data){
					countries.push.apply(countries, data);
					countries.unshift({code:'UK', description:'United Kingdom'});					
				}).error(function(data){
					alert("Error");
					
				})
				;
			}
		}
	}).factory('regionService',function($http)  {
		var regions=[];
		
		return {
			regions:regions,
			loadRegions:function(){
				$http.get("../rest/region/all")
				.success(function(data){
					regions.push.apply(regions, data);
					
				}).error(function(data){
					alert("Error");
					
				})
				;
			},
			getRegionsByCountryCode:function(countryCode){
				return $http.get("../rest/region/all/"+countryCode);
			}
		}
	}).factory('townService',function($http)  {
		var towns=[];
		
		return {
			towns:towns,
			loadTowns:function(){
				$http.get("/../rest/town/all")
				.success(function(data){
					towns.push.apply(towns, data);
					
				}).error(function(data){
					alert("Error");
					
				})
				
				;
			},
			getTownsByRegionId:function(regionId){
				return $http.get("../rest/town/all/"+regionId);
			}

		}
	});
	
	
	
	
	
	app.controller('countryCtrl', function($scope, countryService,  regionService,  townService) {
		$scope.countries=countryService.countries;
		countryService.loadCountries();
		$scope.mapImageVisibile=true;
		$scope.selectionCountry='UK';
		$scope.regions=[];
		$scope.towns= [];
		$scope.opts={latitude:0, longitude:0, title:'', refresh:false, visibility:false};
		$scope.init=function(){
			$scope.selectionCountry=$scope.countries[0].code;
		};
		$scope.disableRegion=true;
		$scope.disableTown=true;
		$scope.changeRegions=function (countryCode){
			$scope.disableRegion='true';
			$scope.disableTown='true';
			$scope.regions=[];
			$scope.towns=[];
			$scope.opts.visibility=false;
			$scope.mapImageVisibile=true;
			if(( (countryCode=='UK') || (countryCode=='') || (countryCode==null))){
				$scope.selectionCountry=$scope.countries[0].code;
				return ;
			}
			regionService.getRegionsByCountryCode(countryCode).success(function(data){
				$scope.regions.push.apply($scope.regions, data);
				$scope.disableRegion='false';
				
			}).error(function(data){
				alert("Error");
				
				
			});
			
			
			
		};
	
		$scope.changeTowns=function (idRegion){
			$scope.disableTown='true';
			$scope.towns=[];
			$scope.opts.visibility=false;
			$scope.mapImageVisibile=true;
			if((idRegion=='') || (idRegion==null)){
				return ;
			}
			townService.getTownsByRegionId(idRegion).success(function(data){
				if(data.length>0){
					
					$scope.towns.push.apply($scope.towns, data);
				}
					
				$scope.disableTown='false';
				
			}).error(function(data){
				alert("Error");
				
				
			});
			
			
			
		};
	
		$scope.fullMapTown=function(code){
			if(!code){
				$scope.mapImageVisibile=true;
				$scope.opts.visibility=false;
				return;
			}
			var objTown= $scope.towns.filter(
					function(element, index, array){
						return element.postcode==code;
					}
			)[0];
			
		 $scope.mapImageVisibile=false;
		 $scope.opts.latitude=objTown.latitude;
		 $scope.opts.longitude=objTown.longitude;
		 $scope.opts.title=objTown.town;
		 $scope.opts.visibility=true;
		 $scope.opts.refresh=true;
		 
		 
		};
	
	});