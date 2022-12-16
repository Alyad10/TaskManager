package com.example.taskmanager.ui.model

import java.io.Serializable

data class Task(
    var title: String? = null,
    var desc :String? = null,
): Serializable
