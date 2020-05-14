package io.helidon.examples.sockshop.shipping.mongo;

import javax.annotation.Priority;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import io.helidon.examples.sockshop.shipping.Shipment;
import io.helidon.examples.sockshop.shipping.TestShipmentRepository;

import com.mongodb.client.MongoCollection;
import org.bson.BsonDocument;

import static javax.interceptor.Interceptor.Priority.APPLICATION;

@Alternative
@Priority(APPLICATION + 5)
public class TestMongoShipmentRepository extends MongoShipmentRepository implements TestShipmentRepository {
    @Inject
    TestMongoShipmentRepository(MongoCollection<Shipment> shipments) {
        super(shipments);
    }

    @Override
    public void clear() {
        shipments.deleteMany(new BsonDocument());
    }
}
