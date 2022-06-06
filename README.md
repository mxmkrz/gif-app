Description:
---
```
Create a service that accesses the exchange rate service and displays a gif:
• if the exchange rate against USD for today has become higher than yesterday, then we give a random one from here https://giphy.com/search/rich
• if lower - from here https://giphy.com/search/broke



```  
Endpoints:
---  
Get list codes for currency:  
```
GET /codes
```  
Get a random GIF by the currency code that the user has chosen::
```
GET /gif/{currency}
```
Docker:
---
For create a Docker image, go to the root directory of the project where the file is located Dockerfile:  
```  
docker build -t gif-app .
```
Run:   
```
docker run -p 8090:8090 gif-app
``` 
