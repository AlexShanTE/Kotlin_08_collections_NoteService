import customExceptions.CommentNotExistException
import customExceptions.NoteNotExistException

class NoteService {
    var notes = mutableListOf<Note>()
    var noteId: Int = 1
    var commentId: Int = 1

    fun add(note: Note): Note {
        notes += note.copy(id = noteId)
        noteId++
        return note
    }

    fun delete(note: Note): Boolean {
        return if (notes.contains(note)) {
            notes.remove(note)
            true
        } else false
    }

    fun edit(note: Note) : Note {
        for ((index, e) in notes.withIndex()) {
            if (e.id == note.id) {
                notes[index] = note
                return note
            }
        }
         throw NoteNotExistException("Note is not exist")
    }

    fun get(): MutableList<Note> {
        return notes
    }

    fun getById(noteId: Int): Note {
        for (note in notes) {
            if (note.id == noteId) {
                return note
            }
        }
        throw NoteNotExistException("Note is not exist")
    }

    fun addComment(comment: Comment): Comment {
        for (note in notes) {
            if (note.id == comment.noteId) {
                val newComment = comment.copy(commentId = commentId)
                note.comments += newComment
                commentId++
                return newComment
            }
        }
        throw NoteNotExistException("Note is not exist")
    }

    fun deleteComment(comment: Comment): Boolean {
        for (note in notes) {
            for ((index, e) in note.comments.withIndex()) {
                if (e.commentId == comment.commentId) {
                    note.comments[index].isDeleted = true
                    return true
                }
            }
        }
        return false
    }

    fun editComment(comment: Comment) : Comment {
        for (note in notes) {
            for ((index, e) in note.comments.withIndex()) {
                if (e.commentId == comment.commentId) {
                    note.comments[index] = comment
                    return comment
                }
            }
        }
        throw CommentNotExistException("Comment not exist")
    }

    fun restoreComment(comment: Comment):Comment {
        for (note in notes) {
            for ((index, e) in note.comments.withIndex()) {
                if (e == comment.copy(isDeleted = true)) {
                    note.comments[index].isDeleted = false
                    return e
                }
            }
        }
        throw CommentNotExistException("Comment not exist")
    }

    fun getComments(note: Note): List<Comment> {
        for (e in notes) {
            if (e.id == note.id) {
                return e.comments
            }
        }
        throw CommentNotExistException("This note has no comments")
    }


}