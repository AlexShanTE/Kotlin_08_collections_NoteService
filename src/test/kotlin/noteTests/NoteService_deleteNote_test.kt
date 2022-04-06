package noteTests
import Note
import NoteService
import org.junit.Test
import org.junit.Assert.*
import customExceptions.*


class NoteService_deleteNote_test {
    @Test
    fun deleteTrue() {
        val service = NoteService()
        val note = Note(title = "title", text = "text")
        service.add(note)

        val expectedResultOfDelete = true
        val actualResultOfDelete = service.delete(note.copy(id = 1))
        assertEquals(expectedResultOfDelete, actualResultOfDelete)
    }
    @Test
    fun deleteFalse() {
        val service = NoteService()
        val note = Note(title = "title", text = "text")
        service.add(note)

        val expectedResultOfDelete = false
        val actualResultOfDelete = service.delete(note.copy(id = 9999))
        assertEquals(expectedResultOfDelete, actualResultOfDelete)
    }

}