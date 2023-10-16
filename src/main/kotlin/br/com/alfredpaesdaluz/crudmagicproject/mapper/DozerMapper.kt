package br.com.alfredpaesdaluz.crudmagicproject.mapper

import com.github.dozermapper.core.DozerBeanMapperBuilder
import com.github.dozermapper.core.Mapper


object DozerMapper {

    private val mapper: Mapper? = DozerBeanMapperBuilder.buildDefault()

    fun <Origin, Destination> parseObject(origin: Origin, destination: Class<Destination>?): Destination? {
        return mapper?.map(origin, destination)
    }

    fun <Origin, Destination> parseListObject(origin: List<Origin>, destination: Class<Destination>?): ArrayList<Destination> {
        val destinationObjects: ArrayList<Destination> = ArrayList()
        for (orig in origin) {
            destinationObjects.add(mapper?.map(orig, destination)!!)
        }
        return destinationObjects
    }
}