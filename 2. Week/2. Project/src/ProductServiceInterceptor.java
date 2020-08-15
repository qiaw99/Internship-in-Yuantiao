package com.yuantiao.test.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
/**
 * 拦截器
 * @author 87290
 *
 */
public class ProductServiceInterceptor implements HandlerInterceptor {

	@Override
	/**
	 * 用于在将请求发送到控制器之前执行操作。此方法应返回true，以将响应返回给客户端。
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Pre Handle method is calling");
		return true;
	}

	@Override
	/**
	 * 用于在将响应发送到客户端之前执行操作。
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("Post Handle method is calling");
	}

	@Override
	/**
	 * 用于在完成请求和响应后执行操作。
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {
		System.out.println("Request and Response is completed");
	}

}
