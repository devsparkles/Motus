package fr.kodesparkle.motus.data.mapper

import fr.kodesparkle.motus.domain.model.Word


fun String.toWord(): Word {
    return Word(content = this)
}