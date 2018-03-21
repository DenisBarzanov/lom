package org.lomhospital.medicine.controller.admin

import org.lomhospital.medicine.bindingModel.ArticleBindingModel
import org.lomhospital.medicine.entity.Article
import org.lomhospital.medicine.repository.ArticleRepository
import javax.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

const val PATH_ADMIN_ARTICLE = "admin/article"

@RequestMapping("/$PATH_ADMIN_ARTICLE")
@Controller
class CarController @Autowired
constructor(private val articleRepository: ArticleRepository) {

    @GetMapping("/create")
    fun create(model: Model): String {
        model.run {
            addAttribute("article", ArticleBindingModel())
            addAttribute("view", "$PATH_ADMIN_ARTICLE/create")
        }
        return "base-layout"
    }

    @PostMapping("/create")
    fun createProcess(model: Model, @Valid articleBindingModel: ArticleBindingModel, bindingResult: BindingResult): String {
        if (bindingResult.hasErrors()) {
            model.run {
                addAttribute("view", "$PATH_ADMIN_ARTICLE/create")
                addAttribute("message", "Invalid data.")
                addAttribute("article", articleBindingModel)
            }
            return "base-layout"
        }
        val article = Article(articleBindingModel.title, articleBindingModel.content, articleBindingModel.imgURL)
        this.articleRepository.saveAndFlush(article)
        return "redirect:/$PATH_ADMIN_ARTICLE/all"
    }

    @GetMapping("/{id}/edit")
    fun edit(model: Model, @PathVariable id: Int): String {
        val article = this.articleRepository.getOne(id) ?: return "redirect:/${PATH_ADMIN_ARTICLE}/all"
        model.run {
            addAttribute("article", article)
            addAttribute("view", "$PATH_ADMIN_ARTICLE/edit")
        }
        return "base-layout"
    }

    @PostMapping("/{id}/edit")
    fun editProcess(model: Model, @PathVariable id: Int, @Valid articleBindingModel: ArticleBindingModel, bindingResult: BindingResult): String {
        if (bindingResult.hasErrors()) {
            model.run {
                addAttribute("message", "Invalid data.")
                addAttribute("article", articleBindingModel)
                addAttribute("view", "$PATH_ADMIN_ARTICLE/edit")
            }
            return "base-layout"
        }
        val article = this.articleRepository.getOne(id) ?: return "redirect:/${PATH_ADMIN_ARTICLE}/all"

        with(article) {
            title = articleBindingModel.title
            content = articleBindingModel.content
            imgURL = articleBindingModel.imgURL
        }

        this.articleRepository.saveAndFlush(article)
        return "redirect:/$PATH_ADMIN_ARTICLE/all"
    }

    @GetMapping("/{id}/delete")
    fun delete(model: Model, @PathVariable id: Int): String {
        val article = this.articleRepository.getOne(id) ?: return "redirect:/${PATH_ADMIN_ARTICLE}/all"
        with(model) {
            addAttribute("article", article)
            addAttribute("view", "$PATH_ADMIN_ARTICLE/delete")
        }
        return "base-layout"
    }

    @PostMapping("/{id}/delete")
    fun deleteProcess(@PathVariable id: Int): String {
        val article = this.articleRepository.getOne(id) ?: return "redirect:/${PATH_ADMIN_ARTICLE}/all"
        this.articleRepository.delete(article)
        this.articleRepository.flush()
        return "redirect:/$PATH_ADMIN_ARTICLE/all"
    }

    @GetMapping("/all")
    fun all(model: Model): String {
        model.addAttribute("view", "$PATH_ADMIN_ARTICLE/all")
        val articles = this.articleRepository.findAll()
        model.addAttribute("articles", articles)
        return "base-layout"
    }
}
