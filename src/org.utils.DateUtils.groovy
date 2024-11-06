package org.utils

class HelperUtils implements Serializable {

    static String getTimestamp() {  // Define as static to allow direct call
        return new Date().format("yyyy-MM-dd HH:mm:ss")
    }

    static String capitalizeString(String input) {
        return input?.capitalize() ?: ""
    }
}
