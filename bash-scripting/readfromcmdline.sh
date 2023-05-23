#!/bin/bash

# Reading from commandline. Interactive mode
echo Hey. What is your first name?
read FIRST_NAME

echo And what is your last name?
read LAST_NAME

echo And may I know your monthly salary?
read SALARY

echo Thanks. Let me repeat before I confirm in the system.
echo Your name is $FIRST_NAME $LAST_NAME
echo Your yearly income is $((SALARY * 12))

