package org.lomhospital.medicine.bindingModel

import javax.validation.constraints.Size

class ArticleBindingModel(@Size(min=3, max=40) var title: String = "",
                          @Size(min=10) var content: String = "",
                          @Size(max=1000) var imgURL: String = "")