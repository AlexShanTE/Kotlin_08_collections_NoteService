package noteTests

import Note
import NoteService
import org.junit.Test
import org.junit.Assert.*
import customExceptions.*

class NoteService_editNote_test {
    @Test
    fun edit() {
        val service = NoteService()
        val note = Note(title = "title", text = "text")
        service.add(note)

        val expected = Note(id = 1, title = "title", text = "newText")
        val actual = service.edit(note.copy(id = 1, text = "newText"))

        assertEquals(expected, actual)
    }
}