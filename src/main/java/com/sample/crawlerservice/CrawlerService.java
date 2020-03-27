package com.sample.crawlerservice;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.jboss.logging.Logger;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

@Component
public class CrawlerService {

	private static final String BASE_URL = "https://www.redhat.com";

	private static final Logger logger = Logger.getLogger(CrawlerService.class);

	public String getUrlSiteMap(String url) {
		try {
			String startKey = url.replace(BASE_URL, "").split("/")[1];
			logger.debug("Url To Crawl : " + url);
			Document doc = getDocumentUrl(url);
			Elements links = doc.select("a[href]");
			return getJsonLink(links, url, startKey).toString();
		} catch (IOException e) {
			logger.error("Jsoup connection Failed : ", e);
		} catch (Exception e) {
			logger.error("Jsoup connection Failed : ", e);
		}
		return null;
	}

	private JSONObject getJsonLink(Elements links, String url, String startKey) {
		Map<String, Set<String>> map = new HashMap<String, Set<String>>();
		String key = null;
		for (Element link : links) {
			if (link.attr("href").contains(url)) {
				key = link.attr("href").replace(url, "").split("/")[1];
			}
			if (!link.attr("href").equals("/" + startKey) && link.attr("href").startsWith("/" + startKey)) {
				key = link.attr("href").replace("/" + startKey, "").split("/")[1];
			}
			if (null != key) {
				if (map.containsKey(key)) {
					if (!link.text().equals("") && (!link.text().contains("facebook"))
							&& (!link.text().contains("Twitter")) && (!link.text().contains("Instagram")))
						map.get(key).add(link.text());
				} else {
					Set<String> lins = new HashSet<String>();
					lins.add(link.text());
					map.put(key, lins);
				}
			}
		}
		return new JSONObject(map);

	}

	private Document getDocumentUrl(String url) throws IOException {
		return Jsoup.connect(url).get();
	}
}
