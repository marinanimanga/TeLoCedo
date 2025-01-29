TLoCdo
Es una app creada con la finalidad de dar salida a los textos creados por otras personas que no tienen posibilidad de publicarlos. Mediante esta app, estos escritores 
pueden subir sin costo alguno sus textos y leer el de otros. 

Este repositorio contiene el código fuente en java de la aplicación.

ESTRUCTURA DEL PROYECTO
TLoCdo/
├── src/                # Código fuente del proyecto
│   ├── principal/      # Clases MAIN
│   ├── controlador/    # Controladores de la aplicación
│   ├── modelo/         # Clases de modelo
│   ├── vista/          # Clases de la interfaz gráfica
│     ├── ventanas/     # Ventanas de la aplicación
│     └── laminas/      # Paneles y laminas de la interfaz

REQUISITOS
Java 23 o superior
PDFbox2 version 2.0.31 y pdfbox-app-2.0.31. El proyecto utiliza esta librería para transformar los pdf en textos planos y viceversa. 

Para asegurarte que tienes la versión java correcta (Java 23) ejecuta en la terminal:
java -version

INSTRUCCIONES
Para compilar el proyecto, te recomiendo usar un IDE ya que este proyecto posee muchos archivos .java. En mi caso, he usado IntelliJ.
Clona el proyecto desde github:
1. Abre IntelliJ IDEA.
2. En la pantalla de inicio de IntelliJ, selecciona "Get from VCS" (Obtener desde el control de versiones).
3. En el campo "URL", ingresa la URL del repositorio de GitHub. Esto puede ser algo como: https://github.com/usuario/nombre-del-repositorio.git
4. Selecciona el directorio donde deseas que se guarde el proyecto clonado en tu máquina local.
5. Haz clic en "Clone". IntelliJ descargará el repositorio de GitHub y lo abrirá automáticamente.

Dependencias:
Ahora debes adjuntar las dependencias de la librería de pdfbox para que tu proyecto las reconozca. 
Para eso debes ir a File > Project Structure > Modules > Dependencies > + > JARs or Directories > seleccionar el .jar de pdfbox y aceptar

Compilar:
Finalmente, ahora debes poder ejecutar el proyecto desde IntelliJ. Si no, puedes ir a BUILD > Build project. 

Si tienes algún problema con las dependencias externas, asegúrate de que estén incluidas en el classpath al ejecutar el proyecto. 

Realizar cambios y sincronizar con Github
Si realizas cambios y deseas subirlos nuevamente a GitHub:
  Hacer cambios en el código fuente o en los archivos del proyecto.
  Para subir los cambios a GitHub, ve a VCS > Commit (o usa el atajo Ctrl + K).
  Revisa los cambios, agrega un mensaje de commit y luego haz clic en Commit.
  Si deseas enviar los cambios a GitHub, selecciona VCS > Git > Push (o usa Ctrl + Shift + K).

CONTRIBUIR
Si quieres contribuir al proyecto, ¡serás bienvenido! Solo asegúrate de seguir estas pautas:

Haz un fork del repositorio.
Crea tu propia rama (git checkout -b feature/nueva-funcionalidad).
Haz tus cambios y realiza un commit.
Sube tus cambios a tu repositorio y abre un pull request.
