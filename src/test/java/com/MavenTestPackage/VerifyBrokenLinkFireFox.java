package com.MavenTestPackage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class VerifyBrokenLinkFireFox {
	int validLinks = 0;
	int invalidLinks = 0;
	
	public void verifyBrokenLinks(String linkUrl) throws IOException {
		
		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpUrlConnect = (HttpURLConnection) url.openConnection();
			httpUrlConnect.connect();
			
			int resCode = httpUrlConnect.getResponseCode();
			
			if (resCode >= 400) {
				System.out.println(url+" : is a broken link"+"---"+httpUrlConnect.getResponseMessage()+"---"+httpUrlConnect.getResponseCode());
				invalidLinks=invalidLinks + 1;
			} else {
				System.out.println(url+" : is a broken link"+"---"+httpUrlConnect.getResponseMessage()+"---"+httpUrlConnect.getResponseCode());
				validLinks = validLinks +1;
			}
			httpUrlConnect.disconnect();
		} catch(MalformedURLException e){
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
