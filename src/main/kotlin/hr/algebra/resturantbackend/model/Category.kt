package hr.algebra.resturantbackend.model

enum class Category(val displayName: String) {
    ITALIAN("Italian"),
    FRENCH("French"),
    AMERICAN("American"),
    MEXICAN("Mexican"),
    JAPANESE("Japanese"),
    CHINESE("Chinese"),
    INDIAN("Indian"),
    THAI("Thai"),
    MEDITERRANEAN("Mediterranean"),
    VEGETARIAN("Vegetarian"),
    VEGAN("Vegan"),
    BARBECUE("Barbecue"),
    SEAFOOD("Seafood"),
    STEAKHOUSE("Steakhouse"),
    CAFE("Cafe");

    companion object {
        fun fromDisplayName(displayName: String): Category? = entries.find { it.displayName == displayName }
    }
}

