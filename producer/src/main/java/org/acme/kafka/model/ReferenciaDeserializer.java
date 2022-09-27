package org.acme.kafka.model;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class ReferenciaDeserializer extends ObjectMapperDeserializer<Referencia> {
    public ReferenciaDeserializer() {
        super(Referencia.class);
    }
}
