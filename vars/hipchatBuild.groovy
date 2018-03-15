@Grab('ch.viascom:hipchat-api:2.1-RC3')
import ch.viascom.hipchat.api.HipChat

def call(status, owner, message, buildJob, hipchatUrl, token, debug = false) {
    def hipchat = HipChat(token, hipchatUrl)
    if (debug) hipchat.activateFoxHttpLogging()

    hipchat.usersApi().sendPrivateMessage(owner, PrivateMessage("$buildJob is $status: $message", true, MessageFormat.TEXT))
}