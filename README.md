# BMP Image Handler

The **BMP** file format is a bitmap image developed by Microsoft used in Windows OS for storing icons.
This Java program reads the bytes of an BMP image and returns 4 copies of the same image in 3 diferen hues:
* Red
* Green
* Blue
* Sepia

## Project Structure

* **ImageHandler**: Abstact class from which all handlers in this project must inherit from.
* **BmpHandler**: Main class.
* **BmpImageHandlerColors**: Class that generates the images in different colors.



## Compile

```console
foo@bar:~$ javac BmpHandler.java BmpImageHandlerColors.java ImageHandler.java

``` 

## Run

```console
foo@bar:~$ java BmpHandler -colors ImageName.bmp

``` 

## References

1. Wikipedia. "Windows Bitmap" https://en.wikipedia.org/wiki/BMP_file_format (2017)