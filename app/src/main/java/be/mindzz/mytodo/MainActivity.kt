package be.mindzz.mytodo

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import be.mindzz.mytodo.data.ToDo
import be.mindzz.mytodo.ui.ToDoAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvTodoItems = findViewById<RecyclerView>(R.id.rvToDoList)
        val todoList = mutableListOf<ToDo>()

        // Create the adapter
        val todoAdapter = ToDoAdapter(todoList) {
            // Callback
            if (todoList.isNotEmpty() && todoList.all {it.isChecked}) {
                Toast.makeText(this, "All To do's completed. Apps will be unlocked!", Toast.LENGTH_LONG).show()
            }
        }

        // Set the adapter on the RecyclerView
        rvTodoItems.adapter = todoAdapter

        // Set the LayoutManager
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        val fabAddToDoButton = findViewById<FloatingActionButton>(R.id.fabAddToDo)
        fabAddToDoButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Create a new To-Do")

            val input = EditText(this)
            builder.setView(input)

            builder.setPositiveButton("Add") { dialog, _ ->
                val todoTitle = input.text.toString()
                if (todoTitle.isNotEmpty()) {
                    val newTodo = ToDo(todoTitle)
                    todoList.add(newTodo)
                    todoAdapter.notifyItemInserted(todoList.size - 1)
                }
                dialog.dismiss()
            }
            builder.setNegativeButton("Cancel") { dialog, _ ->
                dialog.cancel()
            }
            builder.show()
        }
    }
}