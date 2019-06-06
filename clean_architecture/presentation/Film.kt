import domain.Film as DomainFilm

data class Film (val title: String, val status: String)

//for this layer use own Film model, convert Film model from domain
//use Kotlin import as feature
fun DomainFilm.toPresentation(): Film {
    if(vote == null || vote == 0) return Film(title, "To watch!")
    else return Film(title, "$vote/10")
}