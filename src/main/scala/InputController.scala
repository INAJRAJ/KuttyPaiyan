package com.KP.Action


import scala.io.StdIn._
import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props

object InputGateway {
  
  def processInput(ln:String) =  {
    
    var actionCode ="00"
    
    if (ActionContext.currentContext == null) 
        actionCode = ActionContext.checkforAction(ln)
        
    if (actionCode == "00") {
              val x = ln.toLowerCase() match {
              case "hi" => "Hi"
              case "hello" => "Hello"
              case "bye" => "bye"
              case _ => "Don't understand what you are saying!"
         }
         println(x)
         x
    }
    else //we have action
    {
        ActionContext.currentContext = actionCode
        actionCode
    }
      
    }
 }