package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


// - 스프링 부트 시작하는 메인 클래스
// 1. 내장 tomcat 시작(8080), component-scan 자동 동작 설정
// 2. 우리는 스트링부트 메인 클래스 실행만 하면됨 - run as - spring boot app 선택 실행
// 3. src/main/webapp/resources/application.properties 파일에 
//    /WEB-INF/views/*.jsp 경로와 확장자 설정 필요

@SpringBootApplication 
// 실행 (내장 maven build - run as - maven build... - xxx xxxxx-> 컴파일, 라이브러리 관리, 압축(*.war - pom.xml)
// / 내장 tomcat -실행)
//<context:component-scan base-packages> 대체
// basePackages 생략 시 현재 파일 속해있는 패키지로 인식
@ComponentScan // (basePackages = "com.example.demo")
@ComponentScan(basePackages = "upload")
// @ComponentScan(basePackageClasses = BoardController.class) // BoardController 클래스가 위치한 패키지 scan

// 배열 형태로 나열해도됨
// @ComponentScan(basePackages = {"upload, spring.mybatis.board"})

@ComponentScan(basePackages = "boardmapper")
@MapperScan(basePackages = "boardmapper")
@ComponentScan(basePackages = "websocket")
public class FirstbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstbootApplication.class, args);
		
		System.out.println("firstboot Application start");
	}

}
