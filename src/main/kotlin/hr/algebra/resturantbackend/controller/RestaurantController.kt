package hr.algebra.resturantbackend.controller

import hr.algebra.resturantbackend.model.dto.RestaurantDTO
import hr.algebra.resturantbackend.services.RestaurantServices
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("restaurant")
class RestaurantController(
    private val restaurantServices: RestaurantServices) {

    @GetMapping
    fun getRestaurant(@RequestParam(defaultValue = "0") page: Int,
                    @RequestParam(defaultValue = "10") size: Int,
                    @RequestParam(defaultValue = "name") sortBy: String) =
        ResponseEntity.ok(restaurantServices.findAll(PageRequest.of(page, size, Sort.by(sortBy))))

    @PostMapping
    fun addHardware(@RequestBody restaurantDTO: RestaurantDTO) =
        ResponseEntity.ok(restaurantServices.save(restaurantDTO))

    @PutMapping
    fun updateHardware(@RequestBody restaurantDTO: RestaurantDTO) =
        ResponseEntity.ok(restaurantServices.update(restaurantDTO))

    @DeleteMapping("/{code}")
    fun deleteHardwareByCode(@PathVariable code: String) =
        ResponseEntity.ok(restaurantServices.deleteByCode(code))

}