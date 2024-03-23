package hr.algebra.resturantbackend.services.impl

import hr.algebra.resturantbackend.dao.RestaurantRepository
import hr.algebra.resturantbackend.model.dto.RestaurantDTO
import hr.algebra.resturantbackend.services.RestaurantServices
import hr.algebra.resturantbackend.services.UIDFactory
import hr.algebra.resturantbackend.utils.toDTO
import hr.algebra.resturantbackend.utils.toEntity
import jakarta.persistence.EntityNotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class RestaurantServicesImpl (
    private val restaurantRepository: RestaurantRepository,
    private val uidFactory: UIDFactory) : RestaurantServices {
    override fun findAll(pageable: Pageable): Page<RestaurantDTO> =
        restaurantRepository.findAll(pageable).map { it.toDTO() }

    override fun save(restaurantDTO: RestaurantDTO): RestaurantDTO {
        restaurantDTO.toEntity().apply {
            code = uidFactory.generateRestaurantUID()
            return restaurantRepository.save(this).toDTO()
        }
    }

    override fun update(restaurantDTO: RestaurantDTO): RestaurantDTO? {
        restaurantRepository.findByCode(restaurantDTO.code)?.apply {
            code = restaurantDTO.code
            category = restaurantDTO.category
            name = restaurantDTO.name
            address = restaurantDTO.address
            phone = restaurantDTO.phone
        }?.let{
            return restaurantRepository.save(it).toDTO()
        } ?: throw EntityNotFoundException("Restaurant with code ${restaurantDTO.code} does not exist")
    }

    override fun deleteByCode(code: String) {
        restaurantRepository.findByCode(code)?.let {
            restaurantRepository.delete(it)
        } ?: throw EntityNotFoundException("Restaurant with code $code does not exist")
    }
}