????????:
---
```
??????? ??????, ??????? ?????????? ? ??????? ?????? ?????, ? ?????????? gif:
? ???? ???? ?? ????????? ? USD ?? ??????? ???? ???? ??????????, ?? ?????? ????????? ?????? https://giphy.com/search/rich
? ???? ???? - ?????? https://giphy.com/search/broke
??????
? REST API ?????? ????? - https://docs.openexchangerates.org/
? REST API ????? - https://developers.giphy.com/docs/api#quick-start-guide
Must Have
? ?????? ?? Spring Boot 2 + Java / Kotlin
? ??????? ???????? ?? HTTP endpoint (?????? ???? ??????? ? ???????????? ? rest conventions), ???? ?????????? ??? ?????? ?? ????????? ? ??????? ???????????? USD
? ??? ?????????????? ? ???????? ????????? ???????????? Feign
? ??? ????????? (?????? ?? ????????? ? ??????? ????????? ????, ?????? ??????? ???????? ? ?.?.) ???????? ? ?????????
? ?? ?????? ???????? ????? (??? ???? ??????? ???????? ????? ???????????? @mockbean ??? WireMock)
? ??? ?????? ?????? ?????????????? Gradle
? ??????????? ?????????? ?????? ???? ???? ?? GitHub ? ??????????? ?? ???????
Nice to Have
? ?????? ? ?????? Docker ?????????? ? ???? ????????



```  
Endpoints:
---  
???????? ?????? ????? ??? ?????:  
```
GET /codes
```  
???????? ????????? ????? ?? ???? ??????, ??????? ?????? ????????????:
```
GET /gif/{?ode}
```
Docker:
---
??? ???????? ?????? Docker ??????? ? ???????? ?????????? ???????, 
??? ????? ???? Dockerfile:  
```  
docker build -t gif-app .
```
??????:   
```
docker run -p 8090:8090 gif-app
``` 
