package com.sample.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.sample.crawlerservice", "com.sample.main", "com.sample.pojo" })
public class CrawlerApplicationMain {
	public static void main(String[] args) {
		SpringApplication.run(CrawlerApplicationMain.class);
	}
}
