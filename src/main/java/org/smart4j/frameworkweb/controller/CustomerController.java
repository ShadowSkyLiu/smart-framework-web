package org.smart4j.frameworkweb.controller;

import org.smart4j.framework.annotation.Action;
import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.bean.Handler;
import org.smart4j.framework.bean.Param;
import org.smart4j.framework.bean.View;
import org.smart4j.framework.helper.BeanHelper;
import org.smart4j.framework.helper.ControllerHelper;
import org.smart4j.frameworkweb.model.Customer;
import org.smart4j.frameworkweb.service.CustomerService;

import java.util.List;
import java.util.Map;

@Controller
public class CustomerController {

    @Inject
    private CustomerService customerService;

    @Action("get:/customer")
    public View index(Param param) {
        List<Customer> customers = customerService.getCustomerList();
        return new View("customer.jsp").addModel("customerList", customers);
    }

    public static void main(String[] args) {
//        // test Bean容器
//        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
//        System.out.print(beanClassSet);

//        // test BeanHelper
//        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
//        System.out.print(beanMap);

//        // test Ioc反转
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
//        IocHelper.fun();

        // test Controller Handler
        Handler handler = ControllerHelper.getHandler("get", "/customer");
    }
}
