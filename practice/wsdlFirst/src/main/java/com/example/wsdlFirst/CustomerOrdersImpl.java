package com.example.wsdlFirst;
import com.chunglv6_example.*;
import org.apache.cxf.feature.Features;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class CustomerOrdersImpl implements CustomerOrdersPortType {
    Map<BigInteger, List<Order>>  customerOrders = new HashMap<>();
    int currentId;

    public CustomerOrdersImpl() {
        init();
    }

    public void init(){
        List<Order> orders = new ArrayList<>();
        Order order = new Order();
        order.setId(BigInteger.valueOf(1));
        Product product = new Product();
        product.setId("1");
        product.setDescription("iphone");
        product.setQuantity(BigInteger.valueOf(3));
        order.getProduct().add(product);
        orders.add(order);
        customerOrders.put(BigInteger.valueOf(++currentId),orders);
    }

    @Override
    public GetOrdersResponse getOrders(GetOrdersRequest request) {
        BigInteger customerId = request.getCustomerId();
        List<Order> orders = customerOrders.get(customerId);
        GetOrdersResponse getOrdersResponse = new GetOrdersResponse();
        getOrdersResponse.getOrder().addAll(orders);
        return getOrdersResponse;
    }

    @Override
    public CreateOrdersResponse createOrders(CreateOrdersRequest req) {
        BigInteger customerId = req.getCustomerId();
        Order order = req.getOrder();
        List<Order> orders = customerOrders.get(customerId);
        orders.add(order);
        CreateOrdersResponse createOrdersResponse = new CreateOrdersResponse();
        createOrdersResponse.setResault(true);
        return createOrdersResponse;
    }

    @Override
    public DeleteOrderResponse deleteOrders(DeleteOrderRequest req) {
        BigInteger customerId = req.getCustomerId();
        List<Order> orders = customerOrders.get(customerId);
        Order order = orders.stream().filter(o->o.getId().equals(req.getOrderId())).findFirst().orElse(null);
        orders.remove(order);
        DeleteOrderResponse response = new DeleteOrderResponse();
        response.setResult(true);
        return response;
    }
}
