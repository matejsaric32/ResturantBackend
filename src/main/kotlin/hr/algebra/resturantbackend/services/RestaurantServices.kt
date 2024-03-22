package hr.algebra.resturantbackend.services

import hr.algebra.resturantbackend.model.dto.RestaurantDTO
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface RestaurantServices {

    fun findAll(pageable: Pageable): Page<RestaurantDTO>

    fun save(restaurantDTO: RestaurantDTO): RestaurantDTO?

    fun update(restaurantDTO: RestaurantDTO): RestaurantDTO?

    fun deleteByCode(code: String)

}