package data;

public class Email {
    private String recipient;
    private String topic;
    private String text;

    public String getRecipient() {
        return recipient;
    }

    public String getTopic() {
        return topic;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Email{" +
            "recipient='" + recipient + '\'' +
            ", topic='" + topic + '\'' +
            ", text='" + text + '\'' +
            '}';
    }
}
