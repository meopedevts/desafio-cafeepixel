package br.com.meopedevts.cafeepixel.repository

import br.com.meopedevts.cafeepixel.entity.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository: JpaRepository<Book, Long> {
}