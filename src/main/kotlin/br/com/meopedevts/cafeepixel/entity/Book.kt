package br.com.meopedevts.cafeepixel.entity

import br.com.meopedevts.cafeepixel.dtos.CreateBookDTO
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table
class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long = 0,
    @Column(nullable = false)
    val title: String,
    @Column(nullable = false)
    val author: String,
    @Column(nullable = false)
    val synopsis: String,
    val price: Double,
    val image: String,
    val rating: Double
) {
}