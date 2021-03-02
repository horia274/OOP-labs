package fourth;

public class BadAlbum extends Album {
    public void addSong(Song song) {
        int mirror = 0, id = song.id;
        if (song.name.length() != 3) {
            return;
        }
        while(id > 0) {
            mirror = mirror * 10 + id % 10;
            id /= 10;
        }
        if (song.id != mirror) {
            return;
        }
        playlist.add(song);
    }
}
