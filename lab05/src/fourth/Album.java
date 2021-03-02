package fourth;

import java.util.ArrayList;

public abstract class Album {
    ArrayList<Song> playlist = new ArrayList<>();

    public abstract void addSong(Song song);

    public void removeSong(int index) {
        playlist.remove(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Song song : playlist) {
            sb.append(song.toString());
            sb.append(" ");
        }
        return sb.toString();
    }
}
