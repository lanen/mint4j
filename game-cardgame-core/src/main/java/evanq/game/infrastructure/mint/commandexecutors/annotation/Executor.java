package evanq.game.infrastructure.mint.commandexecutors.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import evanq.game.net.IPacket;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Executor {
	
	Class<? extends IPacket> value() default DummyPacket.class;
}
