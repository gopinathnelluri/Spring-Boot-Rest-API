# Spring-Boot-Rest-API
Spring Boot Vehicles Rest API

### Sample GET Requests:

GET all vehicles:
```sh
curl -X GET http://127.0.0.1:8080/vehicles
```

GET vehicle with ID = 1:
```sh
curl -X GET http://127.0.0.1:8080/vehicles/1
```


> #### Search

GET all vehicles by type Car:
```sh
curl -X GET http://127.0.0.1:8080/vehicles/search/type/Car
```

GET all vehicles of brand BMW:
```sh
curl -X GET http://127.0.0.1:8080/vehicles/search/brand/BMW
```

GET all vehicles with year of make 2002:
```sh
curl -X GET http://127.0.0.1:8080/vehicles/search/year/2002
```

GET all vehicles with word 'flight' in description:
```sh
curl -X GET http://127.0.0.1:8080/vehicles/search/description/flight
```

GET all vehicles with model '7777':
```sh
curl -X GET http://127.0.0.1:8080/vehicles/search/description/7777
```


### Sample POST Requests:

POST new vehicle:
```sh
curl -X POST \
  http://127.0.0.1:8080/vehicles \
  -H 'content-type: application/json' \
  -d '{
        "vehicle_id": 1,
        "brand": "BMW",
        "model": "C4D5",
        "year": 1998,
        "speed": 120,
        "type": "car",
        "description": "BMW class 4 model with 120MPH"
  }'
```
DELETE recently added vehicle:
```sh
curl -X DELETE http://127.0.0.1:8080/vehicles
```

### Sample PUT Requests:

PUT(update data) vehicle object:
```sh
curl -X PUT \
  http://127.0.0.1:8080/vehicles/1 \
  -H 'content-type: application/json' \
  -d '{
        "vehicle_id": 1,
        "brand": "BMW",
        "model": "C4D5",
        "year": 1998,
        "speed": 120,
        "type": "car",
        "description": "BMW class 4 model with 120MPH"
  }'
```


PUT(update data) vehicle with ID = 1:
```sh
curl -X PUT \
  http://127.0.0.1:8080/vehicles/1 \
  -H 'content-type: application/json' \
  -d '{
        "brand": "BMW",
        "model": "C4D5",
        "year": 1998,
        "speed": 120,
        "type": "car",
        "description": "BMW class 4 model with 120MPH"
  }'
```

### Sample DELETE Requests:

DELETE vehicle with ID = 1:
```sh
curl -X DELETE http://127.0.0.1:8080/vehicles/1
```



