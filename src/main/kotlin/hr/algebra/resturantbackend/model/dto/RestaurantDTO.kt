package hr.algebra.resturantbackend.model.dto

import hr.algebra.resturantbackend.model.Category
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import lombok.Data

@Data
data class RestaurantDTO (
    @field:NotBlank(message = "Name must not be blank")
    val name : String,

    var code: String = "",

    @field:NotNull(message = "Category must not be null")
    val category : Category,

    @field:NotBlank(message = "Address must not be blank")
    val address : String,

    @field:NotBlank(message = "Phone number must not be blank")
    @field:Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Phone number is invalid")
    val phone : String?,

    val foods: List<FoodDTO>? = null
)

