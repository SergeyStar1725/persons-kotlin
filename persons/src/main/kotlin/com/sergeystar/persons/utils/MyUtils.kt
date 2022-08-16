package com.sergeystar.persons.utils

import kotlin.reflect.KMutableProperty
import kotlin.reflect.KProperty1
import kotlin.reflect.full.isSupertypeOf
import kotlin.reflect.full.memberProperties


class MyUtils {

    fun copyProps(sourceObject: Any, targetObject: Any, vararg ignoreProps: String){
        // учитываем только изменяемые свойства
        val targetProps = targetObject::class.memberProperties.filterIsInstance<KMutableProperty<*>>()
        // если в 3 аргумент отсутствует то копируем все свойства. Если 3 аргумент присутствует, копируем все свойства, кроме указанных в аргументе
        var sourceProps : Collection<KProperty1<out Any, *>> = sourceObject::class.memberProperties
        var sourcePropsBuff: Collection<KProperty1<out Any, *>>
        if (ignoreProps.isNotEmpty()){
            for(ignoreProp in ignoreProps) {
                sourcePropsBuff = sourceProps.filter {
                    !it.name.equals(ignoreProp)
                }
                sourceProps = sourcePropsBuff
            }
        }
        // копируем все совпадающие свойства, и не копируем игнорируемые своства (3 аргумент)
        targetProps.forEach { targetProp ->
            sourceProps.find {
                // убедиться, что свойства имеют одинаковое имя и совместимые типы
                it.name == targetProp.name && targetProp.returnType.isSupertypeOf(it.returnType) && !ignoreProps.contains(it.name)
            }?.let { matchingProp ->
                targetProp.setter.call(targetObject, matchingProp.getter.call(sourceObject))
            }
        }
    }
}