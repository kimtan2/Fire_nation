package com.example.firenation.data

import com.example.firenation.R
import com.example.firenation.model.Personen

object Datasource {
    //  create a function recalling list of persons  and return a list of persons


    fun getPersonenListe(): List<Personen> {
        return listOf(

            Personen(
                R.drawable.zuko,
                R.string.zuko,
                R.string.zuko_beschreibung
            ),
            Personen(
                R.drawable.iroh,
                R.string.iroh,
                R.string.iroh_beschreibung
            ),
            Personen(
                R.drawable.azula,
                R.string.azula,
                R.string.azula_beschreibung
            ),

            Personen(
                R.drawable.mai,
                R.string.mai,
                R.string.mai_beschreibung
            ),
            Personen(
                R.drawable.taylee,
                R.string.taylee,
                R.string.taylee_beschreibung
            ),
            Personen(
                R.drawable.ozai,
                R.string.ozai,
                R.string.ozai_beschreibung
            ),
            Personen(
                R.drawable.ursa,
                R.string.ursa,
                R.string.ursa_beschreibung
            ),
            Personen(
                R.drawable.zhao,
                R.string.zhao,
                R.string.zhao_beschreibung
            ),
            Personen(
                R.drawable.jeong,
                R.string.jeong,
                R.string.jeong_beschreibung
            ),
            Personen(R.drawable.piandao, R.string.piandao, R.string.piandao_beschreibung)
        )


    }
}