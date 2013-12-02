package evanq.game.ws.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import evanq.game.helper.StopWatch;
import evanq.game.ws.IRealmAgent;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class ReamlAgentInstance implements IRealmAgent {

	
	private static class Singleton {
		public static ReamlAgentInstance INSTANCE = new ReamlAgentInstance();
	}

	public static ReamlAgentInstance getInstance() {
		return Singleton.INSTANCE;
	}

	private ReamlAgentInstance() {
	}
	
	private Logger logger = LoggerFactory.getLogger(ReamlAgentInstance.class);
	
	@Override
	public void start() {
		
		logger.info("Start Realm Agent.");
		StopWatch stopWatchForStart = new StopWatch("StartingRealmAgent");
		
		
		stopWatchForStart.stop();
		logger.info("{}",stopWatchForStart);
	}

	@Override
	public void stop() {
		
	}

	@Override
	public void list() {
		
	}

}
