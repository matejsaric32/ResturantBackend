package hr.algebra.resturantbackend.services.impl

import hr.algebra.resturantbackend.dao.FoodRepository
import hr.algebra.resturantbackend.dao.RestaurantRepository
import hr.algebra.resturantbackend.model.Restaurant
import hr.algebra.resturantbackend.model.dto.FoodDTO
import hr.algebra.resturantbackend.services.FoodService
import hr.algebra.resturantbackend.utils.toDTO
import hr.algebra.resturantbackend.utils.toEntity
import jakarta.persistence.EntityNotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class FoodServiceImpl(
    private val foodRepository: FoodRepository,
    private val restaurantRepository: RestaurantRepository
) : FoodService {
    override fun findAll(pageable: Pageable): Page<FoodDTO> {
        return foodRepository.findAll(pageable).map { it.toDTO() }
    }

    override fun save(foodDTO: FoodDTO): FoodDTO? {
        val restaurant: Restaurant = restaurantRepository.findByCode(foodDTO.restaurantDTO.code)
            ?: throw EntityNotFoundException("Restaurant with code ${foodDTO.restaurantDTO.code} does not exist")

        return foodRepository.save(foodDTO.toEntity().apply {
            this.restaurant = restaurant
        }).toDTO()
    }

    override fun update(foodDTO: FoodDTO): FoodDTO? {
        TODO("Not yet implemented")
    }

    override fun deleteByCode(code: String) {
        TODO("Not yet implemented")
    }
}