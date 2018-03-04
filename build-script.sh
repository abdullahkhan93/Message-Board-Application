#!/bin/bash

echo "Starting cleaning compilation and build process..." 

mvn clean compile install

echo "WAR file generated! It is located in the target folder in this directory"






