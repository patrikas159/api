import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ApiTest {
    Movie local;
    @Before
    public void setup(){
         local = new Movie("Guardians of the Galaxy Vol. 2", 2017, "James Gunn", 7.6);
    }

    @Test
    public void ApiTest(){
        try {
            JSONObject json = api.readJsonFromUrl("https://www.omdbapi.com/?i=tt3896198&apikey=fb880674");
            Movie remote = new Movie(json.getString("Title"), json.getInt("Year"),
                    json.getString("Director"), json.getDouble("imdbRating"));
            assertEquals(local, remote);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void assertEquals(Movie local, Movie remote){
        Assert.assertEquals(local.getTitle(), remote.getTitle());
        Assert.assertEquals(local.getDirector(),remote.getDirector());
        Assert.assertEquals(local.getYear(), remote.getYear());
        Assert.assertEquals(local.getImdbRating(),remote.getImdbRating(), 0);


    }

}
