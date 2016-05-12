package main.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import scala.actors.threadpool.Arrays;

public class JavaUtils {
	
	/*public Map<String,List<String>> LoadSettings(String strfileName)
	{
		//load the response settings and error pattern strings
		try {
			
			Map<String, List<String>> mapSettings = Files.lines(Paths.get(strfileName))
					.collect(Collectors.toMap(k -> k.split(",")[0], v -> Arrays.asList(v.split(",")[1])));
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}*/
}
