package com.example.taskmanager

import android.app.Application
import androidx.room.Room
import com.example.taskmanager.data.local.AppDatabase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).allowMainThreadQueries().build()
        firebaseDB = FirebaseFirestore.getInstance()
        databaseReference = FirebaseDatabase.getInstance().getReference("tasks")

    }
    companion object{
        lateinit var db: AppDatabase
        var firebaseDB: FirebaseFirestore? = null
        var databaseReference: DatabaseReference? = null

    }
}