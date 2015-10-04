package com.smulsky.osgi.gogo;

import com.smulsky.osgi.greeter.api.Greeter;
import org.apache.felix.scr.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Component
@Service(Object.class)
@Properties({
        @Property(name = "osgi.command.scope", value = "learning"),
        @Property(name = "osgi.command.function", value = "greet")
})
public class GreeterCommand {

    @Reference(cardinality = ReferenceCardinality.MANDATORY_MULTIPLE,
                policy = ReferencePolicy.DYNAMIC,
                referenceInterface = Greeter.class,
                bind = "setGreeter",
                unbind = "unsetGreeter",
                target = "(type=interesting.person)")
    private List<Greeter> greeters;

    public void greet(){
        greeters.forEach(g -> System.out.println(g.hello()));
    }

    protected void setGreeter(Greeter greeter) {
        if (greeters == null) {
            greeters = new ArrayList<>();
        }
        greeters.add(greeter);
    }

    protected void unsetGreeter(Greeter greeter) {
        greeters.remove(greeter);
    }
}
