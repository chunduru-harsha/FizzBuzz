# FizzBuzz
## Java 8 Springboot application for fizzbuzz assignment
 Deployed and hosted the application using Docker into Aws Elastic Container Service
------------------------------------------------------------------
Please use the below link to access the swagger for the application that deployed in AWS ECS
http://54.89.85.76:8080/swagger-ui/#/fizz-buzz-api-controller/getFizzBuzzUsingPOST

--------------------------------------
Example request curl -X POST "http://54.89.85.76:8080/exercise" -H "accept: /" -H "Content-Type: application/json" -d "[ \"1\", \"A\", \"23\", \"5\", \"3\", \"15\"]"

Expected output - [
  "Divided 1 by 3 Divided 1 by 5",
  "Invalid Item",
  "Divided 23 by 3 Divided 23 by 5",
  "Buzz",
  "Fizz",
  "FizzBuzz"
]
