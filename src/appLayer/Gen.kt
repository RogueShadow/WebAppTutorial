package appLayer

import net.granseal.chargenlib.*
import java.util.*

object Gen {

    val cG = CharacterGenerator()
    
    fun clearData(){
        cG.nameData = NameDataFactory().empty()
        cG.properties = Properties()
    }
    
    fun addNames(namesForm: String?) {
        if (namesForm == null){
            System.out.println("There were no names.")
            return
        }
        namesForm.lines().forEachIndexed { index, str ->

            System.out.println("$index: $str Size:${str.split(",").size}")
            val name = str.split(",")
            if (name.size == 2) {
                val s = when (name[1].trim()) {
                    "MALE" -> Sex.MALE
                    "FEMALE" -> Sex.FEMALE
                    else -> Sex.RANDOM
                }
                cG.nameData.names.add(Name(s, name[0].trim()))
            }
        }

    }
    
    fun addJobs(jobsForm: String?){
        if (jobsForm == null) return
        jobsForm.lines().forEach { 
            cG.nameData.jobs.add(Job(it))
        }
    }

    fun addRaces(racesForm: String?){
        if (racesForm == null) return
        racesForm.lines().forEach {
            cG.nameData.races.add(Race(it))
        }
    }

    fun addSurNames(surnamesForm: String?){
        if (surnamesForm == null)return
        surnamesForm.lines().forEach {
            cG.nameData.surnames.add(SurName(it))
        }
    }

    fun addPlaces(placesForm: String?){
        if (placesForm == null)return
        placesForm.lines().forEach {
            cG.nameData.cities.add(City(it))
        }
    }

    fun getNames(): String {
        val sb = StringBuilder()
        cG.nameData.names.forEach {
            sb.append("${it.name}, ${it.sex.name}\n")
        }
        return sb.toString()
    }

    fun getJobs(): String {
        val sb = StringBuilder()
        cG.nameData.jobs.forEach {
            sb.append("${it.job}\n")
        }
        return sb.toString()
    }
    
    fun getRaces(): String {
        val sb = StringBuilder()
        cG.nameData.races.forEach {
            sb.append("${it.race}\n")
        }
        return sb.toString()
    }
    
    fun getPlaces(): String {
        val sb = StringBuilder()
        cG.nameData.cities.forEach {
            sb.append("${it.city}\n")
        }
        return sb.toString()
    }
    
    fun getSurNames(): String {
        val sb = StringBuilder()
        cG.nameData.surnames.forEach {
            sb.append("${it.name}\n")
        }
        return sb.toString()
    }
}