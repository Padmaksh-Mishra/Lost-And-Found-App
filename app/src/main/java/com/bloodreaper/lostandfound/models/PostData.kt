package com.bloodreaper.lostandfound.models

import android.media.Image

data class PostData(
    val type: String? = null,
    val uid : String? = null,
    val name: String? = null,
    val phone: String? = null,
    val where: String? = null,
    val message: String? = null,
    val image: Image?=null
)