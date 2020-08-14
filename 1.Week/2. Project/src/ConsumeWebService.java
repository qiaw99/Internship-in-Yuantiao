package com.yuantiao.test.web.controller;

import java.nio.charset.Charset;
import java.util.Arrays;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.yuantiao.test.web.vo.Product;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

/**
 * Rest模板:
 * 
 * @author 87290
 *
 */
@RestController
public class ConsumeWebService {
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/template/products")
	public String getProductList() {
		HttpHeaders headers = new HttpHeaders(){
			private static final long serialVersionUID = 1L;
			{String auth = "sysadmin" + ":" + "1";
												byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("utf-8")));
												String authHeader = "Basic" + new String(encodedAuth);
												set("Authorization",  authHeader);}};
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate.exchange("http://localhost:4366/products", HttpMethod.GET, entity, String.class).getBody();
	}

	@RequestMapping(value = "/template/products", method = RequestMethod.POST)
	public String createProducts(@RequestBody Product product) {
		HttpHeaders headers = new HttpHeaders(){
			private static final long serialVersionUID = 1L;
			{String auth = "sysadmin" + ":" + "1";
												byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("utf-8")));
												String authHeader = "Basic" + new String(encodedAuth);
												set("Authorization",  authHeader);}};
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Product> entity = new HttpEntity<Product>(product, headers);
		return restTemplate.exchange("http://localhost:4366/products", HttpMethod.POST, entity, String.class).getBody();
	}
	
	@RequestMapping(value = "/template/products/{id}", method = RequestMethod.PUT)
	public String updateProducts(@PathVariable("id") String id, @RequestBody Product product) {
		HttpHeaders headers = new HttpHeaders(){
			private static final long serialVersionUID = 1L;
			{String auth = "sysadmin" + ":" + "1";
												byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("utf-8")));
												String authHeader = "Basic" + new String(encodedAuth);
												set("Authorization",  authHeader);}};
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Product> entity = new HttpEntity<Product>(product, headers);

		return restTemplate.exchange("http://localhost:4366/products/" + id, HttpMethod.PUT, entity, String.class)
				.getBody();
	}

	@RequestMapping(value = "/template/products/{id}", method = RequestMethod.DELETE)
	public String deleteProduct(@PathVariable("id") String id) {
		HttpHeaders headers = new HttpHeaders(){
			private static final long serialVersionUID = 1L;
			{String auth = "sysadmin" + ":" + "1";
												byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("utf-8")));
												String authHeader = "Basic" + new String(encodedAuth);
												set("Authorization",  authHeader);}};
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Product> entity = new HttpEntity<Product>(headers);

		return restTemplate.exchange("http://localhost:4366/products/" + id, HttpMethod.DELETE, entity, String.class)
				.getBody();
	}

}