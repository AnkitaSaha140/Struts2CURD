package com.test;

import org.apache.log4j.Logger;

import java.io.*;
import java.sql.SQLException;

public class Log4j2HelloWorldExample{

   /* Get actual class name to be printed on */
   static Logger log = Logger.getLogger(Log4j2HelloWorldExample.class.getName());
   
   public static void main(String[] args)throws IOException,SQLException{
      log.debug("Hello this is new debug message");
      log.info("Hello this is new info message");
   }
}