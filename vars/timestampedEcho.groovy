def call(String message) {
    String timestamp = org.utils.DateUtils.getTimestamp()
    echo "[${timestamp}] ${message}"
}
