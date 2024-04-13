package com.ram.challenges.jsonparser;

public class JsonParserMain {

    public static void main(String[] args) {
        System.out.println(emptyJson("}{}"));
    }

    public static boolean emptyJson(String json) {
        return !json.isEmpty();
    }

    public static boolean validEnclosingChars(String json) {
        return !(json.charAt(0) == '{' && json.charAt(json.length()-1) == '}');
    }

    public static boolean validJson(String valueString) {
        StringBuilder key = new StringBuilder();
        if(valueString == null || valueString.isEmpty()) {
            return false;
        } else {
            for(int i=0; i < valueString.length();i++) {
                if(i == 0 && valueString.indexOf(i) == '{') {
                    continue;
                } else {
                    return false;
                }


            }
        }
        return false;
    }
}

/*
1. Current char and top of stack
   { - Stack is empty
   Top of stack is { and current char is " so key begins till another " is encountered.
   key1 = "key"
   Push the ending " to the top of stack
   if char is : push the char to the top of stack
     if top of stack is :
        store the value in a value variable.
        if , value ends. reset the value
   " - top of stack is { key begins, store the value of the key and push the " to top of stack



Invalid

{
  "key": "value",
  "key-n": 101,
  "key-o": {
    "inner key": "inner value"
  },
  "key-l": ['list value']
}

{
  "key1": true,
  "key2": False, //small chars
  "key3": null,
  "key4": "value",
  "key5": 101
}

{
  "key": "value",
  key2: "value"
}

{
  "key": "value",
  key2: "value"
}


{"key": "value"}




{"key": "value",}


Valid


{}


{
  "key": "value",
  "key-n": 101,
  "key-o": {
    "inner key": "inner value"
  },
  "key-l": ["list value"]
}

{
  "key": "value",
  "key-n": 101,
  "key-o": {},
  "key-l": []
}

{
  "key1": true,
  "key2": false,
  "key3": null,
  "key4": "value",
  "key5": 101
}
 */
