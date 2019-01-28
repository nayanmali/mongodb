package mangodb;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class Main {
	public static void main(String[] args) {
		try {
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			DB db = mongoClient.getDB("mydb");

			System.out.println("========================== DATABASES ========================");

			List<String> dbNames = mongoClient.getDatabaseNames();
			for (String string : dbNames) {
				System.out.println(string);
			}

			System.out.println("========================== COLLECTIONS ========================");

			Set<String> tables = db.getCollectionNames();

			for (String coll : tables) {
				System.out.println(coll);
			}

			DBCollection dbCollection = db.getCollection("post");

			DBCursor dbCursor = dbCollection.find();
			System.out.println(dbCursor.getQuery());

			while (dbCursor.hasNext()) {
				System.out.println(dbCursor.next());
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
