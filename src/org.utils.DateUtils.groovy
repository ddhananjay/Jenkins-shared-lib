package org.utils

class DateUtils {
    static String getTimestamp() {
        return new Date().format("yyyy-MM-dd HH:mm:ss")
    }
}
