package com.KP.Action

import scala.io.StdIn._
object FindActionImplementor {
  
  //Find Action Processing
  def FindFile = {
    //get the facts about the file and put them in the action context
     var ln = readLine(s">> Could you give me the file name?")
     ActionContext.contextValues("filename") = ln; 
     ln = readLine(s">> Is there a folder or path you want to me start looking?")
     ActionContext.contextValues("folder") = ln;
     val x = searchFile
     println(x)
  }
  
  def searchFile() = {
    //search file will return the entire path with the filename
    "sorry not able to find your file"
  }
  
  
}