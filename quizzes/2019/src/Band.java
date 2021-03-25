import java.util.ArrayList;
import java.util.List;

public class Band extends Act {

    private final List<Artist> artists = new ArrayList<>();

    public Band(String name, String country) {
        super(name, country);
    }

    public void addArtist(Artist artist) {
        this.artists.add(artist);
    }

    public List<Artist> getArtists() {
        return this.artists;
    }

    public boolean containsArtist(Artist artist) {
        return this.artists.contains(artist);
    }
}
