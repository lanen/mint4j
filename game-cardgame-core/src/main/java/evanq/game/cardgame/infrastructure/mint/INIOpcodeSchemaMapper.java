package evanq.game.cardgame.infrastructure.mint;

import java.util.AbstractMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalINIConfiguration;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class INIOpcodeSchemaMapper extends OpcodeSchemaMapper {

	
	
	public INIOpcodeSchemaMapper(String file) {
		super(file);
	}
	public List<Map.Entry<Integer, String>> listEntry(){
		
		LinkedList<Map.Entry<Integer, String>> list = new LinkedList<Map.Entry<Integer, String>>();
		
		try {
			HierarchicalINIConfiguration ini = new HierarchicalINIConfiguration( this.file );
			Set<String> sections = ini.getSections();
		
			
			for (String string : sections) {
				
				for (Iterator<String> keys = ini.getKeys(string); keys.hasNext();) {
					String key = (String) keys.next();

					int lastIndexOf = key.lastIndexOf(".")+1;
					
					String i = key.substring(lastIndexOf);
					
					Integer k = Integer.valueOf(i);
					String v = ini.getString(key);
					Map.Entry<Integer, String> l = new AbstractMap.SimpleImmutableEntry<Integer, String>(k,v);

					list.add(l);
				}
			}
			
			
		} catch (ConfigurationException e) {

			e.printStackTrace();
		}

		return list;
	}
	
	
	@Override
	public boolean saveEntry(List<Entry<Integer, String>> entrys) {
		
		throw new UnsupportedOperationException();
	}
	
}
