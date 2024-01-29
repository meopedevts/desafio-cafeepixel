package br.com.meopedevts.cafeepixel.controller

import br.com.meopedevts.cafeepixel.dtos.CreateBookDTO
import br.com.meopedevts.cafeepixel.entity.Book
import br.com.meopedevts.cafeepixel.service.BookService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("/")
class BookController(
    val bookService: BookService
) {

    @PostMapping("book")
    fun createBook(@RequestBody createBookDTO: CreateBookDTO): ResponseEntity<Book> {
        val user = bookService.createBook(createBookDTO)
        return ResponseEntity.created(URI.create("/book/${user.id}")).body(user)
    }

    @GetMapping("books")
    fun findBooks(@RequestParam(required = false, name = "title") title: String?): ResponseEntity<List<Book>> {
        title?.let {
            println(it)
            return ResponseEntity.ok(bookService.findBookByTitle(it))
        } ?: run {
            return ResponseEntity.ok(bookService.getAllBooks())
        }

    }

    @GetMapping("book/{id}")
    fun findBookById(@PathVariable("id") id: String): ResponseEntity<Book> {
        return ResponseEntity.ok(bookService.findBookById(id))
    }

    @DeleteMapping("book/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteBook(@PathVariable("id") id: String) {
        bookService.deleteBook(id)
    }
}