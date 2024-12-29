@echo off

echo [INFO] Setting variables
set "input_css=scripts\input.css"
set "output_css=src\main\webapp\assets\css\tailwind.output.css"

echo [INFO] cd to scripts
cd scripts

@REM 如果存在 node_modules 则不执行下面这一步

if exist node_modules (
    echo [INFO] node_modules exists
) else (
    echo [INFO] node_modules not exists
    echo [INFO] Will install libs
    call %current_dir%setup_loader.bat
)

echo [INFO] cd to project_dir.
cd ..

echo [INFO] Start tailwindcss
tailwindcss -c %current_dir%\tailwind.config.js -i %input_css% -o %output_css% --watch

echo [INFO] Exit
exit /b