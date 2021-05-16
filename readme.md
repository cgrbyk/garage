### Garage

Simple 10 slot garage for park and leave cars, trucks and jeeps. 

* Every unit must have an empty next slot.
* Car occupies 1 slot, jeep occupies 2 slot, truck occupies 4 slot.
* Project has 3 endpoint park, leave and status

#### Park
parks a unit.
> request: curl "0.0.0.0:8080/api/park?plate=38HJ777&color=Kirmizi&type=Jeep"  
> result:
> Allocated 2 slot

#### Leave
leaves a unit.
> request: curl 0.0.0.0:8080/api/leave?slot=0  
> result:
> 38KK815 left

#### status
return current garage status.
> request: curl 0.0.0.0:8080/api/status  
> result:  
> 38KK815 Mavi [0]  
> 38HH611 Kirmizi [2,3,4,5]  
> 38HJ777 Kirmizi [7,8]