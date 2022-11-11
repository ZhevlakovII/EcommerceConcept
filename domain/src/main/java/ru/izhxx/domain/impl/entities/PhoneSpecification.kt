package ru.izhxx.domain.impl.entities

import android.graphics.Color

data class PhoneSpecification(
    val cpu: String,
    val camera: String,
    val memory: String,
    val ram: String,
    val colors: List<Int>,
    val capacity: List<Int>
)
