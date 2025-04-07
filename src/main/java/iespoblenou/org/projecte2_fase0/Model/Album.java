package iespoblenou.org.projecte2_fase0.Model;

public class Album {

    private int AlbumId;
    private String Title;
    private int ArtistId;

    public Album(int albumId, String title, int artistId) {
        AlbumId = albumId;
        Title = title;
        ArtistId = artistId;
    }

    public int getAlbumId() {
        return AlbumId;
    }

    public void setAlbumId(int albumId) {
        AlbumId = albumId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getArtistId() {
        return ArtistId;
    }

    public void setArtistId(int artistId) {
        ArtistId = artistId;
    }

}
