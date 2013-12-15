package evanq.game.errno;

import java.util.concurrent.ConcurrentMap;

import evanq.game.helper.New;
import evanq.game.utils.UniqueUtils;

/**
 * 
 * 抽象一个信号
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public final class Signal extends Error{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7463519983411148506L;
	
    private static final ConcurrentMap<String, Boolean> map = New.newConcurrentHashMap();

	private String name;
	
	private Signal(String _name){
		
		UniqueUtils.assertUnique(map, _name);
		
		this.name = _name;
	}
	
	public static Signal valueOf(String name){
		return new Signal(name);
	}
	
	/**
     * Check if the given {@link Signal} is the same as this instance. If not an {@link IllegalStateException} will
     * be thrown.
     */
    public void expect(Signal signal) {
        if (this != signal) {
            throw new IllegalStateException("unexpected signal: " + signal);
        }
    }

    @Override
    public Throwable initCause(Throwable cause) {
        return this;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
