package evanq.game.event.selector;

/**
 * 
 * 作为一个业务对象的包装器
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class MintSelector<T> {

	private T origin;
	
	private String name;
	
	public MintSelector (String name,T w){
		this.name = name;
		this.origin = w;
	}
	
	public String getName(){
		return this.name;
	}
	
	public T getOrigin(){
		return this.origin;
	}
}
