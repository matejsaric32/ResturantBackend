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
    open var id: Long? = null,

    @Column(name = "CODE")
    open var code: String = "",

    @Column(name = "CATEGORY")
    @Convert(converter = CategoryConverter::class)
    open var category: Category,

    @Column(name = "NAME")
    open var name: String = "",

    @Column(name = "ADDRESS")
    open var address: String = "",

    @Column(name = "PHONE_NUMBER")
    open var phone: String = "",
)