package com.example.cash_manager_front

import android.os.Parcelable
import java.text.FieldPosition

interface Communicator{
    fun passDataCom(datafinal: ArrayList<Parcelable>)
}