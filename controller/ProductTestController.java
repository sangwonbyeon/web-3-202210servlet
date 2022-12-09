package com.study.springboot202210sangwon.web.controller;

import com.study.springboot202210sangwon.web.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProductTestController {

    @GetMapping("/product/addition")
    public String loadAdditions() {
        return "product/product_add";
    }

    /*
    @PostMapping("/api/product")
    public String registerProduct(HttpServletRequest request){
        System.out.println(request.getParameter("price"));  //getParameter 리턴타입 String
        return "product/product_view";
    }
    */
//--------------------------↓request.getParameter 를 줄이기↓---------------------------------------
    /*
    @PostMapping("/api/product")
    public String registerProduct(@RequestParam("productName") String pn, @RequestParam("price") int p){
        //@RequestParam 형변환이 필요없다 매개변수 int 로 잡아서 숫자 형
        System.out.println(pn);
        System.out.println(p);
        return "product/product_view";
    }
    */
//--------------------------↓Param 줄이기↓---------------------------------------
    /*
    @PostMapping("/api/product")
    public String registerProduct(String productName, @RequestParam("price") int p){
        //변수명이랑 Param 같이 같으면 줄일수 있다 또한 @RequestParam 도 생략이 가능하다
        System.out.println(productName);
        System.out.println(p);
        return "product/product_view";
    }
    // 웬만하면 @RequestParam 은 붙이는게 좋다
    */
//--------------------------↓다시 @RequestParam 형태로 ↓---------------------------------------
    /*
    @PostMapping("/api/product")
    public String registerProduct(@RequestParam String productName,
                                  @RequestParam String productCode,
                                  @RequestParam("price") int p,
                                  @RequestParam int stock) {

        System.out.println(productName);
        System.out.println(productCode);
        System.out.println(stock);
        System.out.println(p);
        return "product/product_view";
    }
    */
//--------------------------↓ProductDto 객체로 담아서 ↓---------------------------------------
    @PostMapping("/api/product")
    public String registerProduct(Model model, ProductDto productDto) {  //객체 형태로 넘어온다
        model.addAttribute("productDto", productDto);
        System.out.println(productDto);
        return "product/product_view";
    }

    @GetMapping("/product/addition2")
    public String loadAddition2(){
        return "product/product_add2";
    }

    @ResponseBody  //데이터 응답, 떨어지면 뷰 응답  @ResponseBody 가 없으면 view Resolver , view 를 거치지 않고 controller 에서 바로 응답해준다
    @PostMapping("/api/product/2")
    public String registerProduct(ProductDto productDto) {
        System.out.println(productDto);
        return productDto.toString();  //@ResponseBody 가 있으면 text/plain 형태  없으면 html 타입  만약 객체면은 Json 으로 리턴해줘야한다
    }

    /*
    @PostMapping("/api/product/2")
    public String registerProduct(ProductDto productDto) {
        System.out.println(productDto);
        return "텍스트 데이터 응답";
    }
    */
    /*
    @ResponseBody
    @PostMapping("/api/product/2")
    public String registerProduct(@RequestBody  ProductDto productDto) {
        System.out.println(productDto);
        return "텍스트 데이터 응답";
    }
    */


}
