package dataLayer

import net.granseal.namegenlib.NameGenDB

object Data {
    val db = NameGenDB()

    fun getWorldList(): String {
        val worlds = StringBuilder()
        db.getWorlds().forEach {
            if (it == db.world) worlds.append("<option selected value=\"$it\">$it</option>\n")
            else worlds.append("<option value=\"$it\">$it</option>\n")
        }
        return worlds.toString()
    }
    fun getGenderList(gender: String, noRandom: Boolean = false): String {
        val genders = StringBuilder()
        mapOf(Pair("M","Male"),Pair("F","Female"),Pair("R","Random")).forEach{
            if (!(it.key == "R" && noRandom)){
                if (it.key == gender) genders.append("<option selected value=\"${it.key}\">${it.value}</option>\n")
                else genders.append("<option value=\"${it.key}\">${it.value}</option>\n")
            }
        }
        return genders.toString()
    }
    fun handleSelection(selected: String, addValue: String?, removeValue: String?): String {
        var response = ""
        if (addValue != null) {
            when (selected) {
                "girlname" -> {
                    response = if (db.addName(addValue, "F")) {
                        "Added name $addValue."
                    } else "$addValue already exists."
                }
                "boyname" -> {
                    response = if (db.addName(addValue, "M")) {
                        "Added name $addValue."
                    } else "$addValue already exists."
                }
                "lastname" -> {
                    response = if (db.addSurName(addValue)) {
                        "Added last name $addValue."
                    } else "$addValue already exists."
                }
                "race" -> {
                    response = if (db.addRace(addValue)) {
                        "Added race $addValue."
                    } else "$addValue already exists."
                }
                "place" -> {
                    response = if (db.addPlace(addValue)) {
                        "Added place $addValue."
                    } else "$addValue already exists."
                }
                "job" -> {
                    response = if (db.addJob(addValue)) {
                        "Added job $addValue."
                    } else "$addValue already exists."
                }
                "world" -> {
                    response = if (db.addWorld(addValue)) {
                        "Added world $addValue."
                    } else "$addValue already exists."
                }
            }
        }else
        if (removeValue != null){
            when (selected) {
                "girlname" -> {
                    db.removeName(removeValue,"F")
                    response = "Removed name $removeValue."
                }
                "boyname" -> {
                    db.removeName(removeValue,"M")
                    response = "Removed name $removeValue."
                }
                "lastname" -> {
                    db.removeSurName(removeValue)
                    response = "Removed last name $removeValue."
                }
                "race" -> {
                    db.removeRace(removeValue)
                    response = "Removed race $removeValue."
                }
                "place" -> {
                    db.removePlace(removeValue)
                    response = "Removed place $removeValue."
                }
                "job" -> {
                    db.removeJob(removeValue)
                    response = "Removed job $removeValue."
                }
                "world" -> {
                    db.removeWorld(removeValue)
                    response = "Removed world $removeValue."
                }
            }
        }
        return response
    }
}