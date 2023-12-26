package com.tigerit.client.event.listener;

import com.tigerit.client.entity.User;
import com.tigerit.client.event.RegistrationCompleteEvent;
import com.tigerit.client.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;

import java.util.UUID;
@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserService userService;
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //Create verification Token for USer with Link
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token,user);
        //send email
        String url=event.getApplicationUrl()+ "verifyRegistration?token="+token;
        log.info("Click the link to verify your account: {}",url);

    }
}
