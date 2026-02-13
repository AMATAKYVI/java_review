package d4.NestedClasses.AlbumChallenge;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        Album album = new Album("Stormbringer", "Deep Purple");

        album.addSong("Stormbringer", 3.3);
        album.addSong("Love don't mean a thing", 3.3);
        album.addSong("Holy man", 3.3);
        album.addSong("Hold on", 3.3);
        album.addSong("Lady double dealer", 3.3);
        album.addSong("You can't do it right", 3.3);
        album.addSong("High ball shooter", 3.3);
        album.addSong("The gypsy", 3.3);
        album.addSong("Soldier of fortune", 3.3);

        LinkedList<Album.Song> playList = new LinkedList<>();
        album.addToPlayList("High ball shooter", playList);
        album.addToPlayList("The gypsy", playList);
        album.addToPlayList("Soldier of fortune", playList);
        System.out.println(playList);

    }
}
