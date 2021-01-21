# lagersaldon

## Desctiption
This is a small console application that tracks inventory status.
It contains three commands:
1. Selling x number of goods by typing "S" and the number of goods + Enter, ex: "S5".
2. Delivering x number of goods by typing "I" (capital i) and the number of goods + Enter, ex: "I5".
3. Printing the current inventory by typing "L" + Enter.

The inventory always start at 0 when the program starts.

## Additional restrictions on commands:
1. User cannot sell or deliver a negative number of goods.
2. User cannot overdraw the inventory by selling more goods than are currently in it.


## Running project locally with gradle
    ./gradlew run

## building project
    ./gradlew build
Creates \build\distributions\lagersaldo.zip 
which contains the executable bin\lagersaldo

## Running tests
    ./gradlew test