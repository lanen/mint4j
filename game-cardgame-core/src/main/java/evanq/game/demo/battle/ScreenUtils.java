package evanq.game.demo.battle;

public class ScreenUtils {
	
	
	/**
	 * 屏幕等比拉升
	 */
	public static final float WINDOW_SCALA_X =  0.5f;
	public static final float WINDOW_SCALA_Y =  0.5f;

	/**
	 * 屏幕宽度
	 */
	public static final int WINDOW_WIDTH =  640;
	
	/**
	 * 屏幕高度
	 */
	public static final int WINDOW_HEIGHT = 960;
	
	public static int width(){
		return (int) (WINDOW_WIDTH * WINDOW_SCALA_X);
	}
	
	public static int height(){
		return (int)(WINDOW_HEIGHT * WINDOW_SCALA_Y);
	}
	
	/** set resolution here */
//	int i = 1; 
//	boolean isLandscape = true;
//
//	int[][] res = new int[8][];
//	res[0] = new int[] { 320, 240 };
//	res[1] = new int[] { 480, 320 };
//	res[2] = new int[] { 720, 480 };
//	res[3] = new int[] { 800, 480 };
//	res[4] = new int[] { 854, 480 };
//	res[5] = new int[] { 1024, 600 };
//	res[6] = new int[] { 1280, 768 };
//	res[7] = new int[] { 1280, 800 };
//	cfg.width = res[i][isLandscape ? 0 : 1];
//	cfg.height = res[i][isLandscape ? 1 : 0];
}
