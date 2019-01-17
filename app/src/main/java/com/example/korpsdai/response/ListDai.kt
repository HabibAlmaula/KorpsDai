package com.example.korpsdai.response

data class ListDai(
    val error: Boolean,
    val allfiles: List<Allfile>
) {
    data class Allfile(
        val id_dai: String,
        val nama_dai: String,
        val email: String,
        val tmpt_lahir: String,
        val tgl_lahir: String,
        val photo: String,
        val dpd: String,
        val password: String
    )
}