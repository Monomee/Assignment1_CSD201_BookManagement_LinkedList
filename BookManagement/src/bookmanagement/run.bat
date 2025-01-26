@echo off
cls
echo Compiling Java files...
javac -d . D:\JavaNetbean\SE1942-HoangNVHE191065-AS1\BookManagement\src\bookmanagement\*.java
if %errorlevel% neq 0 (
    echo Compilation failed. Please check your code for errors.
    pause
    exit /b
)
echo Running program...
java bookmanagement.Main
pause
