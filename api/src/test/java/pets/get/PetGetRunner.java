package pets.get;

import com.intuit.karate.junit5.Karate;

public class PetGetRunner {
    @Karate.Test
    Karate PetGetRunner(){
        return Karate.run().relativeTo(getClass());
    }
}
