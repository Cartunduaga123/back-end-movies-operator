package com.unir.movie_app_operator.service;

import com.unir.movie_app_operator.model.dto.BaseResponse;
import com.unir.movie_app_operator.model.dto.OrderRequest;
import com.unir.movie_app_operator.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class OrderService {
    /*private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;

    public void placeOrder(OrderRequest orderRequest) {

        //Check for inventory
        BaseResponse result = this.webClientBuilder.build()
                .post()
                .uri("lb://MOVIE-APP-SEARCH")
                .bodyValue(orderRequest.getOrderItems())
                .retrieve()
                .bodyToMono(BaseResponse.class)
                .block();
        if (result != null && !result.hasErrors()) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setOrderItems(orderRequest.getOrderItems().stream()
                    .map(orderItemRequest -> mapOrderItemRequestToOrderItem(orderItemRequest, order))
                    .toList());
            this.orderRepository.save(order);
        } else {
            throw new IllegalArgumentException("Some of the products are not in stock");
        }
    }*/
}
