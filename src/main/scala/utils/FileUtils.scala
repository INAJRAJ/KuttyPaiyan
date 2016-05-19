package com.KP.Utils

import scala.collection.immutable.List

object FileUtils {
  
  def loadProperties(mapSettings:scala.collection.mutable.Map[String, String], fileName:String) = {

    var mapTemp = scala.collection.mutable.Map[String, List[String]]()
    for (line <- scala.io.Source.fromFile(fileName).getLines)
      mapTemp += (line.split(":")(0) -> line.split(":")(1).split(",").toList)

    //move mapTemp to mapSettings

    for ((actionCode, lstWord) <- mapTemp) {
      for (str <- lstWord) {
        mapSettings(str) = actionCode
      }
    }
  }
  
}