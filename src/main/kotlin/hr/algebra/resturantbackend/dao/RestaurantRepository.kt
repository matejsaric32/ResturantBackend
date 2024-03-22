package hr.algebra.resturantbackend.dao

import hr.algebra.resturantbackend.model.Restaurant
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository

interface RestaurantRepository : JpaRepository<Restaurant, Long>, PagingAndSortingRepository<Restaurant, Long> {

    @Query("SELECT r FROM RESTAURANT r WHERE r.code = :code")
    fun findByCode(code: String): Restaurant?

}