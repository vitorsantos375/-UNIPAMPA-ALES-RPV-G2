/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gilis
 */
import java.util.UUID;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.sse.OutboundSseEvent;
import javax.ws.rs.sse.Sse;
import javax.ws.rs.sse.SseEventSink;
import javax.ws.rs.sse.SseBroadcaster;

@Singleton
@Path("broadcast")
public class BroadcasterResource {

    private final Sse sse;
    private final SseBroadcaster channel;

    public BroadcasterResource(@Context final Sse sse) {
        this.sse = sse;
        this.channel = sse.newBroadcaster();
    }

    @Path("subscribe")
    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public void subscribe(@Context SseEventSink eventSink, @Context Sse util) {
        eventSink.send(util.newEvent("Subscription accepted. ID - " + UUID.randomUUID().toString()));
        channel.register(eventSink);
    }

    public void update() {
        OutboundSseEvent sseEvent = null;
        channel.broadcast(sseEvent);
    }
}
