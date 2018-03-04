package com.abdkh93.fsecure123;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

// In-memory data store for retaining all messages in the application
// First message created as soon as application starts for testing purposes

public final class MessageStore {

    private static final Map<Long, Message> MESSAGES = new HashMap<>();

    static {
        try {
            final Message message = createMessage("Yo!", "Howdy there partner...", "Abdullah", new URL("http://example.com"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static Message createMessage(final String title, final String content, final String sender,
                                        final URL url) {
        final Message message = new Message(MESSAGES.size() + 1L, title, content, sender, url);
        MESSAGES.put(MESSAGES.size() + 1L, message);
        return message;
    }


    public static List<Message> getMessages() {
        return new ArrayList<>(MESSAGES.values());
    }

    private MessageStore() {
    }
}

