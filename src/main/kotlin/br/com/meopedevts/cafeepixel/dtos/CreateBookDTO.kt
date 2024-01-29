package br.com.meopedevts.cafeepixel.dtos

import br.com.meopedevts.cafeepixel.entity.Book

data class CreateBookDTO(
    val title: String,
    val author: String,
    val synopsis: String,
    val price: Double,
    val image: String,
    val rating: Double
)

fun CreateBookDTO.toEntity() = Book (
    title = title,
    author = author,
    synopsis = synopsis,
    price = price,
    image = image,
    rating = rating
)