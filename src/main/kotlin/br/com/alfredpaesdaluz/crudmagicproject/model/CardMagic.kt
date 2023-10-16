package br.com.alfredpaesdaluz.crudmagicproject.model

import jakarta.persistence.*

@Entity
@Table(name="card_magic")

data class CardMagic(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(nullable = false, length = 80)
    var name: String = "",

    @Column(nullable = false, length = 20)
    var type: String = "",

    @Column(nullable = false, length = 500)
    var text: String = "",

    @Column(length = 500)
    var flavor: String = "",

    @Column(name = "mana_cost", nullable = false, length = 20)
    var manaCost: String = "",

    @Column(name = "mana_color", nullable = false, length = 20)
    var manaColor: String = "",

    @Column(nullable = true)
    var power: Int = 0,

    @Column(nullable = true)
    var toughness: Int = 0,
)
