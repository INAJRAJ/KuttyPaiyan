package com.KP.Actor

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props

import TeacherActor._
import scala.io.StdIn._
import com.KP.UI._


object AkkaSample {
  
  
  def main(args: Array[String]) 
  {
     //Initialize the ActorSystem
  val actorSystem=ActorSystem("UniversityMessageSystem")

  //construct the Teacher Actor Ref
  val teacherActorRef=actorSystem.actorOf(Props[TeacherActor], name = "mainactor")

  //send a message to the Teacher Actor
  teacherActorRef!QuoteRequest

  //Let's wait for a couple of seconds before we shut down the system
  Thread.sleep (2000) 

  //Shut down the ActorSystem.
  actorSystem.shutdown()
   
  new KPWindow().setVisible(true)
  
  }
  
}




