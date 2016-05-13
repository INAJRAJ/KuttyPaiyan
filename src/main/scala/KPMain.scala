package com.KP.Actor

import scala.io.StdIn._
import com.KP.UI._


import com.KP.Utils._
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



