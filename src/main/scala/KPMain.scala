package com.KP.Actor

import com.KP.UI.KPWindow
import com.KP.Utils.FileUtils


import com.KP.UI

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props

object KPMain {

  var mapActionSettings = scala.collection.mutable.Map[String, List[String]]()

  def main(args: Array[String])
  {

    FileUtils.loadProperties(mapActionSettings,"ActionCodes.txt")

    println(mapActionSettings)

    new KPWindow().setVisible(true)

  }

}



