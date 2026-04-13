# Simple File I/O

A Java command-line program for writing to and reading from text files, with input validation, overwrite protection, and paginated output.

## What It Does

- Write text to any file line by line
- Read text from any file with automatic pagination (pauses every 20 lines)
- Automatically adds `.txt` extension if not provided
- Detects if a file already exists before writing and asks whether to overwrite or choose a new filename
- Full input validation on all menu choices

## How to Run

```bash
javac SimpleFileIO.java
java SimpleFileIO
```

## Menu Options

```
1. Write text to file
2. Read text from file
3. About the program
4. Exit
```

## Example Usage

```
Please select one of the below options:
1. Write text to file
...
Enter your choice: 1

=== Write a Text File ===
Enter the filename to write to: notes
Enter the text to write to the file, enter STOP to exit:
> Hello world
> This is my file
> STOP
File writing complete. File saved as: notes.txt
```

## Why I Built It

Built as a Grade 11 Java project to practice file I/O using BufferedReader, FileReader, PrintWriter, and FileWriter. Also covers exception handling, input validation, and building a clean multi-option menu system.

## Built With

Java
