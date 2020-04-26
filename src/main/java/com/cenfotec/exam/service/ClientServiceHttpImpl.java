package com.cenfotec.exam.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ClientServiceHttpImpl {

	public String getGUID() throws Throwable {

		try {
			URL url = new URL("http://localhost:9192/api/guids");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setConnectTimeout(4000);
			conn.setReadTimeout(4000);

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String string;

			StringBuffer bufferedString = new StringBuffer();
			while ((string = br.readLine()) != null) {
				bufferedString.append(string);
			}

			br.close();
			conn.disconnect();

			String response = bufferedString.toString();

			if (response == null || response.equals(""))
				throw new Exception("ERROR GETTING GUID");

			return response;

		} catch (Exception e) {
			throw new RuntimeException("SERVER NOT RUNNING");
		}

	}

}
