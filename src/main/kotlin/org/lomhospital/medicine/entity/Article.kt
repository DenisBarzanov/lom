package org.lomhospital.medicine.entity

import javax.persistence.*

@Entity
@Table(name = "articles")
data class Article(@Column var title: String = "",
               @Column(length = 4096) var content: String = "",
               @ElementCollection var imgURLs: List<String> = listOf<String>()) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0
}
