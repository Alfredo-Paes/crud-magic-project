package br.com.alfredpaesdaluz.crudmagicproject.services

import br.com.alfredpaesdaluz.crudmagicproject.controller.CardMagicController
import br.com.alfredpaesdaluz.crudmagicproject.data.vo.v1.CardMagicVO
import br.com.alfredpaesdaluz.crudmagicproject.exceptions.RequiredObjectsIsNullException
import br.com.alfredpaesdaluz.crudmagicproject.exceptions.ResourceNotFoundException
import br.com.alfredpaesdaluz.crudmagicproject.mapper.DozerMapper
import br.com.alfredpaesdaluz.crudmagicproject.model.CardMagic
import br.com.alfredpaesdaluz.crudmagicproject.repository.CardMagicRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class CardMagicService {

    @Autowired
    private lateinit var repository: CardMagicRepository

    private val logger = Logger.getLogger(CardMagicService::class.java.name)

    fun findAll(): List<CardMagicVO> {
        logger.info("Finding All!")
        var cards = repository.findAll()
        val vos = DozerMapper.parseListObject(cards, CardMagicVO::class.java)
        for (card in vos) {
            val withSelfRel = linkTo(CardMagicController::class.java).slash(card.key).withSelfRel()
            card.add(withSelfRel)
        }
        return vos
    }

    fun findById(id: Long): CardMagicVO {
        logger.info("Finding one card!")
        var card = repository.findById(id).orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        val cardMagicVO: CardMagicVO = DozerMapper.parseObject(card, CardMagicVO::class.java) as CardMagicVO
        val withSelfRel = linkTo(CardMagicController::class.java).slash(cardMagicVO.key).withSelfRel()
        cardMagicVO.add(withSelfRel)
        return cardMagicVO
    }

    fun create(card: CardMagicVO?) : CardMagicVO? {
        if (card == null) throw RequiredObjectsIsNullException()
        logger.info("Creating one card with name ${card.name}")
        var entity: CardMagic = DozerMapper.parseObject(card, CardMagic::class.java) as CardMagic
        val cardMagicVO: CardMagicVO? = DozerMapper.parseObject(repository.save(entity), CardMagicVO::class.java)
        val withSelfRel = linkTo(CardMagicController::class.java).slash(cardMagicVO?.key).withSelfRel()
        cardMagicVO?.add(withSelfRel)
        return cardMagicVO
    }

    fun update(card: CardMagicVO?): CardMagicVO {
        if (card == null) throw RequiredObjectsIsNullException()
        logger.info("Updating one card with ID ${card.key}")
        val entity = repository
            .findById(card.key)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        entity.name = card.name
        entity.type = card.type
        entity.text = card.text
        entity.flavor = card.flavor
        entity.manaCost = card.manaCost
        entity.manaColor = card.manaColor
        entity.power = card.power
        entity.toughness = card.toughness
        val cardMagicVO: CardMagicVO = DozerMapper.parseObject(repository.save(entity), CardMagicVO::class.java) as CardMagicVO
        val withSelfRel = linkTo(CardMagicController::class.java).slash(cardMagicVO?.key).withSelfRel()
        cardMagicVO?.add(withSelfRel)
        return cardMagicVO
    }

    fun delete(id: Long) {
        logger.info("Deleting one card with ID $id")
        val entity = repository
            .findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        repository.delete(entity)
    }
}