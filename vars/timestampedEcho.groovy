def call(String message) {
    String timestamp = org.mycompany.utils.Utils.getTimestamp()
    echo "[${timestamp}] ${message}"
}
