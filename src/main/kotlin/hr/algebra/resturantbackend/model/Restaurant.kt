package hr.algebra.resturantbackend.model

import hr.algebra.resturantbackend.dao.utils.CategoryConverter
import jakarta.persistence.*
import lombok.Data

@Entity(name = "RESTAURANT")
@Data
open class Restaurant (
    @Id
    @Column(name = "RESTAURANT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open val id: Long? = null,

    @Column(name = "CODE", nullable = false, unique = true)
    open var code: String = "",

    @Column(name = "CATEGORY")
    @Convert(converter = CategoryConverter::class)
    open var category: Category = Category.BARBECUE,

    @Column(name = "NAME", nullable = false)
    open var name: String = "",

    @Column(name = "ADDRESS")
    open var address: String = "",

    @Column(name = "PHONE_NUMBER")
    open var phone: String? = "",

    @OneToMany(mappedBy = "restaurant", cascade = [CascadeType.ALL], fetch = FetchType.EAGER, targetEntity = Food::class)
    open var foods: List<Food> = mutableListOf()
)