package hr.algebra.resturantbackend.model.dto

import java.math.BigDecimal

//todo valdiation
data class FoodDTO(
    val code: String = "",
    val name: String,
    val price: BigDecimal = BigDecimal.ZERO,
    val description: String? = null,
    val restaurantDTO: RestaurantDTO
)
