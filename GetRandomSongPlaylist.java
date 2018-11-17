//package testing;

import java.util.Random;

class EmptyPlaylistException extends Exception {

    /**
      * SerialVersionUID
      *          
      */
    private static final long serialVersionUID = 1L;

    private static final String EMPTY_PLAYLIST_ERROR_MESSAGE = "PlayList is empty. No more songs to play!!!";

    public EmptyPlaylistException() {
        super(EMPTY_PLAYLIST_ERROR_MESSAGE);
    }
}

interface Player {

    public String play() throws EmptyPlaylistException;

    public String next() throws EmptyPlaylistException;

    public String previous() throws EmptyPlaylistException;
}

class RandomAudioSongPlayer  implements Player {

    /**
 *      * For testing purpose i have stored the 100 song names as alphabets.
 *           */
    private String []playList = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                                 "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                                 "U", "V", "W", "X", "Y", "Z", "AA", "AB", "AC", "AD",
                                 "AE", "AF", "AG", "AH", "AI", "AJ", "AK", "AL", "AM", "AN",
                                 "AO", "AP", "AQ", "AR", "AS", "AT", "AU", "AV", "AW", "AX",
                                 "AY", "AZ", "BA", "BB", "BC", "BD", "BE", "BF", "BG", "BH",
                                 "BI", "BJ", "BK", "BL", "BM", "BN", "BO", "BP", "BQ", "BR",
                                 "BS", "BT", "BU", "BV", "BW", "BX", "BY", "BZ", "CA", "CB",
                                 "CD", "CE", "CF", "CG", "CH", "CI", "CJ", "CK", "CL", "CM",
                                 "CN", "CO", "CP", "CQ", "CR", "CS", "CT", "CU", "CV", "CW"};
    
    private int size = playList.length;
    private int currentIndex = -1;

    @Override
    public String play() throws EmptyPlaylistException {
        if (size < 1) {
            throw new EmptyPlaylistException();
        }
        int random = new Random().nextInt(size);
        String currentSong = playList[random];
        swapToSize(random);
        currentIndex = random;
        return currentSong;
    }

    @Override
    public String next() throws EmptyPlaylistException {
        if (size < 1) {
            throw new EmptyPlaylistException();
        }
        int next = 0;
        if (currentIndex + 1 < size && size != 1) {
            next = ++ currentIndex;
        } else if (currentIndex + 1 == size) {
            next = currentIndex;
        } else {
            currentIndex = next = 0;
        }
        String currentSong = playList[next];
        swapToSize(next);
        return currentSong;
    }

    @Override
    public String previous() throws EmptyPlaylistException {
        if (size < 1) {
            throw new EmptyPlaylistException();
        }
        int previous = 0;
        if (currentIndex == -1 || currentIndex - 1 < 0) {
            previous = currentIndex = size - 1;
        } else {
            previous = --currentIndex;
        }
        String currentSong = playList[previous];
        swapToSize(previous);
        return currentSong;
    }

    /**
      * Just swapping the current index value to size of the array
      * @param source
      */
    private void swapToSize(int source) {
        if (source != --size) {
            String temp = playList[source];
            playList[source] = playList[size];
            playList[size] = temp;                
        }
    }
}

public class GetRandomSongPlayList {

    public static void main(String[] args) {

        Player player = new RandomAudioSongPlayer();
        try {
            System.out.println(player.play());
            System.out.println(player.play());
            System.out.println(player.play());
            System.out.println(player.next());
            System.out.println(player.next());
            System.out.println(player.next());
            System.out.println(player.previous());
        } catch (EmptyPlaylistException e) {
            System.out.println("Play list has been stopped: " + e.getMessage());
        }
    }
}

