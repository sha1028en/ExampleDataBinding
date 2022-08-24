package com.example.exampledatabinding

data class State( val cnt: String) {

    fun getAddedStringCnt (): String { return ( this.cnt.toInt() +1).toString() }
}