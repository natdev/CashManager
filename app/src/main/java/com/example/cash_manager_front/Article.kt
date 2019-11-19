package com.example.cash_manager_front

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Article(var name : String, var price : Int, var quantity : Int):Parcelable