package pets.put;

import com.intuit.karate.junit5.Karate;

public class PetPutRunner {
    @Karate.Test
    Karate PetPutRunner(){
        return Karate.run().relativeTo(getClass());
    }
}
