package com.thesamoanppprogrammer.practicegroovy.restapi

def postRequest = new URL('https://61e281e83050a100176821ca.mockapi.io/todos')
def postConnection = postRequest.openConnection()
postConnection.requestMethod = 'POST'
assert postConnection.responseCode == 200

//def todo = "todo=Groovy Todo"
//def completed = false

def params = ["todo": "Groovy Todo", "completed": false]
postConnection.doOutput = true
def text
postConnection.with {
    outputStream.withWriter { outputStreamWriter ->
        outputStreamWriter << params
    }
    text = content.text
}
assert postConnection.responseCode == 200

