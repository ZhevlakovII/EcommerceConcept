package ru.izhxx.domain.impl.entities

import android.graphics.Color

data class PhoneSpecification(
    val cpu: String,
    val camera: String,
    val memory: Int,
    val ram: Int,
    val colors: List<Color>,
    val capacity: List<Int>
)
