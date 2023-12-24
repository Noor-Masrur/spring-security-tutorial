package com.tigerit.client.event;

import com.tigerit.client.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Service;

@Getter
@Setter

public class RegistrationCompleteEvent extends ApplicationEvent {

    private User user;
    private String applicationUrl;
    public RegistrationCompleteEvent(User user, String applicationUrl ) {
        super(user);
        this.applicationUrl = applicationUrl;
        this.user = user;
    }
}
