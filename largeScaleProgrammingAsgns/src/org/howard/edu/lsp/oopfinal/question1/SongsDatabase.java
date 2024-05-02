package org.howard.edu.lsp.oopfinal.question1;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class SongsDatabase {
    private Map<String, Set<String>> map = new HashMap<String, Set<String>>();

    /* Add a song title to a genre */
    public void addSong(String genre, String songTitle) {
        // Check if the genre already exists in the map
        if (!map.containsKey(genre)) {
            map.put(genre, new HashSet<String>());
        }
        // Add the song title to the corresponding genre
        map.get(genre).add(songTitle);
    }

    /* Return genre, i.e., jazz, given a song title */
    public String getGenreOfSong(String songTitle) {
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            if (entry.getValue().contains(songTitle)) {
                return entry.getKey();
            }
        }
        return null; // Return null if song title is not found
    }

    /* Return the Set that contains all songs for a genre */
    public Set<String> getSongs(String genre) {
        return map.getOrDefault(genre, new HashSet<String>());
    }

    // JUnit test cases

    @Test
    public void testAddSong() {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Rap", "Savage");
        assertTrue(db.getSongs("Rap").contains("Savage"));
    }

    @Test
    public void testGetGenreOfSong() {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Rap", "Savage");
        assertEquals("Rap", db.getGenreOfSong("Savage"));
    }

    @Test
    public void testGetSongs() {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Rap", "Savage");
        db.addSong("Rap", "Gin and Juice");
        Set<String> rapSongs = db.getSongs("Rap");
        assertEquals(2, rapSongs.size());
        assertTrue(rapSongs.contains("Savage"));
        assertTrue(rapSongs.contains("Gin and Juice"));
    }
}