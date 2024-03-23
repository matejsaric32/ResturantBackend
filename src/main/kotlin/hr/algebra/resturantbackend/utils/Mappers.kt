package hr.algebra.resturantbackend.utils

import hr.algebra.resturantbackend.model.Food
import hr.algebra.resturantbackend.model.Restaurant
import hr.algebra.resturantbackend.model.dto.FoodDTO
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

fun FoodDTO.toEntity(): Food {
    return Food(
        code = code,
        name = name,
        price = price,
        description = description,
        restaurant = restaurantDTO.toEntity()
    )
}

fun Food.toDTO(): FoodDTO {
    return FoodDTO(
        code = code,
        name = name,
        price = price,
        description = description,
        restaurantDTO = restaurant.toDTO()
    )
}