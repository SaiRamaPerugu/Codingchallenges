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
}

/*


1
2
3
4
5
6
7
8

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
