package org.lomhospital.medicine.util

const val SEPARATOR = "\r\n"

fun imageUrlList(urls: String): List<String> {
    return urls.split(SEPARATOR)
}

fun List<String>.toUrlString(): String {
    return this.joinToString(SEPARATOR)
}

infix fun String.splitInto(partsCount: Int): List<String> {
    val result = mutableListOf<String>()
    val partSize = this.length / partsCount
    for (i in 0..this.length step partSize + 1)  {
        val part = this.substring(i, Math.min(this.length, i + partSize + 1))
        result.add(part)
    }
//    val residue = this.length % partsCount
//    if (residue != 0) {
//        val lastPart = this.substring(this.length - residue, this.length)
//        result.add(lastPart)
//    }
    return result
}
