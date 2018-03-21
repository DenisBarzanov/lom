package org.lomhospital.medicine.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.lomhospital.medicine.entity.Article

@Repository
interface ArticleRepository : JpaRepository<Article?, Int>