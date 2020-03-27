package com.sample.crawlerservice;

import org.springframework.web.bind.annotation.RequestBody;

public interface CrawlServiceAPI {
	public String listSitemapEntries(@RequestBody UrlPojo url);
}
