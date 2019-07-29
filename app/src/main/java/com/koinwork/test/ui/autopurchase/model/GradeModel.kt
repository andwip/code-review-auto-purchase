package com.koinwork.test.ui.autopurchase.model

class GradeModel(
    var type: Int = 0,
    var grade: String = "",
    var amount: String = "",
    var tenor: String = "",
    var gradeType: MutableList<GradeType>
)

class GradeType(
    var gradeType: String = ""
)