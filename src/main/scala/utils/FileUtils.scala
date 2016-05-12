package com.KP.Utils

import scala.collection.immutable.List

object FileUtils {
  
  def loadProperties(mapSettings:scala.collection.mutable.Map[String, List[String]], fileName:String) = {
   
   for(line <- scala.io.Source.fromFile(fileName).getLines)
      mapSettings += (line.split(":")(0) -> line.split(":")(1).split(",").toList)
  	
  	}   
  
  
}