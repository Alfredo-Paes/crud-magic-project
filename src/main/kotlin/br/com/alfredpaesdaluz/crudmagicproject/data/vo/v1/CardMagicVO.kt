package br.com.alfredpaesdaluz.crudmagicproject.data.vo.v1

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.dozermapper.core.Mapping
import org.springframework.hateoas.RepresentationModel

data class CardMagicVO(
    @Mapping("id")
    @field:JsonProperty("id")
    var key: Long = 0,
    var name: String = "",
    var type: String = "",
    var text: String = "",
    var flavor: String = "",
    var manaCost: String = "",
    var manaColor: String = "",
    var power: Int = 0,
    var toughness: Int = 0
) : RepresentationModel<CardMagicVO> ()
