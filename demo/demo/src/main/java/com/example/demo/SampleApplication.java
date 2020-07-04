package com.example.demo;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

@SpringBootApplication
public class SampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);

		HttpClient httpclient = HttpClients.createDefault();

		try
		{
			URIBuilder builder = new URIBuilder("https://api.sec.or.th/FundFactsheet/fund/amc");


			URI uri = builder.build();
			HttpPost request = new HttpPost(uri);
			request.setHeader("Ocp-Apim-Subscription-Key", "fea0fe602b3a4e4b98245a375bbfc361");


			// Request body
			StringEntity reqEntity = new StringEntity("");
			request.setEntity(reqEntity);

			HttpResponse response = httpclient.execute(request);
			HttpEntity entity = response.getEntity();

			if (entity != null)
			{
				System.out.println(EntityUtils.toString(entity));
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

}
