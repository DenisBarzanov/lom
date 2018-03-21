package org.lomhospital.medicine.entity

import javax.persistence.*

@Entity
@Table(name = "articles")
data class Article(@Column var title: String = "",
               @Column(length = 4096) var content: String = "",
               @Column(length = 1000) var imgURL: String = "") {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0
}