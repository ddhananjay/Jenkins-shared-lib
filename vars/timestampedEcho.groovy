import org.utils.*
def call(String message) {
    String timestamp = org.utils.HelperUtils.getTimestamp()
    echo "[${timestamp}] ${message}"
    echo HelperUtils.capitalizeString('hieeee')
}
