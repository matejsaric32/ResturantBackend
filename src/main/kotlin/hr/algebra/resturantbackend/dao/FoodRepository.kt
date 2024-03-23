package hr.algebra.resturantbackend.dao

import hr.algebra.resturantbackend.model.Food
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository

interface FoodRepository : JpaRepository<Food, Long>, PagingAndSortingRepository<Food, Long> {

    @Query("SELECT f FROM Food f WHERE f.code = :code")
    fun findByCode(code: String): Food?

}
