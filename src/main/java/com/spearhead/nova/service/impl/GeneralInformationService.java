package com.spearhead.nova.service.impl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

@Service
public class GeneralInformationService  {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public static final Logger logger = LoggerFactory.getLogger(GeneralInformationService.class);

	public String genSPAction(String payload,Long userId) {
		
		try {
			JSONObject payloadObj = new JSONObject(payload);

			String procedure = "", statement = "";
			int noOfParams = 0;
			JSONArray params;		

			procedure = payloadObj.getString("action");
			statement = procedure.concat(" ");
			
			params = payloadObj.getJSONArray("param");
			noOfParams = params.length();		

			String final_statement  = "";
			
			if (noOfParams > 0) {
				for(int i=0; i < noOfParams; i++) {
					JSONObject parameter = params.getJSONObject(i);				
					//String param = parameter.getString((String) parameter.keys().next());

					String param = parameter.getString("value");
					statement = statement.concat("'" + param + "', ");
				}

				statement = statement.substring(0, statement.length() - 2);
				
				final_statement = statement.concat(",'" + userId + "'");
			}else {
				final_statement = statement.concat("'" + userId + "'");
			}
			
			
		
			return jdbcTemplate.query(final_statement,new ResultSetExtractor<String>(){  

		public String extractData(ResultSet rs) throws SQLException,  DataAccessException {  

					ResultSetMetaData metadata = rs.getMetaData();
					int columnCount = metadata.getColumnCount();
					JSONArray resJsonArray = new JSONArray();

					ArrayList<String> columns = new ArrayList<String>();
					for (int i = 1; i <= columnCount; i++) {
						String columnName = metadata.getColumnName(i);
						columns.add(columnName);
					}

					while (rs.next()) {
						JSONObject resJsonObject = new JSONObject();
						for (String columnName : columns) {
							String value = rs.getString(columnName);

							try {
								if (value != null)
									resJsonObject.put(columnName, value);
								else 
									resJsonObject.put(columnName, "null");

							} catch (JSONException e) {
								e.printStackTrace();
							}
						}
						resJsonArray.put(resJsonObject);
					}
					return resJsonArray.toString();
				} 
			});  

		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
