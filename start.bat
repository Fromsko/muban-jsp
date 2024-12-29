@echo off

@REM 做一个上下选择的菜单来执行指定的命令,命令会单独开启一个终端执行 start

echo [INFO] Select a command to execute:
echo [1] Start
echo [2] Stop
echo [3] Restart
echo [4] setup loader
echo [5] Setup db
echo [6] quit

set /p command=Input command:
if %command%==1 (
    start cmd /k "scripts\start.bat"
) else if %command%==2 (
    start cmd /k "scripts\stop.bat"
) else if %command%==3 (
    start cmd /k "scripts\restart.bat"
) else if %command%==4 (
    start cmd /k "scripts\setup_loader.bat"
) else if %command%==5 (
    start cmd /k "scripts\setup_db.bat"
) else if %command%==6 (
   exit /b
) else (
    echo [ERROR] Invalid command
)

exit /b