package com.sample.crawlerservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sitemap")
public class CrawlerController implements CrawlServiceAPI {

	@Autowired
	CrawlerService crawlerService;

	@RequestMapping(method = RequestMethod.POST, path = "/url", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String listSitemapEntries(@RequestBody UrlPojo url) {
		
		return crawlerService.getUrlSiteMap(url.getUrl());
	}

}
