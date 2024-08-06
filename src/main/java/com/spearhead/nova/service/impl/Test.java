package com.spearhead.nova.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

@Service
public class Test {
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	private static final String URL = "jdbc:sqlserver://127.0.0.1\\\\SQLEXPRESS:1433;databaseName=kokofp";

	private static final String USERNAME = "sa";

	private static final String PASSWORD = "Password123";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void genSPAction(String payload) throws Exception {

		try {
			JSONObject payloadObj = new JSONObject(payload);

			String procedure = "", parameters = "";
			int noOfParams = 0;
			JSONArray params;		

			procedure = payloadObj.getString("action").concat(" ");
			params = payloadObj.getJSONArray("params");
			noOfParams = params.length();		

			for(int i=0; i < noOfParams; i++) {
				String paramType = params.getJSONArray(i).getString(1); 			
				Object param = null;

				switch (paramType) {
				case "String":
					param = params.getJSONArray(i).getString(0);
					break;

				case "Number":
					param = params.getJSONArray(i).getInt(0);
					break;
				default:
					param = params.getJSONArray(i).getString(0);
					break;
				}

				parameters = parameters + " " + param.toString() + ", ";
			}

			parameters = parameters.substring(0, parameters.length() - 2);

			System.out.println(procedure + " " + parameters + " here");

			Class.forName(DRIVER);
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);


			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(procedure + " " + parameters);


			ResultSetMetaData metadata = resultSet.getMetaData();
			int columnCount = metadata.getColumnCount();

			ArrayList<String> columns = new ArrayList<String>();
			for (int i = 1; i < columnCount; i++) {
				String columnName = metadata.getColumnName(i);
				columns.add(columnName);
			}

			while (resultSet.next()) {
				for (String columnName : columns) {
					String value = resultSet.getString(columnName);
					System.out.println(columnName + " = " + value);
				}
			}

			connection.close();

		}catch (Exception e) {
			// TODO: handle exception
		}

	}


	public String test(String payload) {
		try {
			JSONObject payloadObj = new JSONObject(payload);

			String procedure = "", parameters = "";
			int noOfParams = 0;
			JSONArray params;		

			procedure = payloadObj.getString("action").concat(" ");
			params = payloadObj.getJSONArray("param");
			noOfParams = params.length();		

			if (noOfParams > 0) {
				for(int i=0; i < noOfParams; i++) {
					JSONObject parameter = params.getJSONObject(i);				
					String param = parameter.getString((String) parameter.keys().next());

					parameters = parameters + " " + param+ ", ";
				}

				parameters = parameters.substring(0, parameters.length() - 2);
			}


			return jdbcTemplate.query(procedure + " " + parameters,new ResultSetExtractor<String>(){  

				public String extractData(ResultSet rs) throws SQLException,  
				DataAccessException {  

					ResultSetMetaData metadata = rs.getMetaData();
					int columnCount = metadata.getColumnCount();

					System.out.println(columnCount + " columnCount");
					JSONArray resJson = new JSONArray();

					ArrayList<String> columns = new ArrayList<String>();
					for (int i = 1; i <= columnCount; i++) {
						String columnName = metadata.getColumnName(i);
						System.out.println(columnName + " cn");
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
								// TODO Auto-generated catch block
								e.printStackTrace();
								

							}


							System.out.println(columnName + " = " + value);
						}

						resJson.put(resJsonObject);
					}

					return resJson.toString();
				} 
			});  

		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;


	}
}
