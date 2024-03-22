package hr.algebra.resturantbackend.dao.utils

import hr.algebra.resturantbackend.model.Category
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter(autoApply = true)
class CategoryConverter : AttributeConverter<Category, String> {
    override fun convertToDatabaseColumn(attribute: Category): String = attribute.displayName

    override fun convertToEntityAttribute(dbData: String): Category = 
        Category.entries.find { it.displayName == dbData }
        ?: throw IllegalArgumentException("Unknown category: $dbData")
}