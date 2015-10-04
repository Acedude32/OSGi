package com.smulsky.osgi.greeter.looser;

import com.smulsky.osgi.greeter.api.Greeter;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

@Service
@Component(immediate = true)
public class GreeterForLooser implements Greeter {
    @Override
    public String hello() {
        return "Hey, LOOSER! HA-HA";
    }
}
