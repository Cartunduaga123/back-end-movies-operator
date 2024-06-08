package com.unir.movie_app_operator.model.dto;

public record OrderItemsResponse(Long id, String sku, Double price, Long quantity) {
}
