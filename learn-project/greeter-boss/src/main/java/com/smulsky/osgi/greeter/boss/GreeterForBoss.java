package com.smulsky.osgi.greeter.boss;

import com.smulsky.osgi.greeter.api.Greeter;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.osgi.service.log.LogService;

@Service
@Component(immediate = true)
public class GreeterForBoss implements Greeter {

    @Reference
    LogService logService;

    @Override
    public String hello() {
        logService.log(LogService.LOG_WARNING, "I'm a BOSS LOG!");
        return "Hello Sir! How are you? Let me kiss you ass, please!";
    }
}
