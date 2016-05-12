package com.KP.Action

object ActionContext {
  //to store the current action context and any values associated with it
  var currentContext:String = null;
  val contextValues = scala.collection.mutable.Map[String,String]()
  
  //check the first word in the given string is action verb
  //action verbs are find, search as of now
  
  //need to have two sets of words .. one related verbs for a particular action.. then nouns/objects for the verbs
  
  
  def checkforAction(x:String) = {
    //check for case find/search/look
    var actionCode:String = "00"
    if (x.contains("find") || x.contains("search") || x.contains("look"))
        {
          if (x.contains("file"))
          { 
            actionCode = "DA"}
          if (x.contains("folder") || (x.contains("directory")))
             actionCode = "DB"
        }
    println(actionCode)
    actionCode
    
    //val arrList = x.split(" ")
    //arrList(0).toLowerCase() match {
     // case "find" => true
     // case "search" => true
     // case _ => false } 
    
  }
 
  def processAction(actionCode:String) = {
    ActionContext.currentContext = actionCode
    actionCode match {
      case "DA" => FindActionImplementor.FindFile
      case "DB" => println("find folder")
      
    }
    "done"
  }
  
}