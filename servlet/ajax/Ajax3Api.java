package com.study.service.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import lombok.Builder;

@WebServlet("/api/ajax3")
public class Ajax3Api extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		String JsonData = request.getParameter("data");

		Map<String, Object> dataMap = gson.fromJson(JsonData, Map.class);
		/*
		 * List<String> phoneNumbers = new ArrayList<>();
		 * 
		 * dataMap.forEach((key, value) -> { if(value.getClass() == String.class ) {
		 * phoneNumbers.add((String)value); } });
		 */

		response.setContentType("application/json; charset=utf8"); //text/plain -> 일반 텍스트 문자열,  응답형태를 application/json 형태로 받는것
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		PrintWriter out = response.getWriter();
		
		
		StringBuilder stringBuilder = new StringBuilder();

		dataMap.forEach((key, value) -> {
			stringBuilder.append(value); // append : 문자열을 더하는것  010 + - + XXXX + - + XXXX + -    -> 010-XXXX-XXXX- 
			stringBuilder.append("-");
		}); 
		stringBuilder.delete(stringBuilder.length() -1, stringBuilder.length());  // stringBuilder.length()(문자열 총 갯수) 에서 -1 넣어 마지막 - 을 빼낸다 
		
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("responseData", stringBuilder.toString());
		
		out.print(jsonObject.toString());
	}

}
