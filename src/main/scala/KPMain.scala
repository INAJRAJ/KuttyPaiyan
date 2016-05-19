package com.KP.main

import com.KP.UI._

import com.KP.Utils.FileUtils

object KPMain {

  var mapActionSettings = scala.collection.mutable.Map[String, String]()

  def main(args: Array[String])
  {

    FileUtils.loadProperties(mapActionSettings,"ActionCodes.txt")

    println(mapActionSettings)

    new  KPWindow().setVisible(true)

  }

}



