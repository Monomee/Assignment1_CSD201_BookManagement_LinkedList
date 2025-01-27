@echo off
cls
echo Compiling Java files...

:: Lấy đường dẫn thư mục gốc (thư mục chứa run.bat)
set "BASE_DIR=%~dp0"

:: Tạo thư mục build nếu chưa có
if not exist "%BASE_DIR%build\classes" mkdir "%BASE_DIR%build\classes"

:: Biên dịch các file Java từ src vào build/classes
javac -d "%BASE_DIR%build\classes" "%BASE_DIR%src\bookmanagement\*.java"

if %errorlevel% neq 0 (
    echo Compilation failed. Please check your code for errors.
    pause
    exit /b
)

echo Running program...
:: Chạy chương trình từ build/classes
java -cp "%BASE_DIR%build\classes" bookmanagement.Main
pause
