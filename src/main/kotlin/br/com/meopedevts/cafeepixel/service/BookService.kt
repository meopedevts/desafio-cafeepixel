package br.com.meopedevts.cafeepixel.service

import br.com.meopedevts.cafeepixel.dtos.CreateBookDTO
import br.com.meopedevts.cafeepixel.dtos.toEntity
import br.com.meopedevts.cafeepixel.entity.Book
import br.com.meopedevts.cafeepixel.repository.BookRepository
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class BookService(
    val bookRepository: BookRepository
) {

    fun createBook(createBookDTO: CreateBookDTO): Book {
        return bookRepository.save(createBookDTO.toEntity())
    }

    fun getAllBooks(): List<Book> {
        return bookRepository.findAll()
    }

    fun deleteBook(id: String) {
        bookRepository.deleteById(id.toLong())
    }

    fun findBookById(id: String): Book {
        return bookRepository.findById(id.toLong()).orElseThrow { Exception("Usuário não econtrado!") }
    }

    fun findBookByTitle(title: String): List<Book> {
        return bookRepository.findByTitleContainingIgnoreCase(title)
    }
}