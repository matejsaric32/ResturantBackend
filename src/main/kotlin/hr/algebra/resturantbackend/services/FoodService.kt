package hr.algebra.resturantbackend.services

import hr.algebra.resturantbackend.model.dto.FoodDTO
import hr.algebra.resturantbackend.model.dto.RestaurantDTO
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface FoodService {

    fun findAll(pageable: Pageable): Page<FoodDTO>

    fun save(foodDTO: FoodDTO): FoodDTO?

    fun update(foodDTO: FoodDTO): FoodDTO?

    fun deleteByCode(code: String)

}