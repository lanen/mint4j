package evanq.game.cardgame.domain.model.world.support;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import evanq.game.infrastructure.es.services.IPostContrust;
import evanq.game.infrastructure.es.services.ServiceManager;

/**
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class ServiceManagerImpl implements ServiceManager {
	
	private  Map<Class<?>, Object> controllers;
	private ArrayList<Object> controllersList;
	public ServiceManagerImpl() {
		controllers = new HashMap<Class<?>, Object>();
		controllersList = new ArrayList<Object>();
	}
	
	@Override
	public <E> void add(Class<E> clazz,E instance) {
		if(null == clazz){
			throw new NullPointerException("clazz");
		}
		if(null == instance){
			throw new NullPointerException("instance");
		}
		controllers.put(clazz, instance);
		controllersList.add(instance);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <E> E get(Class<E> clazz) {
		return (E)controllers.get(clazz);
	}

	@Override
	public <E> void removeController(Class<E> clazz) {
		Object remove = controllers.remove(clazz);
		if(null != remove){
			controllersList.remove(remove);
		}

	}

	@Override
	public <E> void removeController(E instance) {
		if(null == instance)return;
		Object remove = controllers.remove(instance.getClass());
		if(null != remove){
			controllersList.remove(remove);
		}
	}

	@Override
	public void atfterStart() {
		
		for (Object obj : controllersList) {
			if( obj instanceof IPostContrust){
				((IPostContrust)obj).atfterStart();
			}
		}
	}
	
}
