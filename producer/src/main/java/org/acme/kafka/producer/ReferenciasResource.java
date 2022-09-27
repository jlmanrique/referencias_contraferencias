package org.acme.kafka.producer;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.kafka.model.Referencia;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import io.smallrye.mutiny.Multi;

@Path("/referencias")
public class ReferenciasResource {

    @Channel("referencia-request")
    Emitter<Referencia> quoteRequestEmitter;

    /**
     * Endpoint to generate a new quote request id and send it to "quote-requests" Kafka topic using the emitter.
     */
    @POST
    @Path("/request")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String createRequest(Referencia referencia) {
        UUID uuid = UUID.randomUUID();
        quoteRequestEmitter.send(referencia);
        return uuid.toString();
    }

    @Channel("referencias")
    Multi<Void> quotes;

    /**
     * Endpoint retrieving the "quotes" Kafka topic and sending the items to a server sent event.
     */
    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS) // denotes that server side events (SSE) will be produced
    public Multi<Void> stream() {
        return quotes.log();
    }
}
