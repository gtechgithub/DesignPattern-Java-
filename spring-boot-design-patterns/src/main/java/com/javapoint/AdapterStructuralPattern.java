package com.javapoint;

/******************************
 * 
 * 
 * 
 *                                   -----------------------
 *                                      (Interface) 
 *                                      MediaPlayer 
 *                                      + play()                                    
 *                                   -----------------------
 *                                    ^                 ^
 *                                    |                 |
 *   --------------    Contains       |                 |
 *    (Interface)   <----------|      |                 |
 *   AdvancePlayer             |      |                 |
 *    + play()           -------------------       ---------------
 *   --------------         MediaAdapter            AudioPlayer
 *   ^          ^        -------------------        ---------------
 *   |          |            + play()
 *   |          |            + play(PlayerType)
 *   |          |
 *   |          | 
 *   |          |
 * ---------  --------   
 *   VLC      MP4
 * ---------  --------
 *
 */

enum PlayerType { AUDIOPLAYER, MP4PLAYER, VLCPLAYER, OTHERPLAYER};

interface MediaPlayer{
	public String play();
}

class AudioPlayer implements MediaPlayer{
	
	String message;
	
	AudioPlayer(){
		message = "playing in audioplayer";
	}
	
	@Override
	public String play() {
		return message;
	}
	
}

interface AdvanceMediaPlayer {
	public String play();
}

class MP4Player implements AdvanceMediaPlayer {
	String message;
	
	MP4Player(){
		message = "playing in mp4 player ";
	}
	
	@Override
	public String play() {
		return message;
	}
	
}

class VLCPlayer implements AdvanceMediaPlayer {
	String message;
	
	VLCPlayer(){
		message = "playing in vlcplayer";
	}
	
	@Override
	public String play() {
		return message;
	}
	
}

class MediaAdapter implements MediaPlayer{

	private AdvanceMediaPlayer admediaPlayer;
	
	
	public String choosePlayer(PlayerType playerType) throws Exception {
		if (playerType == PlayerType.AUDIOPLAYER) {
			MediaPlayer audioplayer = new AudioPlayer();
			return audioplayer.play();
		}
		else if (playerType == PlayerType.MP4PLAYER) {
			admediaPlayer = new MP4Player();
			return admediaPlayer.play();
		}
		else if (playerType == PlayerType.VLCPLAYER) {
			admediaPlayer = new VLCPlayer();
			return admediaPlayer.play();
		}
		else {
			play();
			throw new Exception("exception no proper player to play for " + PlayerType.OTHERPLAYER);
		}
	}
	
	//this should be never called
	@Override
	public String play() {
		return "";
	}

}

public class AdapterStructuralPattern {

	public static void main(String args[]) {
		
		MediaAdapter adapter  = new MediaAdapter();
		
		try {
			System.out.println(adapter.choosePlayer(PlayerType.AUDIOPLAYER));
			
			System.out.println(adapter.choosePlayer(PlayerType.MP4PLAYER));
			
			System.out.println(adapter.choosePlayer(PlayerType.VLCPLAYER));
			
			System.out.println(adapter.choosePlayer(PlayerType.OTHERPLAYER));
			
		}
		catch(Exception e) {
			System.out.println("Exception message: " + e.getMessage());
		}
		
		
	}
}


/******************************** OUTPUT 
 
 
 playing in audioplayer
 playing in mp4 player 
 playing in vlcplayer
 Exception message: exception no proper player to play for OTHERPLAYER
 
  
 
 */



