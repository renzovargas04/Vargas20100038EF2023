package com.example.vargas20100038ef2023.model

import java.io.Serializable

data class ProductoModel(
    val id: String = "",
    val descripcion: String = "",
    val cantidad: String = "",
    val precio: String = ""
): Serializable
