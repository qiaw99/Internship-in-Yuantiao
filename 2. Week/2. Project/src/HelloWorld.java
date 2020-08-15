package com.yuantiao.test.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yuantiao.test.web.vo.Product;

/**
 * 定义RESTful Web服务， 提供JSON, XML自定义响应
 * @author 87290
 *
 */
@RestController
public class HelloWorld {
	
	private static Map<String, Product> productRepo = new HashMap<>();
	static{
		Product honey = new Product();
		honey.setId("1");
		honey.setName("Honey");
		productRepo.put(honey.getId(), honey);
		
		Product almond = new Product();
		almond.setId("2");
		almond.setName("Almond");
		productRepo.put(almond.getId(), almond);
	}
	/**
	 * @RequestMapping注释用于定义访问REST端点的Request URI。
	 * 可以定义Request方法来使用和生成对象。默认请求方法是:GET。
	 * @return
	 */
//	@RequestMapping("/products")
//	public ResponseEntity<Object> getProducts(){
//		return null;
//	}
	
	/**
	 * @RequestBody注释用于定义请求正文内容类型。
	 * POST API
	 * @param product
	 * @return
	 */
	@RequestMapping(value = "/products/", method = RequestMethod.POST)
	public ResponseEntity<Object> createProduct(@RequestBody Product product){
		productRepo.put(product.getId(), product);
		return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
		
	}
	
	/**
	 * @PathVariable批注用于定义自定义或动态请求URI。 请求URI中的Path变量定义为花括号{}
	 * Put API
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "products/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct
		(@PathVariable("id") String id, @RequestBody Product product)
		throws ProductNotFoundException{
		if(!productRepo.containsKey(id)){
			throw new ProductNotFoundException();
		}
		productRepo.remove(id);
		product.setId(id);
		productRepo.put(id, product);
		return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
		
	}
	
	/**
	 * @RequestParam注释用于从请求URL读取请求参数。默认情况下，它是必需参数。还可以为请求参数设置默认值
	 * GET API
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/products")
	public ResponseEntity<Object> getProduct(@RequestParam(value = "name", 
			required = false, defaultValue = "honey") String name){
		return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") String id) 
			throws ProductNotFoundException{
		if(!productRepo.containsKey(id)){
			throw new ProductNotFoundException();
		}
		
		productRepo.remove(id);
		return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
	}
}
