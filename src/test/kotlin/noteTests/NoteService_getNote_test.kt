package noteTests

import Note
import NoteService
import org.junit.Test
import org.junit.Assert.*
import customExceptions.*

class NoteService_getNote_test {
    @Test
    fun get() {
        val service = NoteService()
        val note1 = Note(title = "title", text = "text")
        val note2 = Note(title = "title", text = "text")
        service.add(note1)
        service.add(note2)

        val expected = listOf(note1.copy(id = 1), note2.copy(id = 2))
        val actual = service.get()

        assertEquals(expected, actual)
    }
    @Test
    fun getById() {
        val service = NoteService()
        val note1 = Note(title = "title", text = "text")
        val note2 = Note(title = "title", text = "text")
        service.add(note1)
        service.add(note2)

        val expected = note2.copy(id = 2)
        val actual = service.getById(2)

        assertEquals(expected, actual)
    }
}