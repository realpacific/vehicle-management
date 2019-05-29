package com.realpacific.vehiclemanagement.utils

import java.util.*

fun getPastDate(ago: Int = 6): Date {
    return Calendar.getInstance().run {
        add(Calendar.MONTH, -1 * ago)
        time
    }
}


fun getFutureDate(after: Int = 1): Date {
    return Calendar.getInstance().run {
        add(Calendar.MONTH, after)
        time
    }
}