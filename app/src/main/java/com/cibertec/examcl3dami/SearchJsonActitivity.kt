package com.cibertec.examcl3dami

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.cibertec.examcl3dami.services.TodoService

class SearchJsonActitivity : AppCompatActivity() {

    var todoService = TodoService(this)
    lateinit var titleTodo: EditText
    lateinit var completedTodo: EditText
    lateinit var createTodo: Button
    lateinit var listTodo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_json_actitivity)

        // ID's
        titleTodo = findViewById(R.id.titleTodo)
        completedTodo = findViewById(R.id.completedTodo)
        createTodo = findViewById(R.id.createTodo)
        listTodo = findViewById(R.id.listTodo)

        createTodo.setOnClickListener{
            if(titleTodo.text.isNotBlank() && completedTodo.text.isNotBlank()){
                todoService.insertNewTodo(titleTodo.text.toString(), completedTodo.text.toString())
                titleTodo.text.clear()
                completedTodo.text.clear()
                Toast.makeText(this, "REGISTERED SUCCESSFULLY", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "SORRY NOT REGISTERED", Toast.LENGTH_SHORT).show()
            }

        }

        listTodo.setOnClickListener{
            val intent = Intent(this, MyTodosActivity::class.java)
            startActivity(intent)
        }

    }
}