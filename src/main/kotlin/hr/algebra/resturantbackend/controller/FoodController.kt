package hr.algebra.resturantbackend.controller

import hr.algebra.resturantbackend.services.FoodService
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("food")
class FoodController(
    private val foodService: FoodService
) {

    @GetMapping
    fun getRestaurant(@RequestParam(defaultValue = "0") page: Int,
                      @RequestParam(defaultValue = "10") size: Int,
                      @RequestParam(defaultValue = "name") sortBy: String) =
        ResponseEntity.ok(foodService.findAll(PageRequest.of(page, size, Sort.by(sortBy))))

}