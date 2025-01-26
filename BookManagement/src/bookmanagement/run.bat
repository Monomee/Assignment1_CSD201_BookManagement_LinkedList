@echo off
cls
echo Compiling Java files...

set "BASE_DIR=%~dp0"


javac -d "%BASE_DIR%BookManagement" "%BASE_DIR%BookManagement\src\bookmanagement\*.java"

if %errorlevel% neq 0 (
    echo Compilation failed. Please check your code for errors.
    pause
    exit /b
)

echo Running program...
java bookmanagement.Main
pause
