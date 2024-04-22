교재 : 이것이 백엔드 개발이다.   
IDE : vscode   
JDK : openjdk version "17.0.7"  

설치한 vscode 확장 프로그램  
Extension Pack for Java  
Getter and Setter Generator  
HTML CSS Support  
JavaScript (ES6) code snippets  
Spring Boot Extension Pack  
Language Support for Java(TM) by Red Hat  

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

 유효성 검사 라이브러리  
 https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation  

 @NotNull : 오직 null만 허용하지 않는다. 빈 문자열이나 띄어쓰기만 있는 문자열은 허용된다.
 @NotEmpty : null 와 "" 처럼 빈 문자열이 허용되지 않는다. 띄어쓰기가 있는 문자열은 허용된다.
 @NotBlank : null, "", " " 전부 허용하지 않는다.

 깃허브에 있는 소스코드 검색 사이트  
 https://grep.app/ 