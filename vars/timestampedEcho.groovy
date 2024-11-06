def call(String message) {
    String timestamp = org.my-app.utils.DateUtils.getTimestamp()
    echo "[${timestamp}] ${message}"
}
