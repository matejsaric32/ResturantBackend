package hr.algebra.resturantbackend.services

interface UIDFactory {
    fun generateRestaurantUID(): String
    fun generateFoodUID(): String
}