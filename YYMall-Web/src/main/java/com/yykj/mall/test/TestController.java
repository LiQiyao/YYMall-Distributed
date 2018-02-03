package com.yykj.mall.test;

import com.yykj.mall.TestService;
import com.yykj.mall.common.ServerResponse;
import com.yykj.mall.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Lee
 * @date 2018/1/1
 */
@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private IProductService productService;

    @RequestMapping("/x.json")
    @ResponseBody
    public ServerResponse x(){
        System.out.println("huhuhu");
        System.out.println(testService);
        System.out.println(productService.getProductList(1, 10));
        return ServerResponse.createBySuccess(testService.hello());
    }
}
