package framework.integration;

import java.util.Objects;

public class EmailSenderSingleton {
    private static volatile EmailSender instance;
    private EmailSenderSingleton() {
    }
    public static EmailSender getInstance() {
        if (Objects.isNull(instance)) {
            synchronized (EmailSenderSingleton.class) {
                if (Objects.isNull(instance)) {
                    instance = new EmailSender();
                }
            }
        }
        return instance;
    }
}
