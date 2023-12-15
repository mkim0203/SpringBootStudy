# 


## 환경
    DB : h2
    Spring Boot
    JPA, hibernate
    Swagger
    인증 : JWT
    Log : Slf4j

## Swagger 접근
    /config/swagger or /swagger-ui/index.html

## H2 DB
    /config/h2db or /h2-console
    
    


### 학습
    rest api 구성
    jwt 인증
    정합성 체크
    DB, hibernate DTO 구성
    aop 구성하여 로그 및 jwt 인증 체크
    ControllerAdvice 웹 예외처리
    Scheduler 구성 "@Scheduled"
    
## 테스트 코드
    Web Client 테스트


## 빌드....
    인텔리제이 빌드 > 아티팩트 빌드.. 로 JAR 파일 만들때 파일은 만들어지지만 실행시.
    문제가 생김.. 원인은 모르겠지만 maven 빌드로 변경함
    
    maven 빌드 이슈
    JAVA_HOME 설정 없으면 빌드 오류.
        PC에 java 21에서 빌드 할려니 추가 이슈 발생
        JAVA_HOME을 인텔리제이에서 받은 sdk 위치로 잡아주니 빌드 성공.
        단. 환경변수 변경시 'cmd' 창을 닫았다가 켜야함.


~~JAVA_HOME 없이 빌드 할려면 pom.xml에 프로퍼티 추가후 plugin 설정~~
JAVA_HOME 환경 변수는 무조건 있어야 하는것으로 보임.

## 빌드 jdk 위치 지정.
    * pom.xml 설정 'JAVA_17_HOME' 설정후 plugin 에서 사용
    <properties>
        <JAVA_17_HOME>C:\Users\mhkim\.jdks\corretto-17.0.9</JAVA_17_HOME>
    </properties>

    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.9.0</version>
        <configuration>
            <executable>${JAVA_17_HOME}/Contents/Home/bin/javac</executable>
            <compilerVersion>17</compilerVersion>
        </configuration>
    </plugin>
    

    * 빌드
    $> mvn install -DskipTests