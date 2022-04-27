import customExceptions.CommentNotExistException
import customExceptions.NoteNotExistException

class NoteService(
    val notes: MutableList<Note>
) : CrudService<Note> {

    private var noteId: Int = 1

    override fun create(e: Note): Note {
        notes += e.copy(id = noteId)
        noteId++
        return notes.last()
    }

    override fun delete(e: Note): Boolean {
        return if (notes.contains(e)) {
            notes.remove(e)
            true
        } else false
    }

    override fun edit(e: Note): Note {
        for ((index, el) in notes.withIndex()) {
            if (el.id == e.id) {
                notes[index] = e
                return e
            }
        }
         throw NoteNotExistException("Note is not exist")
    }

    override fun getById(id: Int): Note {
        for (note in notes) {
            if (note.id == id) {
                return note
            }
        }
        throw NoteNotExistException("Note is not exist")
    }

    @JvmName("getNotes1")
    fun getNotes(): MutableList<Note> {
        return notes
    }

}