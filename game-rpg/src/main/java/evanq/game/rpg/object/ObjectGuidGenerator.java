package evanq.game.rpg.object;

import java.util.concurrent.atomic.AtomicInteger;

import evanq.game.helper.Generator;

/**
 * 
 * 对象全局唯一ID 生成器
 * 
 * @author Evan
 *
 */
public class ObjectGuidGenerator implements Generator<ObjectGuid> {

	protected int entityType;
	
	protected AtomicInteger atomicCounter = new AtomicInteger(1);
	
	public ObjectGuidGenerator(int entityType){
		this.entityType = entityType;
	}
	
	public ObjectGuid generate() {
		ObjectGuid guid = new ObjectGuid(this.entityType,atomicCounter.getAndIncrement());
		return guid;
	}

	public boolean recycle(ObjectGuid product) {
		return false;
	}

}
