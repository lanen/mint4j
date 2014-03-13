package evanq.game.cardgame.infrastructure.mint;

public class Opcode {

	class OpcodeRule{
		
	}
	
	public static int getCode(int type, int index){
		return (1<<type) * 10000 + index;
	}
	
	public static void main(String[] args) {
		System.out.println(getCode(1, 1));
		System.out.println(getCode(2, 1));
		System.out.println(getCode(3, 1));
		System.out.println(getCode(4, 1));
	}
}
