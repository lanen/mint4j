package evanq.game.cardgame.infrastructure.mint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * 用于描述具有CommandListener，处理哪一个IPacket
 * 
 * @author Evan cppmain@gmail.com
 *
 */
@Target(ElementType.TYPE)

@Retention(RetentionPolicy.RUNTIME)
public @interface CommandExecutor {
	
	 Class<?> value();
}
