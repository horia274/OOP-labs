package fourth;

public class DangerousAlbum extends Album {
    public void addSong(Song song) {
        int id = song.id;
        if (id < 2) {
            return;
        }
        for (int i = 2; i < id; i++) {
            if (id % i == 0) {
                return;
            }
        }
        playlist.add(song);
    }
}
