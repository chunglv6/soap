package com.example.soapClient;

import com.chunglv6_example.*;
import com.example.wsdlfirst.CustomerOrdersImplService;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class CustomerOrderWsClient {
    public static void main(String[] args) throws MalformedURLException {
        CustomerOrdersImplService service = new CustomerOrdersImplService(new URL("http://localhost:8080/wsdlFirstws/customerordersservice?wsdl"));
        CustomerOrdersPortType customerOrdersImplPort = service.getCustomerOrdersImplPort();
        getOrders(customerOrdersImplPort);
        createOrder(customerOrdersImplPort);
        getOrders(customerOrdersImplPort);
    }
    private static void getOrders(CustomerOrdersPortType customerOrdersImplPort){
        GetOrdersRequest request = new GetOrdersRequest();
        request.setCustomerId(BigInteger.valueOf(1));
        GetOrdersResponse response = customerOrdersImplPort.getOrders(request);
        List<Order> orders = response.getOrder();
        System.out.println("number of order : " + orders.size());
    }
    private static void createOrder(CustomerOrdersPortType customerOrdersImplPort){
        CreateOrdersRequest request = new CreateOrdersRequest();
        request.setCustomerId(BigInteger.valueOf(1));
        Order order = new Order();
        order.setId(BigInteger.valueOf(3));
        Product p = new Product();
        p.setId("3");
        p.setDescription("macbook");
        p.setQuantity(BigInteger.valueOf(5));
        order.getProduct().add(p);
        request.setOrder(order);
        CreateOrdersResponse response = customerOrdersImplPort.createOrders(request);
        System.out.println("Result : "+response.isResault());
    }

}
