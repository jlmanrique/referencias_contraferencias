package org.acme.kafka.processor;

import java.util.concurrent.CompletionStage;
import java.util.Random;

import javax.enterprise.context.ApplicationScoped;

import org.acme.kafka.model.Referencia;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.smallrye.reactive.messaging.annotations.Blocking;

/**
 * A bean consuming data from the "quote-requests" Kafka topic (mapped to "requests" channel) and giving out a random quote.
 * The result is pushed to the "quotes" Kafka topic.
 */
@ApplicationScoped
public class QuotesProcessor {

    @Incoming("requests")
    @Outgoing("referencias")
    @Blocking
    public CompletionStage<Void> process(Message<Referencia> referenciaMessage) throws InterruptedException {
        // simulate some hard working task
        Thread.sleep(200);
        return referenciaMessage.ack();
    }
}
