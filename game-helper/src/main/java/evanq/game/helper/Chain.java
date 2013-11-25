package evanq.game.helper;

/**
 * 
 * 责任链模式
 * 
 * @author Evan
 *
 */
public abstract class Chain {

	public static Chain  newInstance(){
		return new SimpleChain();
	}
	
	private static class SimpleChain extends Chain{

		@Override
		public Chain addLast(Chain chain) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Chain addFist(Chain chain) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Chain removeLast() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Chain removeFirst() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	public abstract Chain addLast(Chain chain);
	public abstract Chain addFist(Chain chain);
	
	public abstract Chain removeLast();
	public abstract Chain removeFirst();
	
	

}
