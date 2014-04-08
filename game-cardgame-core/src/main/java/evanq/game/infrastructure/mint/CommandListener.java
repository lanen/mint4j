package evanq.game.infrastructure.mint;

@Deprecated
public interface CommandListener<T> {
	void action(T t);
}
