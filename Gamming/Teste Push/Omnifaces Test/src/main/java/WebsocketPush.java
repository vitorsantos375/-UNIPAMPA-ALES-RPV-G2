
import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.cdi.Push;
import org.omnifaces.cdi.PushContext;

/**
 *
 * @author gilis
 */
@Named(value = "push")
@ApplicationScoped
public class WebsocketPush implements Serializable {

    @Inject
    @Push
    private PushContext someChannel;

    public void sendMessage() {
        someChannel.send("sajkhias");
    }
}
