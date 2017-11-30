package ru.ivmiit;
/**
 * 10.11.2017
 * Message
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Message {
    private String text;
    private String user;

    public Message(String text, String user) {
        this.text = text;
        this.user = user;
    }

    public Message() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
