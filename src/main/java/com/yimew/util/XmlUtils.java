package com.yimew.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.*;

/**
 * * @author 作者 E-mail: * @date 创建时间：2017年11月21日 下午4:53:46 * @version 1.0
 * * @parameter * @since * @return
 */
public class XmlUtils {
	
	public static void mapToXMLTest2(Map map, StringBuffer sb) {
		Set set = map.keySet();
		for (Iterator it = set.iterator(); it.hasNext();) {
			String key = (String) it.next();
			Object value = map.get(key);
			if (null == value)
				value = "";
			if (value.getClass().getName().equals("java.util.ArrayList")) {
				ArrayList list = (ArrayList) map.get(key);
				sb.append("<" + key + ">");
				for (int i = 0; i < list.size(); i++) {
					HashMap hm = (HashMap) list.get(i);
					mapToXMLTest2(hm, sb);
				}
				sb.append("</" + key + ">");

			} else {
				if (value instanceof HashMap) {
					sb.append("<" + key + ">");
					mapToXMLTest2((HashMap) value, sb);
					sb.append("</" + key + ">");
				} else {
					sb.append("<" + key + ">" + value + "</" + key + ">");
				}

			}

		}
	}

	 public static Map<String, Object> xml2map(String xml) {
	        Document doc = null;
	        try {
	            doc = DocumentHelper.parseText(xml);
	        } catch (DocumentException e) {
	            e.printStackTrace();
	        }
	        Map<String, Object> map = new HashMap<String, Object>();
	        if (doc == null)
	            return map;
	        Element rootElement = doc.getRootElement();
	        element2map(rootElement,map);
	        return map;
	    }
	    
	 /**
	     * 
	     * @param elmt 当前元素
	     * @param map 主键为当前元素的节点名,值为当前元素的所有直接子元素
	     */
	    public static void element2map(Element elmt, Map<String, Object> map) {
	        if (null == elmt) {
	            return;
	        }
	        String name = elmt.getName();
	        if (elmt.isTextOnly()) {
	            map.put(name, elmt.getText());
	        } else {
	            Map<String, Object> mapSub = new HashMap<String, Object>();
	            List<Element> elements = (List<Element>) elmt.elements();
	            for (Element elmtSub : elements) {
	                element2map(elmtSub, mapSub);
	            }
	            Object first = map.get(name);
	            if (null == first) {
	                map.put(name, mapSub);
	            } else {
	                if (first instanceof List<?>) {
	                    ((List) first).add(mapSub);
	                } else {
	                    List<Object> listSub = new ArrayList<Object>();
	                    listSub.add(first);
	                    listSub.add(mapSub);
	                    map.put(name, listSub);
	                }
	            }
	        }
	    }

}
