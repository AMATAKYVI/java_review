package d4.NestedClasses.AlbumChallenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {

    private String albumName;
    private String singerName;

    private SongList songList = new SongList();

    public Album(String singerName, String albumName) {
        this.albumName = albumName;
        this.singerName = singerName;
    }

    record Song(String title, double duration) {

    }

    private class SongList {

        private List<Song> songList = new ArrayList<>();

        public SongList() {
        }

    }

    public Song findSong(String title) {
        for (Song song : songList.songList) {
            if (song.title.equals(title)) {
                return song;
            }
        }
        return null;
    }

    public void addToPlayList(String title, LinkedList<Song> playList) {
        Song song = findSong(title);
        if (song != null) {
            playList.add(song);
        }
    }

    public void addSong(String title, double duration) {
        songList.songList.add(new Song(title, duration));
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
