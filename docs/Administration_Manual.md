![RU](images/ru.PNG)
# Late-term Assignment: Development Manual
Reykjavík University, Department of Computer Science

Fall semesester 2016, Software Engineering T-303-HUGB

**Students:**

- Andri Karel Júlíusson
- Axel Björnsson
- Guðjón Steinar Sverrison
- Gunnar Davíð Gunnarsson
- Hlynur Stefánsson
- Sigurður Marteinn Lárusson
- Smári Björn Gunnarsson

### Architecture
The application is essentially divided into two layers. The layer that contains the *functionality* and *logic* of the program and a *UI* layer. The *logic* layer is written in *Java* and the *UI* layer is written in *HTML*, *CSS* and *JavaScript*. The *SparkJava* web framework is used to develop the solution as a web application.


### Application Host

The application is hosted in a runnable state at:
```
 https://ifelltowerttt.herokuapp.com/
 ```
so there is no need for installation.

The source code for the program is hosted at:
```
https://github.com/iFellTower/TicTacToe
```
and is public.

### Version Release
A new version is deployed to Heroku every time a pull request from a *feature branch*  is merged to the *master branch* and all tests on *Travis CI* are passed.

A new version can also be manually deployed at:
```
https://dashboard.heroku.com/apps/ifelltowerttt
```
but this requires a Heroku account and access to the *ifelltowerttt* app. This can be requested from iFellTower staff.
