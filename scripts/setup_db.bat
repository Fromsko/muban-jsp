@echo off

@REM 获取当前项目的文件名
for %%i in (.) do set "project_name=%%~ni"
echo [INFO] Project name: %project_name%

set "sql_file_sqlite=src/main/resources/sql/init_sqlite.sql"
set "sql_file_mysql=src/main/resources/sql/init_sqlite.sql"

@REM 执行 SQL 语句
echo [INFO] Execute SQL file: %sql_file_sqlite% to %project_name%.db
sqlite3 %project_name%.db < %sql_file_sqlite%

@REM MySQL
@REM echo [INFO] Execute SQL file: %sql_file_mysql%
@REM mysql -u root -p123456 -h 127.0.0.1 -P 3306 -D jsp_template < %sql_file_mysql%

echo [INFO] Exit
exit /b