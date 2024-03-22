package hr.algebra.resturantbackend.utils

import hr.algebra.resturantbackend.model.Restaurant
import hr.algebra.resturantbackend.model.dto.RestaurantDTO

fun RestaurantDTO.toEntity(): Restaurant {
    return Restaurant(
        code = code,
        name = name,
        category = category,
        address = address,
        phone = phone
    )
}

fun Restaurant.toDTO(): RestaurantDTO {
    return RestaurantDTO(
        code = code,
        category = category,
        name = name,
        address = address,
        phone = phone
    )
}
