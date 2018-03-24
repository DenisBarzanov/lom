package org.lomhospital.medicine.controller

import org.lomhospital.medicine.repository.ArticleRepository
import org.lomhospital.medicine.util.splitInto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

const val ARTICLE_PATH = "article"

@Controller
class FrontArticleController @Autowired
constructor(private val articleRepository: ArticleRepository) {

    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute("view", "$ARTICLE_PATH/all")
        val articles = this.articleRepository.findAll()
        model.addAttribute("articles", articles)
        return "base-layout"
    }

    @GetMapping("/article/{id}")
    fun article(model: Model, @PathVariable id: Int): String {
        model.addAttribute("view", "$ARTICLE_PATH/article")
        val article = this.articleRepository.getOne(id)
        model.addAttribute("article", article)
        val contents = article.content splitInto article.imgURLs.size
        model.addAttribute("contents", contents)
        return "base-layout"
    }
}
