package br.com.alfredpaesdaluz.crudmagicproject.repository

import br.com.alfredpaesdaluz.crudmagicproject.model.CardMagic
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CardMagicRepository: JpaRepository<CardMagic, Long?>