package com.unir.movie_app_operator.model.dto;

import java.util.List;
public record OrderResponse(Long id, String orderNumber, List<OrderItemsResponse> orderItems)  {
}
