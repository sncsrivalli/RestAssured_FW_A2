package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClasses.PetstoreStoreLibrary;

public class SerializationTest {

	@Test
	public void serialization() throws JsonGenerationException, JsonMappingException, IOException {
		PetstoreStoreLibrary obj = new PetstoreStoreLibrary(1, 101, 1, "23/11/2024", "placed", false);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("./src/test/resources/petstoreStore.json"), obj);
	}
}
