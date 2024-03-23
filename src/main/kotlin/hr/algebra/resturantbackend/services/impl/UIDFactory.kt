package hr.algebra.resturantbackend.services.impl

import hr.algebra.resturantbackend.dao.RestaurantRepository
import hr.algebra.resturantbackend.services.UIDFactory
import org.springframework.stereotype.Service

@Service
class UIDFactoryImpl(
    private val restaurantRepository: RestaurantRepository
) : UIDFactory {

    private fun generateUID(): String {
        val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
        val length = 10
        return (1..length)
            .map { chars.random() }
            .joinToString("")
    }

    override fun generateRestaurantUID(): String {
        val restaurantUID = "R" + generateUID()
        restaurantRepository.findByCode(restaurantUID)?.let {
            return generateRestaurantUID()
        }
        return restaurantUID
    }

    override fun generateFoodUID(): String {
        return "F" + generateUID()
    }
}