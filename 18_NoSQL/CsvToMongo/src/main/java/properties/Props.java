package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public enum Props {

    INSTANCE;

    private static final String PROPS_PATH = "src/main/resources/app.properties";

    private final String username;
    private final String password;
    private final String host;
    private final String port;
    private final String params;

    private final String dbName;
    private final String collectionName;

    private final String csvFile;

    Props() {
        Properties props = new Properties();

        try (InputStream in = new FileInputStream(PROPS_PATH)) {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.username = props.getProperty("mongo.username");
        this.password = props.getProperty("mongo.password");
        this.host = props.getProperty("mongo.host");
        this.port = props.getProperty("mongo.port");
        this.params = props.getProperty("mongo.paramsAfterSlash");

        this.dbName = props.getProperty("mongo.database");
        this.collectionName = props.getProperty("mongo.collection");

        this.csvFile = props.getProperty("csv.file");
    }

    public String getMongoURI() {

        String credentials = (username.isBlank() || password.isBlank()) ?
                "" : String.format("%s:%s@", this.username, this.password);

        String portValue = this.port.isBlank() ?
                "" : String.format(":%s", this.port);

        String paramsValue = this.params.isBlank() ?
                "" : String.format("/%s", this.params);

        return String.format("mongodb://%s%s%s%s", credentials, host, portValue, paramsValue)
                .replaceAll("\\s+", "");
    }

    public String getDbName() {
        return dbName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public String getCsvFile() {
        return csvFile;
    }
}
