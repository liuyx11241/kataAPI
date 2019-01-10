#!/usr/bin/python

from __future__ import print_function

import json
import sys

import requests

API_URL = "http://localhost:8080/api/v1/"

if sys.version_info.major == 2:
    def prompt(s=">>> "):
        return raw_input(s)
else:
    def prompt(s=">>> "):
        return input(s)


def menu():
    print("What can I do for you?");
    print("1 : See all the rooms");
    print("2 : Book a room");
    print("3 : Cancel your booking");


def listRooms():
    res = requests.get(API_URL + "rooms");
    print(res.json());


def createBooking():
    print("for which room (input room id)?");
    idRoom = prompt();
    print("for which day (yyyyDDmm)");
    date = prompt();
    print("from which o'clock:");
    startTime = prompt();
    print("to which o'clock:");
    endTime = prompt();
    print("what's your name?");
    personName = prompt();

    payload = {'idRoom': idRoom, 'date': date, 'startTime': startTime, 'endTime': endTime, 'personName': personName}
    headers = {'content-type': 'application/json'}

    res = requests.post(API_URL + 'bookings', data=json.dumps(payload), headers=headers);
    print(res)
    if (res.status_code == 201):
        print("Created!")
        print(res.json());
    if(res.status_code==400):
        print("your input is not valid");
    if (res.status_code == 409):
        print("Conflit, Available Time :")
        print(res.json());


def cancelBooking():
    print("which booking (booking id) ?")
    idBooking = prompt();
    print("Are you sure? y/n");
    if 'y' == prompt():
        res = requests.delete(API_URL + 'bookings/' + idBooking);
        if (res.status_code == 202):
            print("Cancelled!")
            print(res.json())
        else:
            print("Error, check your booing id and retry");


def acceptInput(line):
    if "1" == "".join(line):
        listRooms();
    if "2" == "".join(line):
        createBooking();
    if "3" == "".join(line):
        cancelBooking();


if sys.stdin.isatty():
    try:
        import readline
    except ImportError:
        pass
    while True:
        try:
            menu();
            line = prompt()
        except EOFError:
            print();
            break
        if line: acceptInput(line)
else:
    menu();
    for line in (l.rstrip("\n") for l in sys.stdin):
        acceptInput(line)
        menu();
