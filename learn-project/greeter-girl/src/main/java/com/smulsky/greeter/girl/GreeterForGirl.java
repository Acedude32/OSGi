package com.smulsky.greeter.girl;

import com.smulsky.osgi.greeter.api.Greeter;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;

@Service
@Component(immediate = true, metatype = true)
@Property(name = "type", value = "interesting.person")
public class GreeterForGirl implements Greeter {

    @Override
    public String hello() {
        return "How you doing? (c) Joey";
    }
}
