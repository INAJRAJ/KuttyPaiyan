package com.KP.Actor

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props


object TeacherActor {
  
  case class QuoteRequest()
  case class QuoteResponse(quoteString:String)

}

class TeacherActor extends Actor {

  val quotes = List(
    "Moderation is for cowards",
    "Anything worth doing is worth overdoing",
    "The trouble is you think you have time",
    "You never gonna know if you never even try")

  def receive = {

    case TeacherActor.QuoteRequest => {

      import util.Random

      //Get a random Quote from the list and construct a response
      val quoteResponse=TeacherActor.QuoteResponse(quotes(Random.nextInt(quotes.size)))

      println (quoteResponse)

    }

  }

}