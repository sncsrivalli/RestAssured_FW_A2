package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClasses.PetstoreStoreLibrary;

public class DeserializationTest {

	@Test
	public void deserialization() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		PetstoreStoreLibrary obj = mapper.readValue(new File("./src/test/resources/petstoreStore.json"),
																			PetstoreStoreLibrary.class);
		
		System.out.println(obj.getId());
		System.out.println(obj.getPetId());
		System.out.println(obj.getQuantity());
	}
}
