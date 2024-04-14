교재 : 이것이 백엔드 개발이다.   
IDE : vscode   
JDK : openjdk version "17.0.7"  

스프링 부트 설정 https://start.spring.io/  
Project : Maven   
Language : java  
Spring Boot : 3.1.10  
Packaging : Jar  
Dependencies : Spring Web  

서버 구동시 기본 8080 포트를 이용하는데 사용 중인지 확인법   
netstat -ano | findstr :8080 

이미 사용 중이라면...  
application.properties 에 server.port=20001(임의 번호) 로 설정

 api 테스트 프로그램 postman   
 https://www.postman.com/downloads/?utm_source=postman-home

 JSON 검증 사이트  
 https://jsonformatter.curiousconcept.com/  

 HTTP 상태 코드 한글 설명 사이트
 https://developer.mozilla.org/ko/docs/Web/HTTP/Status