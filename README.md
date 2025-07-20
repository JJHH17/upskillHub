# upskillHub
Upskill is a platform that allows users to enter the skill they wish to learn, and courses are
fed back based on that input.

Users populate a presented field, enter credentials and fill out the relevant learning fields.

We then provide courses to users based on the skill they wish to learn, which will be managed via the PluralSights
API.

```Project Goals```

- Use a hosted Postgresql server to store data.
- Use JavaFX to build a desktop app based front end to the application.
- Use an external API (such as with PluralSight) to fetch recommended courses to users, based on what 
skills they wish to learn.

```Installation Steps```
- You will find JUNIT installed under the "lib" directory of the project.

- You will also find JavaFX installed under "lib", which can be installed via: https://openjfx.io/
1. Install JavaFX (SDK version 24.0.2)
2. Extract the Zip and add it to the lib directory
3. Select "File -> Project Structure -> Libraries" Add the JavaFX .jar files (found in the lib directory of the JavaFX package).
4. Select "Run -> Edit Configurations".
5. Find the main application, select "VM Options" and add: --module-path "path/to/your/javafx-sdk-24.0.2/lib" --add-modules javafx.controls,javafx.fxml

