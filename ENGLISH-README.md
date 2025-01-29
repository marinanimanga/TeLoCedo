TLoCdo
TLoCdo is an app created with the purpose of providing an outlet for texts written by others who don't have the opportunity to publish them. 
Through this app, these writers can upload their texts for free and read those of others.

This repository contains the Java source code for the application.

PROJECT STRUCTURE
bash
Copiar
Editar
TLoCdo/
├── src/                # Project source code
│   ├── principal/      # MAIN classes
│   ├── controlador/    # Application controllers
│   ├── modelo/         # Model classes
│   ├── vista/          # Graphical interface classes
│     ├── ventanas/     # Application windows
│     └── laminas/      # Panels and layers of the interface

REQUIREMENTS
Java 23 or higher
PDFBox version 2.0.31 and pdfbox-app-2.0.31. The project uses this library to convert PDFs to plain text and vice versa.

INSTRUCTIONS
To ensure you have the correct Java version (Java 23), run the following in the terminal:
java -version

To compile the project, I recommend using an IDE, as this project has many .java files. In my case, I have used IntelliJ.

Clone the project from GitHub:
Open IntelliJ IDEA.
On the IntelliJ welcome screen, select "Get from VCS".
In the "URL" field, enter the GitHub repository URL. It should look something like: https://github.com/username/repository-name.git
Select the directory where you want the cloned project to be saved on your local machine.
Click "Clone". IntelliJ will download the repository from GitHub and open it automatically.

Dependencies:
You now need to attach the PDFBox library dependencies so that your project recognizes them. To do this, go to:
File > Project Structure > Modules > Dependencies > + > JARs or Directories, select the PDFBox .jar file, and click "OK".

Compile:
Finally, you should now be able to run the project from IntelliJ. If not, go to BUILD > Build Project.

If you encounter issues with external dependencies, make sure they are included in the classpath when running the project.

Making Changes and Syncing with GitHub:
If you make changes and want to push them back to GitHub:

Make changes to the source code or project files.
To push changes to GitHub, go to VCS > Commit (or use the shortcut Ctrl + K).
Review the changes, add a commit message, and then click Commit.
If you want to push the changes to GitHub, select VCS > Git > Push (or use Ctrl + Shift + K).

CONTRIBUTING
If you want to contribute to the project, you're welcome! Just make sure to follow these guidelines:
Fork the repository.
Create your own branch (git checkout -b feature/new-feature).
Make your changes and commit them.
Push your changes to your repository and open a pull request.
