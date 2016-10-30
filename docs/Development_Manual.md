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

### Version Control

First make sure you have *git* installed:
```
git --version
```
You should see something like the following:
```
git version 2.6.2
```
If your output is not similar to the one above you will have to install git on your machine. There are great instructions for that in the  [Git documentation.](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)

You should also create a [GitHub](https://github.com/) account.

### Get the project

Fork the *TicTacToe* repository at https://github.com/iFellTower/TicTacToe to your own account.

After forking the repo you should clone it to your machine:

```
git clone git@github.com:<YourUsername>/TicTacToe.git
```
Where `<YourUsername>` is your GitHub username.

### Build the project
#### Java 8
We recommend using Java 8 to run this project.
To check your version of Java:
```
java -version
```
To install Java 8 run the following commands:
```
sudo add-apt-repository ppa:webupd8team/java
sudo apt-get update
sudo apt-get install oracle-java8-installer
```
#### Gradle
Relocate to the project root directory and run the build command using the *gradle wrapper*.
```
./gradlew build
```
You can then use the *gradle wrapper* to build, test or run the project. You can see all available task for the *gradle wrapper* by running the following command:

```
./gradlew tasks
```

You can also install *Gradle* on your computer:

```
curl -s https://get.sdkman.io | bash
source "~/.sdkman/bin/sdkman-init.sh"
sdk install gradle 3.1
```
Where the source command should refer to your installation folder for *Gradle* After you have done that you can run *Gradle* commands using the keyword `gradle`

#### Build and Deploy

After doing everything mentioned above you can run the following command from the root of the project on *linux*...
```
./bin/build_and_deploy
```
... and for *Windows* you run:
```
./bin/build_and_deploy.bat
```
This script cleans the project, builds it, tests it and finally deploys it. It also gives you links to the documentation created during the build.
