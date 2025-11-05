package be.mindzz.mytodo.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import be.mindzz.mytodo.R
import be.mindzz.mytodo.data.ToDo

class ToDoAdapter(private val toDoList: List<ToDo>) : RecyclerView.Adapter<ToDoAdapter.TodoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        // I need a new view to display an item. Please create one for me.
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        // set data for item
        val currentTodo = toDoList[position]

        holder.titleTextView.text = currentTodo.title

        holder.checkedCheckBox.isChecked = currentTodo.isChecked

        holder.checkedCheckBox.setOnCheckedChangeListener { _, isChecked ->
            currentTodo.isChecked = isChecked
        }
    }

    override fun getItemCount(): Int {
        return toDoList.size
    }

    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Access views here
        val titleTextView: TextView = itemView.findViewById(R.id.tvTodoTitle)
        val checkedCheckBox: CheckBox = itemView.findViewById(R.id.cbDone)
    }
}