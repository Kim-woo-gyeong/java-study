package Chapter3;

public class SongApp {

	public static void main(String[] args) {
		Song song = new Song();
		song.setArtist("아이유");
		song.setAlbum("Real");
		song.setComposer("윤민수");
		song.setTitle("좋은날");
		song.setTrack(3);
		song.setYear(2010);
		
		song.show();
		globalTest();
		Global.globalFunc();
		
		Song song2 = new Song("Blueming", "아이유", null, "이지금", 0, 2019);
		song2.show();
		
		Song song3 = new Song("먹구름", "윤하");
		song3.show();
	}

	public static void globalTest()
	{
		System.out.println(Global.globalVar);
	}
}
