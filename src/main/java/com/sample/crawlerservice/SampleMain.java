package com.sample.crawlerservice;

public class SampleMain {

	public static void main(String[] args) {
		CrawlerService crawlerService = new CrawlerService();
		System.out.println(crawlerService.getUrlSiteMap("https://www.redhat.com/en"));
	}
}
