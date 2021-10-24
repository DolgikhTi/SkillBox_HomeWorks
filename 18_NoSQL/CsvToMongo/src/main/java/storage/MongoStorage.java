package storage;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import properties.Props;

public class MongoStorage {

    private static final Props PROPS = Props.INSTANCE;

    MongoClient mongoClient;

    public MongoStorage() {
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(PROPS.getMongoURI()))
                .retryWrites(true)
                .build();
        mongoClient = MongoClients.create(settings);
    }

    public MongoDatabase getDatabase(String dbName) {
        return mongoClient.getDatabase(dbName);
    }

    @Override
    public void close() {
        mongoClient.close();
    }
}
