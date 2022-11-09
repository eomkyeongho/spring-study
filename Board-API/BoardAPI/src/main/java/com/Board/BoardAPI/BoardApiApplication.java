package com.Board.BoardAPI;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.Board.BoardAPI")
public class BoardApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardApiApplication.class, args);
	}

}
