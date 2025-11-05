package be.mindzz.mytodo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import be.mindzz.mytodo.data.ToDo
import be.mindzz.mytodo.ui.ToDoAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvTodoItems = findViewById<RecyclerView>(R.id.rvToDoList)
        val todoList = listOf(
            ToDo("todo 1"),
            ToDo("todo 2"),
            ToDo("todo 3")
        )

        // Create the adapter
        val todoAdapter = ToDoAdapter(todoList)

        // Set the adapter on the RecyclerView
        rvTodoItems.adapter = todoAdapter

        // Set the LayoutManager
        rvTodoItems.layoutManager = LinearLayoutManager(this)

    }
}