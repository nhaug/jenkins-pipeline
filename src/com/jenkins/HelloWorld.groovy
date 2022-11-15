package com.jenkins;

import hudson.*;
  
public class HelloWorld {
  static void helloWorld(def steps, name) {
    steps.echo "Hello World!"
    steps.echo "Hello "+name
  }
}
