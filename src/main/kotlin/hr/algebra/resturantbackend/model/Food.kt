package hr.algebra.resturantbackend.model

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "FOOD")
open class Food(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FOOD_ID")
    open val id: Int? = null,

    @Column(name = "CODE", nullable = false, unique = true)
    open var code: String,

    @Column(name = "NAME", nullable = false)
    open var name: String,

    @Column(name = "DESCRIPTION")
    open var description: String? = null,

    @Column(name = "PRICE", precision = 10, scale = 2)
    open var price: BigDecimal,

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID", referencedColumnName = "RESTAURANT_ID")
    open var restaurant: Restaurant
)