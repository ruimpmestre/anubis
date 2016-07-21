#!/bin/sh
# --------------------------------------------------------------------------------------------------------------------
# Project: Exercise 1
# --------------------------------------------------------------------------------------------------------------------
# Company: AnubisNetworks.
# --------------------------------------------------------------------------------------------------------------------
# 
# This file contains the script for Exercise 1 
# 
# -------------------------------------------------------------------------------------------------------------------- 
# $Id$
# --------------------------------------------------------------------------------------------------------------------
#

# define the reference folder pointing to the installation directory
export EXERCISE_HOME=.

#clean
rm -rf src/pt/com/anubisnetworks/exercise/*.class

#compile
javac -cp $EXERCISE_HOME/lib/* src/pt/com/anubisnetworks/exercise/*.java

#execute
java -cp .:$EXERCISE_HOME/src:$EXERCISE_HOME/lib/* pt.com.anubisnetworks.exercise.ProjectManager "$@"