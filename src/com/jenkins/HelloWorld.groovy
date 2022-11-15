package com.jenkins;

import hudson.*;
  
public class HelloWorld {
  static void helloWorld(def steps) {
    steps.echo "Hello World!"
    steps.echo "Hello "+steps.config.name
  }
}
