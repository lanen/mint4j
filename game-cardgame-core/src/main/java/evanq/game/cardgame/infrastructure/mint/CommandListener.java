package evanq.game.cardgame.infrastructure.mint;

public interface CommandListener<T> {
	void action(T t);
}
