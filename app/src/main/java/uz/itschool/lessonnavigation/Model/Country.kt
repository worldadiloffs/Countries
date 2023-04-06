package uz.itschool.lessonnavigation.Model

data class Country(
    var name: String,
    var population: String,
    var area: String,
    var img: String,
    var images: String,
    var images2: String,
    var images3: String,
    var status:Boolean = false
) : java.io.Serializable