package d16;

public class Message {

    private String message;

    private boolean hasMessage = false;

    public synchronized void sendMessage(String message) {
        while (hasMessage) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.message = message;
        hasMessage = true;
        notifyAll();
    }

    public synchronized String receiveMessage() {
        while (!hasMessage) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hasMessage = false;
        notifyAll();
        return message;
    }

}
